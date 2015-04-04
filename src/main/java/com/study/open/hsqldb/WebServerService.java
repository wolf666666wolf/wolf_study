package com.study.open.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hsqldb.Server;

public class WebServerService {
	private static Log log = LogFactory.getLog(WebServerService.class);
    private static String hsqldbPath = "E:/workspace/wolf-study/src/main/resources/study/hsql/data/";
    private static String hsqldbName = "mydb";
    private static int hsqldbPort = 9002;
    
    private static String hsqlUrl = "jdbc:hsqldb:hsql://localhost:9002/sells";
    private static String alsis_name = "sells";
    private static String hsqluserName = "sa";
    private static String hsqlPwd = "";
    
    public static void start(){
		Server server = new Server();
		server.setDatabaseName(0, alsis_name);
		server.setDatabasePath(0, hsqldbPath + hsqldbName);
//		if(-1!=port){
			server.setPort(hsqldbPort);
//		}
//		server.setSilent(true);
		server.start();
		System.out.println("hsqldb started...");  
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   	
    }
    
    
    public static void stop(){
		Connection conn = null;
		try{
		 
			conn = getConnection();
			Statement stmt = conn.createStatement();
			stmt.execute("SHUTDOWN");
		}catch(Exception e){
			e.printStackTrace();	
		}   	
    }
	public static Connection getConnection () {
		Connection conn = null;
		log.info(">>>>>>>>>>getconnection");
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conn = DriverManager.getConnection(hsqlUrl, hsqluserName, hsqlPwd);
		} catch (SQLException sqle) {
			log.error("获取Hsqldb 连接出错...", sqle);
			sqle.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}  
	
	public static void main(String[] args){
		start();
		
		Connection c = getConnection();
		Statement st;
		try {
			st = c.createStatement();

		//String sql ="SELECT * FROM Customer WHERE FIRSTNAME = 'Laura'";
		//String sql ="CREATE TABLE Customer(ID INTEGER PRIMARY KEY,FirstName VARCHAR(20),LastName VARCHAR(30),Street VARCHAR(50),City VARCHAR(25));";
		String sql ="SELECT * FROM Customer";
		ResultSet rs =  st.executeQuery(sql);
		while(rs.next()){
			System.out.println("ID:"+rs.getString(1) + " FirstName:" +rs.getString(2) +" LastName" +rs.getString(3) +" Street:"+rs.getString(4)+" Street:"+rs.getString(5));
			
		}	
		
		stop();	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
