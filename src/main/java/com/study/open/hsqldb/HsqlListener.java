package com.study.open.hsqldb;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hsqldb.Server;

/**  
 * 该类的职责是在WebApp启动时自动开启HSQL服务. 依然使用Server方式，不受AppServer的影响.  
 */
public class HsqlListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		WebServerService.start();
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		WebServerService.stop();
  
	} 
	
}
