package cn.study.web.servlet;

import cn.study.dao.UserDao;
import cn.study.domain.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Harlan
 * @date 2020/7/16 14:56
 */
@WebServlet(name = "/LoginServlet", urlPatterns = ("/login"))
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取提交信息
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> loginMap = new HashMap<>(req.getParameterMap());

        //判断信息是否有空值
        boolean flag = true;
        for (String key : loginMap.keySet()) {
            System.out.println(key);
            if (loginMap.get(key) == null){
                System.out.println("表单有空值");
                flag = false;
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
                break;
            }
        }

        if (flag){
            //从Session获取验证码
            Object code = req.getSession().getAttribute("code");
            //删除session中的验证码
            req.getSession().removeAttribute("code");
            String loginCode = loginMap.get("checkCode_input")[0];
            if (code == null){
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
            else if (code.equals(loginCode)){
                //从Map中去除验证码，使用BeanUtils封装user数据
                loginMap.remove("checkCode_input");
                User loginUser = new User();
                try {
                    BeanUtils.populate(loginUser,loginMap);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }

                //验证数据是否正确
                UserDao userDao = new UserDao();
                User user = userDao.login(loginUser);
                if (user != null){
                    req.setAttribute("user", user);
                    req.getRequestDispatcher("/success.jsp").forward(req, resp);
                }else {
                    System.out.println("数据校验错误");
                    req.setAttribute("error","密码或用户名错误！");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }
            }else {
                System.out.println("验证码错误");
                req.setAttribute("error","验证码错误！");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
