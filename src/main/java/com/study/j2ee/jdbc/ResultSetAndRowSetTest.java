package com.study.j2ee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.sql.rowset.CachedRowSet;

import com.study.open.hsqldb.ServerService;
import com.sun.rowset.CachedRowSetImpl;

public class ResultSetAndRowSetTest {

	public static void testResultSet() throws SQLException{
		
		ResultSet rs = getResultSet();
		while(rs.next()){
			System.out.println("ID:"+rs.getString(1) + " FirstName:" +rs.getString(2) +" LastName" +rs.getString(3) +" Street:"+rs.getString(4)+" Street:"+rs.getString(5));
			
		}
		
	}
	public static void testRowSet() throws SQLException{

		ResultSet rs =  getResultSet();

		CachedRowSet crs = new CachedRowSetImpl();
		crs.populate(rs);		
		Vector<String> column = (Vector<String>)crs.toCollection(2);
		for(int i= 0; i<column.size(); i++){
			System.out.println("column.get("+i+"):"+column.get(i));
		}
	
	}
	
	public static void testRowSetPage() throws SQLException{
		/**
		 * RowSet的缺点：基于RowSet数据集实现数据的二次操作，其最终效果取决于JDBC驱动
		 * 程序及数据库的表现；但是如果启用各种JDBC驱动程序自身提供的RowSet实现类的话，
		 * 则应用程序的数据库无关性将大打折扣
		 * JdbcRowSet
		 * CachedRowSet
		 * JoinRowSet
		 * FilterdRowSet
		 * WebRowSet
		 * */
	    String hsqlUrl = "jdbc:hsqldb:file:E:/workspace/wolf-study/src/main/resources/study/hsql/data/mydb;ifexists=true";
	    String hsqlUser = "sa";
	    String hsqlPwd = "";		
		Connection conn = null;
		
		//Class.forName("");
		CachedRowSet crs = new CachedRowSetImpl();
		crs.setUrl(hsqlUrl);
		crs.setUsername(hsqlUser);
		crs.setPassword(hsqlPwd);
		crs.setCommand("SELECT * FROM Customer");
		crs.setPageSize(10);
		crs.execute();
		int pageCount = 0;
		while(crs.nextPage()){
			System.out.println("Page:" + (++pageCount));
			while(crs.next()){
				System.out.println("crs.getString(1):"+crs.getString(1));
			}
		}
				
	}
	private static ResultSet getResultSet() throws SQLException{
		ServerService service = new ServerService();
		Connection conn =service.getConnection();
		Statement st = conn.createStatement();
		String sql ="SELECT * FROM Customer";
		ResultSet rs =  st.executeQuery(sql);
		return rs;
	}
	public static void main(String[] args){
		try {
			testResultSet();
			testRowSet();
			testRowSetPage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
