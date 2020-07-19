package cn.study.l19.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Harlan
 * @date 2020/7/19 21:27
 */
public class ContextLoaderListener implements ServletContextListener {

    /**
     * 监听ServletContext创建, ServletContext对象在服务器启动后自动创建
     * 这个方法在服务器启动后自动调用
     * @param sce servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext对象正在创建...");
    }

    /**
     * 在服务关闭后ServletContext正常销毁后,该方法自动调用
     * @param sce servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象正在销毁...");
    }
}
