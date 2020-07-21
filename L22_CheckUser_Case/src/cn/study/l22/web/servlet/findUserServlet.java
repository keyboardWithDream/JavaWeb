package cn.study.l22.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Harlan
 * @date 2020/7/22 0:28
 */
@WebServlet(name = "/findUserServlet", urlPatterns = ("/findUserServlet"))
public class findUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=UTF-8");
        String username = req.getParameter("username");

        Map<String, Object> map = new HashMap<>();

        if ("admin".equals(username)){
            map.put("userExsit", false);
            map.put("msg", "用户名已存在！");
        }else {
            map.put("userExsit", true);
            map.put("msg", "用户名可用！");
        }

        //将map转为Json并响应
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), map);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
