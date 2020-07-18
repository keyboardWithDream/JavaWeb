package cn.study.l7.web.servlet;


import cn.study.l7.web.service.UserService;
import cn.study.l7.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Harlan
 * @date 2020/7/18 22:02
 */
@WebServlet(name = "/DelUsersServlet", urlPatterns = ("/delUsers"))
public class DelUsersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String[] ids = req.getParameterValues("ids");
        UserService service = new UserServiceImpl();
        service.delUsers(ids);
        resp.sendRedirect(req.getContextPath()+"/userListServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
