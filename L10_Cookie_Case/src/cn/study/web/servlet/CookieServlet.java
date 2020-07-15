package cn.study.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Harlan
 * @date 2020/7/15 14:53
 */
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");


        String date = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date());

        Cookie[] cookies = req.getCookies();
        if (cookies == null){
            Cookie cookie = new Cookie("lastTime", date);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            resp.addCookie(cookie);
            resp.getWriter().write("<h1>您好，欢迎首次访问</h1>");
        }else {
            boolean flag = false;
            for (Cookie cookie : cookies) {
                if ("lastTime".equals(cookie.getName())){
                    System.out.println(cookie.getName()+"----"+cookie.getValue());
                    flag = true;
                    String lastTime = cookie.getValue();
                    cookie.setValue(date);
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    resp.addCookie(cookie);
                    resp.getWriter().write("<h1>欢迎回来，您上次访问的时间为："+lastTime+"</h1>");
                    break;
                }
            }
            if (!flag){
                Cookie cookie = new Cookie("lastTime", date);
                cookie.setMaxAge(60 * 60 * 24 * 30);
                resp.addCookie(cookie);
                resp.getWriter().write("<h1>您好，欢迎首次访问</h1>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
