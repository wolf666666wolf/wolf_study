package com.study.open.htmlparser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.time.DurationFormatUtils;

import com.study.open.htmlparser.bean.Community;
import com.study.open.htmlparser.bean.Distract;
import com.study.open.htmlparser.bean.House;

public class DaoService {

	public void saveDistrict(Distract distract) throws SQLException{
		String sql = "insert into District(name, pname, url, num) values(?, ?, ?, ?)";
		Connection conn = BaseDao.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, distract.getName());
		pst.setString(2, distract.getPname());
		pst.setString(3, distract.getUrl());
		pst.setInt(4, isEmpty(distract.getNum())?0:Integer.parseInt(distract.getNum()));
		pst.executeUpdate();	
		conn.close();	
	
	}
	public void saveCommunity(Community community) throws SQLException{
		String sql = "insert into Community(name, pname, url, price, num) values(?, ?, ?, ?, ?)";
		Connection conn = BaseDao.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, community.getName());
		pst.setString(2, community.getPname());
		pst.setString(3, community.getUrl());
		pst.setString(4, community.getPrice());
		pst.setInt(5, isEmpty(community.getNum())?0:Integer.parseInt(community.getNum()));
		
		
		pst.executeUpdate();	
		conn.close();	
	
	}
	public void saveHouse(House house){
		String sql = "insert into House(name, pname, url, price, value, area) values(?, ?, ?, ?, ?, ?)";
		Connection conn = BaseDao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement(sql);

		pst.setString(1, house.getName());
		pst.setString(2, house.getPname());
		pst.setString(3, house.getUrl());
		pst.setDouble(4, isEmpty(house.getPrice())?0:Double.parseDouble(house.getPrice()));
		pst.setDouble(5, isEmpty(house.getValue())?0:Double.parseDouble(house.getValue()));
		pst.setDouble(6, isEmpty(house.getArea())?0:Double.parseDouble(house.getArea()));
		
		pst.executeUpdate();

		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}	
	}	
	
	public void saveDistricts(Set<Distract> distractSet) throws SQLException{
		for(Iterator<Distract> it = distractSet.iterator(); it.hasNext();){
			this.saveDistrict(it.next());
		}	
	}
	public void saveCommunity(List<Community> comList) throws SQLException{
		for(Community com:comList){
			this.saveCommunity(com);
		}		
	}
	public void saveHouses(List<House> houseList) throws SQLException{
		if(houseList ==null || houseList.size()==0){
			return;
		}
		Date start = new Date();
//		for(House house: houseList){
//			this.saveHouse(house);
//		}
		
		/*
		String sql = "insert into House(name, pname, url, price, value, area) values(?, ?, ?, ?, ?, ?)";
		Connection conn = BaseDao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement(sql);
			for(House house:houseList){
				pst.setString(1, house.getName());
				pst.setString(2, house.getPname());
				pst.setString(3, house.getUrl());
				pst.setDouble(4, isEmpty(house.getPrice())?0:Double.parseDouble(house.getPrice()));
				pst.setDouble(5, isEmpty(house.getValue())?0:Double.parseDouble(house.getValue()));
				pst.setDouble(6, isEmpty(house.getArea())?0:Double.parseDouble(house.getArea()));
				pst.addBatch();
				
			    //this.saveHouse(house);

		}

		pst.executeBatch();
		conn.commit();		
		//pst.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}	
		*/
		Date end = new Date();
		System.out.println("size:"+houseList.size()+"start:"+start.getTime()+"end:"+end.getTime()+"##############duartion:"+DurationFormatUtils.formatDuration(end.getTime()-start.getTime(), "dd HH mm ss"));

	}	
	public List<Distract> getDistractList() throws SQLException{
		List<Distract> list = new ArrayList<Distract>();
		Connection c = BaseDao.getConnection();
		Statement st = c.createStatement();
		//String sql ="SELECT * FROM Customer WHERE FIRSTNAME = 'Laura'";
		//String sql ="CREATE TABLE Customer(ID INTEGER PRIMARY KEY,FirstName VARCHAR(20),LastName VARCHAR(30),Street VARCHAR(50),City VARCHAR(25));";
		String sql ="SELECT name,pname,url FROM DISTRICT";
		ResultSet rs =  st.executeQuery(sql);
		while(rs.next()){
			Distract dis = this.getDistract(rs);
			list.add(dis);
		}
		c.close();		
		return list;
	}
	private Distract getDistract(ResultSet rs) throws SQLException{
		Distract dis = new Distract();
		dis.setName(rs.getString(1));
		dis.setPname(rs.getString(2));
		dis.setUrl(rs.getString(3));
		return dis;
		//System.out.println("ID:"+rs.getString(1) + " FirstName:" +rs.getString(2) +" LastName" +rs.getString(3) +" Street:"+rs.getString(4)+" Street:"+rs.getString(5));
	}
	public void stopDB() throws SQLException{
		BaseDao.stop();
	}	
    public static void clearDistrict() throws SQLException{
		//BaseDao service = new BaseDao();
		Connection conn = BaseDao.getConnection();
		System.out.println("clear start");
		String sql1 = "delete from District";
		String sql2 = "delete from Community";
		String sql3 = "delete from House";
		
		Statement st = conn.createStatement();
		int count = st.executeUpdate(sql1);
		System.out.println("dis count:" + count); 
		
		Statement st2 = conn.createStatement();
		int count2 = st.executeUpdate(sql2);
		System.out.println("com count:" + count2); 
		
		Statement st3 = conn.createStatement();
		int count3 = st.executeUpdate(sql3);
		System.out.println("hou count:" + count3); 		
//		
//		PreparedStatement pstate_del = conn.prepareStatement(sql1);
//		pstate_del.addBatch();
//		//pstate_del.executeUpdate();
//		pstate_del = conn.prepareStatement(sql2);
//		pstate_del.addBatch();
//		//pstate_del.executeUpdate();
//		pstate_del = conn.prepareStatement(sql3);
//		pstate_del.addBatch();
//		//pstate_del.executeUpdate();
//		pstate_del.executeBatch();
//		conn.commit();
		conn.close();    
		BaseDao.stop();
		System.out.println("clear end");
    } 
    private boolean isEmpty(String str){
    	if(str==null || str.trim().equals("")){
    		return true;
    	}
    	return false;
    }
}
