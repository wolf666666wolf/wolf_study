package com.study.j2ee.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.study.open.hsqldb.ServerService;

public class StatementTest {

	public static void testPrepareStatement() throws SQLException{
		ServerService service = new ServerService();
		printall();
		Connection conn = service.getConnection();
		System.out.println("test start");
		String sql2 = "delete from Customer where id = 10000";
		PreparedStatement pstate_del = conn.prepareStatement(sql2);
		pstate_del.executeUpdate();
		System.out.println("test start1");
		String sql = "insert into Customer values(?, ?, ?, ?, ?)";
		PreparedStatement pstate = conn.prepareStatement(sql);
	    pstate.setInt(1, 10000);
	    pstate.setString(2, "天下");
	    pstate.setString(3, "杨");
	    pstate.setString(4, "beijing");
	    pstate.setString(5, "aaaaaaa");
	    pstate.executeUpdate();
	    
	    printall();
		
		//PreparedStatement pstate_del = conn.prepareStatement(sql);
		pstate_del.executeUpdate();
		printall();
		conn.close();
		
	}
	private static void printall() throws SQLException{
		ServerService service = new ServerService();
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
	
	public static void main(String[] args){
		try {
			testPrepareStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
