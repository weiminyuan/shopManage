package com.ywm.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 获取当前在线人数
 * 需要主类加入
 *
 * @ServletComponentScan
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    private Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);
    public static int peopleOnLine = 0;

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        logger.info("myHttpSessionListener.sessionCreated():" + arg0);
        peopleOnLine++;
        arg0.getSession().setAttribute("peopleOnLine", peopleOnLine);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        logger.info("myHttpSessionListener.sessionDestroyed():" + arg0);
        peopleOnLine--;
        arg0.getSession().setAttribute("peopleOnLine", peopleOnLine);
    }

}
