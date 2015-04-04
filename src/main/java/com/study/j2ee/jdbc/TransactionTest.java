package com.study.j2ee.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import com.study.open.hsqldb.ServerService;

public class TransactionTest {

	public static void simpletest1() throws Exception{
		ServerService service = new ServerService();
		Connection conn = null;
		Statement state =null;
		//service.printCustomerAll();
		System.out.println("################BEFORE TRANSACTION#########################");
		try{
			conn = service.getConnection();
			conn.setAutoCommit(false);
			state = conn.createStatement();
				
			state.executeUpdate("insert into Customer values ( 10000, 'a', 'b', 'c', 'd')");
			state.executeUpdate("insert into Customer values ( 1, 'a1', 'b1', 'c1', 'd1')");
			
			conn.commit();
		
		}catch(Exception e){
			conn.rollback();
			throw e;
		}finally{
			try{
				conn.setAutoCommit(true);
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
		System.out.println("################AFTER TRANSACTION#########################");
		//service.printCustomerAll();
	}
	
	public static void savePointTest() throws Exception{
		ServerService service = new ServerService();
		
		Connection conn = null;
		Statement state = null;
		Savepoint svpt = null;
		//service.clearData();
		//service.printCustomerAll();
		
		System.out.println("################BERORE save point#####################");
		try{
			conn = service.getConnection();
			conn.setAutoCommit(false);
			state = conn.createStatement();
			state.executeUpdate("insert into Customer values ( 10000, 'a', 'b', 'c', 'd')");
			System.out.println("############beforesavepoint:"+svpt);
			svpt = conn.setSavepoint("userpoint");
			System.out.println("############aftersavepoint:"+svpt);
			state.executeUpdate("insert into Customer values ( 10001, 'a0', 'b0', 'c0', 'd0')");
			state.executeUpdate("insert into Customer values ( 1, 'a1', 'b1', 'c1', 'd1')");
			conn.commit();
		}catch(Exception e){
			if(svpt != null){
				conn.rollback(svpt);
			}else{
				conn.rollback();
			}
			
			//throw e;
		}finally{
			conn.setAutoCommit(true);
			//service.closeConn(state, conn);
		}
		
		System.out.println("###################after save##################");
		//service.printCustomerAll();
		System.out.println("###################after clear##################");
		//service.clearData();
		//service.printCustomerAll();
		
	}
	
	private static void closeConn(Statement state, Connection conn) throws SQLException{
		try{
			conn.setAutoCommit(true);
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

	public static void main(String[] args){
		try {
//			simpletest1();
			savePointTest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
