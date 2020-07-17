package cn.study.l16.servletcontext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Harlan
 * @date 2020/7/15 7:34
 */
@WebServlet("/context")
public class ServletC extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");


        //ServletContext对象的获取
        ServletContext context = this.getServletContext();

        //获取文件的MIME类型
        String type = context.getMimeType("a.jpg");
        System.out.println(type);
        resp.setContentType(type+";charset=utf-8");

        //获取文件真实路径
        String webPath = context.getRealPath("/web.txt");
        System.out.println(webPath);
        String webInfPath = context.getRealPath("/WEB-INF/web-inf.txt");
        System.out.println(webInfPath);
        String srcPath = context.getRealPath("/WEB-INF/classes/src.txt");
        System.out.println(srcPath);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
