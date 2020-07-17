package cn.study.l16.servlet.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 字符输出
 * @author Harlan
 * @date 2020/7/14 17:07
 */
@WebServlet("/writer")
public class ResponseWriter extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //获取流对象之前设置编码
        resp.setContentType("text/html;charset=utf-8");

        //获取字符输出流
        PrintWriter pw = resp.getWriter();
        //输出数据
        pw.write("<h1>Hello，Response!</h1><br><h1>你好，响应！</h1>");
        pw.write("你好，世界！");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
