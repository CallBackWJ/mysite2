package com.douzon.mysite.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


//@WebListener
public class ContextLoaderListener implements ServletContextListener {

    public ContextLoaderListener() {
      
    }
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }

    public void contextInitialized(ServletContextEvent servletContextEvent)  { 
    	String s=servletContextEvent.getServletContext().getInitParameter("contextConfigLocation");
    	
    	System.out.println("container starts..."+s);
    }
	
}
