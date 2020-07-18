package cn.study.l7.web.servlet;


import cn.study.l7.domain.User;
import cn.study.l7.web.service.UserService;
import cn.study.l7.web.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Harlan
 * @date 2020/7/18 14:19
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取验证码并从req中删除
        String verifycode = req.getParameter("verifycode");
        req.removeAttribute("verifycode");
        //从Session中获取验证码并从中删除
        HttpSession session = req.getSession();
        String vcode = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        //获取请求信息的map
        Map<String, String[]> loginMap = req.getParameterMap();
        //空字符串
        String none = "";
        if (loginMap.size() < 2 || verifycode == null || loginMap.get("username") == null || loginMap.get("password") == null){
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
        }else {
            if(vcode.equalsIgnoreCase(verifycode)){
                User loginUser = new User();
                try {
                    BeanUtils.populate(loginUser, loginMap);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                User user = new UserServiceImpl().login(loginUser);
                if (user != null){
                    session.setAttribute("user", user);
                    resp.sendRedirect(req.getContextPath()+"/index.jsp");
                }else {
                    req.setAttribute("login_msg", "用户名或密码错误!");
                    req.getRequestDispatcher("/adminlogin.jsp").forward(req, resp);
                }
            }else {
                //验证码错误
                req.setAttribute("login_msg","验证码错误!");
                req.getRequestDispatcher("/adminlogin.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
