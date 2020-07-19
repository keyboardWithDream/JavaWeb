package cn.study.l18.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Harlan
 * @date 2020/7/19 15:50
 */
@WebFilter("")
public class FilterDemo2 implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter2正在执行...");

        //放行
        chain.doFilter(req, resp);

        System.out.println("Filter2已执行完成...");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
