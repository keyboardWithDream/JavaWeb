package cn.study.l7.web.servlet;

import cn.study.l7.domain.Page;
import cn.study.l7.domain.User;
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
 * @date 2020/7/18 22:59
 */
@WebServlet(name = "/FindUsersByPageServlet", urlPatterns = ("/userPage"))
public class FindUsersByPageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");
        if (currentPage == null || "".equals(currentPage) || Integer.parseInt(currentPage) < 1){
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)){
            rows = "15";
        }
        UserService service = new UserServiceImpl();
        Page<User> page = service.findUsersByPage(currentPage, rows);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
