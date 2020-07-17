package cn.study.l16.servlet.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 重定向：自动跳转到ResponseTest
 * @author Harlan
 * @date 2020/7/14 15:29
 */
@WebServlet("/responseRedirect")
public class ResponseRedirect extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println("正在重定向...");
//        //1.设置状态码
//        resp.setStatus(302);
//        //2.设置响应头location
//        resp.setHeader("location","/l5/test");


        //动态获取虚拟目录
        String contextPath = req.getContextPath();
        //简单重定向方法
        resp.sendRedirect(contextPath+"/test");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
