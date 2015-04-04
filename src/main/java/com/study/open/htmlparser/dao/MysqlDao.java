package com.study.open.htmlparser.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MysqlDao {
	private static Log log = LogFactory.getLog(MysqlDao.class);
	
	public static Connection getConnection () {
		Connection conn = null;
		log.info(">>>>>>>>>>getconnection");
		JdbcConfigBean config = new JdbcConfigBean("configure_mysql.properties");
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(config.getConnUrl(), config.getUsername(), config.getPassword());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}	
	public static void stop() throws SQLException{
//		Connection c = getConnection();
//		Statement st = c.createStatement();		
//		st.execute("SHUTDOWN;");		
	}
}
