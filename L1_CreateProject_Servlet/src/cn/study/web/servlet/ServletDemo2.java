package cn.study.web.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * Servlet的方法
 * @author Harlan
 * @date 2020/7/12 18:48
 */
public class ServletDemo2 implements Servlet {
    /**
     * 初始化方法
     * 在Servlet创建时被执行，只会执行一次
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init方法被执行...");
    }

    /**
     * 获取ServletConfig对象
     * ServletConfig：Servlet的配置对象
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * 每一次Servlet被访问时执行，可执行多次
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Service被执行...");
    }

    /**
     * 获取Servlet的一些信息：版本，作者等...
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器正常关闭时执行，执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy被执行...");
    }
}
