package cn.study.l7.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Harlan
 * @date 2020/7/19 17:09
 */

@WebFilter (filterName = "FilterLogin", urlPatterns = "/*")
public class FilterLogin implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //获取请求路径
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();

        //判断是否包含登录相关的资源路径,注意排除css , jsp ,图片 , 验证码等资源
        if (uri.contains("/login") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet")){
            chain.doFilter(req, resp);
        }else {
            //从session获取User
            if (request.getSession().getAttribute("user") == null){
                //没有登录
                request.setAttribute("login_msg","您尚未登录,请登录");
                request.getRequestDispatcher("/adminlogin.jsp").forward(req, resp);
            }else {
                chain.doFilter(req, resp);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
