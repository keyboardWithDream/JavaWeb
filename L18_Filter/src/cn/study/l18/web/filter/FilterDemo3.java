package cn.study.l18.web.filter;

import jakarta.servlet.annotation.WebFilter;

import jakarta.servlet.*;
import java.io.IOException;

/**
 * @author Harlan
 * @date 2020/7/19 16:09
 */
@WebFilter(filterName = "FilterDemo3", urlPatterns = "/*")
public class FilterDemo3 implements Filter {

    /**
     * 在服务器启动后创建Filter对象调用init方法
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 每一次请求拦截资源时被执行
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");
        chain.doFilter(req, resp);
    }

    /**
     * 在服务器关闭后,Filter被销毁,正在关闭时执行destroy()方法
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
