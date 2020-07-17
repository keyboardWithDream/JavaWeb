package cn.study.l16.web.servlet;

import cn.study.l16.domain.User;
import cn.study.l16.service.UserService;
import cn.study.l16.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Harlan
 * @date 2020/7/17 18:21
 */
@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用UserService完成查询
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();
        //2.将list存入request域
        req.setAttribute("users", users);
        //3.转发到list.jsp页面
        req.getRequestDispatcher("/info.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
