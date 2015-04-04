package com.study.j2ee.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.study.open.hsqldb.ServerService;

public class BatchTest {

	public static void statementBatch() throws SQLException{
		ServerService service = new ServerService();
		Connection conn = service.getConnection();
		Statement state = conn.createStatement();
		String sql0 = "insert into Customer values ( 10000, 'a', 'b', 'c', 'd')";
		String sql1 = "insert into Customer values ( 10001, 'a1', 'b1', 'c1', 'd1')";
		String sql2 = "insert into Customer values ( 10002, 'a2', 'b2', 'c2', 'd2')";
		
		state.addBatch(sql0);
		state.addBatch(sql1);
		state.addBatch(sql2);
		printall();
		state.executeBatch();
		System.out.println("##################AFTER BATCH##########################");
		printall();
		clearData();
		System.out.println("##################AFTER ClEAR##########################");
		printall();
		conn.close();
		
	}
	public static void preparedStatementBatch() throws SQLException{
		ServerService service = new ServerService();
		Connection conn = service.getConnection();
		String sql0 = "insert into Customer values ( ?, ?, ?, ?, ?)";
		PreparedStatement state = conn.prepareStatement(sql0);
		int ID = 10000;
		
		for(int i=1; i<=10; i++){
			int index = 1;
			state.setInt(index++, ID + i);
			state.setString(index++, "a"+i);
			state.setString(index++, "b"+i);
			state.setString(index++, "c"+i);
			state.setString(index++, "d"+i);
			state.addBatch();
		}
		
		printall();
		System.out.println("##################BEFORE preparedStatementBatch##########################");
		state.executeBatch();
		System.out.println("##################AFTER preparedStatementBatch##########################");
		printall();
		clearData();
		System.out.println("##################AFTER CLEAR preparedStatementBatch##########################");
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
	private static void clearData() throws SQLException{
		ServerService service = new ServerService();
		Connection conn = service.getConnection();
		System.out.println("test start");
		String sql2 = "delete from Customer where id >= 10000";
		PreparedStatement pstate_del = conn.prepareStatement(sql2);
		pstate_del.executeUpdate();	
		conn.close();
	}
	public static void main(String[] args){
		try {
			statementBatch();
			preparedStatementBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
