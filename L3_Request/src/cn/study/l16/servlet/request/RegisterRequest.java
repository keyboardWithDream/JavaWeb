package cn.study.l16.servlet.request;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Harlan
 * @date 2020/7/13 20:11
 */
@WebServlet("/registerRequest")
public class RegisterRequest extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //获取请求消息体--请求参数
//
//        //1.获取字符流
//        BufferedReader br = req.getReader();
//
//        //2.读取数据
//        String line = null;
//        while ((line = br.readLine()) != null){
//            System.out.println(line);
//        }

        req.setCharacterEncoding("utf-8");

        //防盗链
        String referer = req.getHeader("referer");
        if (referer != null && referer.contains("register")){

            //通用方法获取参数
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            System.out.println(username +"-"+ password);

            //获取复选框参数
            String[] hobby = req.getParameterValues("hobby");
            for (String s : hobby) {
                System.out.println(s);
            }

            System.out.println("================");

            //获取ServletContext对象
            ServletContext servletContext = req.getServletContext();
            System.out.println(servletContext);

            //存储数据到request域中
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            //请求转发
            req.getRequestDispatcher("/loginRequest").forward(req, resp);

        }else {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("错误访问！点击<a href=\"/register.html\">register</a>访问");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
