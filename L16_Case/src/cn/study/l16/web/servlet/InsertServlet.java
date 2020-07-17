package cn.study.l16.web.servlet;


import cn.study.l16.domain.User;
import cn.study.l16.service.UserService;
import cn.study.l16.service.impl.UserServiceImpl;
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
 * @date 2020/7/17 20:36
 */
@WebServlet(name = "/InsertServlet", urlPatterns = ("/insert"))
public class InsertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> userMap = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, userMap);
            System.out.println(user.toString());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service = new UserServiceImpl();
        boolean flag = service.insertUser(user);
        req.setAttribute("isSuccess",flag);
        req.getRequestDispatcher("/info.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
