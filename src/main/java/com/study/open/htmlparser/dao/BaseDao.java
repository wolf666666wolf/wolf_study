package com.study.open.htmlparser.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.study.open.log.LogTest;

public class BaseDao {
	private static Log log = LogFactory.getLog(BaseDao.class);
    private static String hsqlUrl = "jdbc:hsqldb:file:E:/workspace/wolf-study/src/main/resources/study/hsql/house/mydb;ifexists=true";
    private static String hsqlUser = "sa";
    private static String hsqlPwd = "";
	
	
	public static Connection getConnection () {
		Connection conn = null;
		log.info(">>>>>>>>>>getconnection");
		try {
			conn = DriverManager.getConnection(hsqlUrl, hsqlUser, hsqlPwd);
		} catch (SQLException sqle) {
			log.error("获取Hsqldb 连接出错...", sqle);
		}
		return conn;
	}	
	public static void stop() throws SQLException{
		Connection c = getConnection();
		Statement st = c.createStatement();		
		st.execute("SHUTDOWN;");		
	}
	
	
	public static void clearData() throws SQLException{
		BaseDao service = new BaseDao();
		Connection conn = service.getConnection();
		System.out.println("test start");
		String sql2 = "delete from Customer where id >= 10000";
		PreparedStatement pstate_del = conn.prepareStatement(sql2);
		pstate_del.executeUpdate();	
		conn.close();
	}
	public static void printCustomerAll() throws SQLException{
		BaseDao service = new BaseDao();
		Connection c = service.getConnection();
		Statement st = c.createStatement();
		//String sql ="SELECT * FROM Customer WHERE FIRSTNAME = 'Laura'";
		//String sql ="CREATE TABLE Customer(ID INTEGER PRIMARY KEY,FirstName VARCHAR(20),LastName VARCHAR(30),Street VARCHAR(50),City VARCHAR(25));";
		String sql ="SELECT * FROM Customer";
		ResultSet rs =  st.executeQuery(sql);
		while(rs.next()){
			System.out.println("ID:"+rs.getString(1) + " FirstName:" +rs.getString(2) +" LastName" +rs.getString(3) +" Street:"+rs.getString(4)+" Street:"+rs.getString(5));
		}
		c.close();
	}
	public static void closeConn(Statement state, Connection conn) throws SQLException{
		try{
			
			if(state != null){
				state.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(SQLException sqle){
			throw sqle;
		}		
	}	
	public static void main(String[] args) throws SQLException{
		Connection c = getConnection();
		Statement st = c.createStatement();
		//String sql ="SELECT * FROM Customer WHERE FIRSTNAME = 'Laura'";
		//String sql ="CREATE TABLE Customer(ID INTEGER PRIMARY KEY,FirstName VARCHAR(20),LastName VARCHAR(30),Street VARCHAR(50),City VARCHAR(25));";
		String sql ="SELECT * FROM Customer";
		ResultSet rs =  st.executeQuery(sql);
		while(rs.next()){
			System.out.println("ID:"+rs.getString(1) + " FirstName:" +rs.getString(2) +" LastName" +rs.getString(3) +" Street:"+rs.getString(4)+" Street:"+rs.getString(5));
			
		}	
		
		stop();
	}
}
