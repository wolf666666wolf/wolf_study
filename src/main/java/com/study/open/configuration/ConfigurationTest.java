package com.study.open.configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration.Node;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.lang.StringUtils;

public class ConfigurationTest {

	public static void main(String[] args){
		testXML();
		testConfiguration();
	}
	
	public static void testXML(){
		String fileName = "mailconfigure.xml";
		XMLConfiguration config = null;//new XMLConfiguration("configure.xml");
		String filename = ConfigurationTest.class.getResource(fileName).getPath();
		try {
			//config = new XMLConfiguration(filename);
			
			config = new XMLConfiguration();
			config.setFile(new File(filename));
			config.load();			
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		System.out.println("mailhost:"+config.getString("mail.mailhost"));
		System.out.println("mailhost.ip:"+config.getString("mail.mailhost[@ip]"));
		System.out.println("mailuser:"+config.getString("mail.mailuser"));
		System.out.println("mailpassword:"+config.getString("mail.mailpassword"));
		System.out.println("mailsubject:"+config.getString("mail.mailsubject"));
		System.out.println("mailtemplate:"+config.getString("mail.mailtemplate"));
		System.out.println("mailcc:"+config.getString("mail.mailcc"));
		
		Node node = new Node();
		node.setName("mailto");
		node.setValue("abc@tom.com");
		Collection col = new ArrayList();
		col.add(node);
		
		config.addNodes("mail.mailcc", col);
		
		try {
			config.save();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void testConfiguration(){
		String filename = ConfigurationTest.class.getResource("configure.properties").getPath();
		PropertiesConfiguration config = null;
		
		try {
			config = new PropertiesConfiguration(filename);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		System.out.println(StringUtils.center("testConfiguration", 60, "#"));
		System.out.println("JDBC.Driver:"+config.getProperty("JDBC.Driver"));
		System.out.println("JDBC_Driver:"+config.getProperty("JDBC_Driver"));
		System.out.println("JDBC.ConnectionURL:"+config.getProperty("JDBC.ConnectionURL"));
		System.out.println("JDBC.Username:"+config.getProperty("JDBC.Username"));
		System.out.println("JDBC.Password:"+config.getString("JDBC.Password"));
		
		if(config.getProperty("name")!=null){
			config.clearProperty("name");
		}
		
		config.addProperty("name", "alex");
		
		try {
			config.save();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}

