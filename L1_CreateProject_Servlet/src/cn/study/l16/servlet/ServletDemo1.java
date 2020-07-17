package cn.study.l16.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * Servlet入门
 * @author Harlan
 * @date 2020/7/12 18:23
 */
public class ServletDemo1 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * @param servletRequest 请求
     * @param servletResponse 响应
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
