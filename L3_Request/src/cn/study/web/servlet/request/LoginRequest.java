package cn.study.web.servlet.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * @author Harlan
 * @date 2020/7/13 16:50
 */
@WebServlet("/loginRequest")
public class LoginRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String query = req.getQueryString();
        String uri = req.getRequestURI();
        StringBuffer url = req.getRequestURL();
        String protocol = req.getProtocol();
        String ip = req.getRemoteAddr();
        System.out.println("====请求行数据信息====");
        System.out.println("method:"+method+"\ncontextPath:"+contextPath+"\nservletPath:"+servletPath+"\nquery:"+query+"\nuri:"+uri+"\nurl:"+url+"\nprotocol:"+protocol+"\nip:"+ip);



        System.out.println("====请求头数据信息====");
        //获取所有的头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            //通过名称查找值
            String header = req.getHeader(name);
            System.out.println(name+":"+header);
        }


        //判断浏览器版本以适配浏览器解决兼容性
        String agent = req.getHeader("user-agent");
        if (agent.contains("Chrome")){
            System.out.println("浏览器版本为谷歌");
        }else if (agent.contains("Firefox")){
            System.out.println("浏览器版本为火狐");
        }else {
            System.out.println("其他浏览器");
        }


        //判断访问来源(防盗链操作)
        String referer = req.getHeader("referer");
        if (referer != null) {
            if (referer.contains("login") || referer.contains("register")){
                Object username = req.getAttribute("username");
                Object password = req.getAttribute("password");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("成功访问！"+username+"---"+password);
            }else {
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("错误访问！点击<a href=\"/login.html\">login</a>访问");
            }
        }else {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("错误访问！点击<a href=\"/login.html\">login</a>访问");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
