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
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Harlan
 * @date 2020/7/18 17:50
 */
@WebServlet(name = "/AddUserServlet", urlPatterns = ("/addUser"))
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> userMap = req.getParameterMap();
        if (userMap.size() < 8){
            req.setAttribute("add_msg", "信息不完整!");
            req.getRequestDispatcher("/add.jsp").forward(req, resp);
        }else {
            User user = new User();
            try {
                BeanUtils.populate(user, userMap);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            UserService service = new UserServiceImpl();
            service.addUser(user);
            resp.sendRedirect(req.getContextPath() + "/userListServlet");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
