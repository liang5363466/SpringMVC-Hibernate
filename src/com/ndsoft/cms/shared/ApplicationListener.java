package com.ndsoft.cms.shared;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

public class ApplicationListener extends ContextLoaderListener {
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("/==========================Web容器已开启==========================/");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("/==========================Web容器已关闭==========================/");
	}
}
