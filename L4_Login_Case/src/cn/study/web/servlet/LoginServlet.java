package cn.study.web.servlet;

import cn.study.dao.UserDao;
import cn.study.domain.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Harlan
 * @date 2020/7/14 1:26
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //封装User对象
        User userLogin = new User();
        userLogin.setUsername(username);
        userLogin.setPassword(password);

        UserDao userDao = new UserDao();
        User user = userDao.login(userLogin);
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
