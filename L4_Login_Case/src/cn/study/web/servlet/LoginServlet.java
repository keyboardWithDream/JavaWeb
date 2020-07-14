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
import java.util.Map;

/**
 * @author Harlan
 * @date 2020/7/14 1:26
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //1.获取所有请求参数
        Map<String, String[]> userMap = req.getParameterMap();

        //2.创建loginUser对象
        User loginUser = new User();

        //3.使用BeanUtils对数据封装
        try {
            BeanUtils.populate(loginUser, userMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        if (user != null){
            req.setAttribute("user", user);
            req.getRequestDispatcher("/successServlet").forward(req, resp);
        }else {
            req.getRequestDispatcher("/failServlet").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
