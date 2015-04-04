package com.study.open.htmlparser.dao;

import java.io.File;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class JdbcConfigBean {

	private String driver;
	private String connUrl;
	private String username;
	private String password;
	
	public JdbcConfigBean(String configFile){
		PropertiesConfiguration config = null;//new XMLConfiguration("configure.xml");
		String filename = JdbcConfigBean.class.getResource(configFile).getPath();
		
		//System.out.println("String:"+filename);
		try {
			//config = new XMLConfiguration(filename);
			
			config = new PropertiesConfiguration();
			config.setFile(new File(filename));
			config.load();			
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		driver = ""+config.getProperty("JDBC.Driver");
		connUrl = ""+config.getProperty("JDBC.ConnectionURL");
		username = ""+config.getProperty("JDBC.Username");
		password = ""+config.getProperty("JDBC.Password");
	}
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getConnUrl() {
		return connUrl;
	}
	public void setConnUrl(String connUrl) {
		this.connUrl = connUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
