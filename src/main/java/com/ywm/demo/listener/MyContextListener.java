package com.ywm.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听器-内容监听
 * 需要主类加入
 *
 * @ServletComponentScan
 */
@WebListener
public class MyContextListener implements ServletContextListener {
    private static Logger logger = LoggerFactory.getLogger(MyContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.setProperty("realPath", servletContextEvent.getServletContext().getRealPath("/"));
        logger.info("firstListener  初始化...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("FirstListener  销毁...");
    }
}
