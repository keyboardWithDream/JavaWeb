package cn.study.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Harlan
 * @date 2020/7/15 11:02
 */
@WebServlet("/send")
public class SendCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("utf-8");
        //1.创建Cookie对象
        Cookie cName = new Cookie("name","Harlan");
        //设置cookie存活时间
        cName.setMaxAge(30);
        //2.发送Cookie
        resp.addCookie(cName);

        //第二个Cookie
        Cookie cPassword = new Cookie("password", "123456");
        //设置cookie存活时间
        cPassword.setMaxAge(0);
        resp.addCookie(cPassword);

        //存储中文数据
        Cookie cookie = new Cookie("msg","你好！");
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
