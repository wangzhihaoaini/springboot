package com.xuewuzhijing.springboot.system.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName Mylistener
 * @Description
 * @Author xuewuzhijing
 * @Date 19/11/4 23:05
 * @Version 1.0
 **/
public class Mylistener implements ServletContextListener {
    //        ServletContext对象的初始化
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized。。。web应用启动！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed。。。web应用关闭！");
    }
}
