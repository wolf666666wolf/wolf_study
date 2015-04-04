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

import com.study.open.htmlparser.bean.BlackName;
import com.study.open.htmlparser.bean.Community;
import com.study.open.htmlparser.bean.Distract;
import com.study.open.htmlparser.bean.House;
import com.study.open.htmlparser.bean.HousePara;

public class MysqlDaoService {
	private int rowsPerPage = 10;

	public void saveBlackName(BlackName blackName) throws SQLException{
		String sql = "insert into blackname(url, areatype, opertype) values(?, ?, ?)";
		Connection conn = MysqlDao.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, blackName.getUrl());
		pst.setString(2, blackName.getAreaType());
		pst.setString(3, blackName.getOperType());
		
		pst.executeUpdate();	
		conn.close();	
	
	}	
	public void saveDistrict(Distract distract) throws SQLException{
		String sql = "insert into District(name, pname, url, num) values(?, ?, ?, ?)";
		Connection conn = MysqlDao.getConnection();
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
		Connection conn = MysqlDao.getConnection();
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
		Connection conn = MysqlDao.getConnection();
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
    public void clearData(String tableName){
      String sql = "delete from "+tableName;
      Connection conn = MysqlDao.getConnection();
      PreparedStatement pst;
      try {
          pst = conn.prepareStatement(sql);
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
		
	
		String sql = "insert into House(name, pname, url, price, value, area, rooms, indate) values(?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = MysqlDao.getConnection();
		conn.setAutoCommit(false);
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
				pst.setString(7, house.getRooms());
				pst.setDate(8, new java.sql.Date(new Date().getTime()));
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
				if(conn ==null || conn.isClosed()){
					System.out.println("########closed");
				}else{
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}	
		
		Date end = new Date();
		System.out.println("size:"+houseList.size()+"start:"+start.getTime()+"end:"+end.getTime()+"##############duartion:"+DurationFormatUtils.formatDuration(end.getTime()-start.getTime(), "dd HH mm ss"));

	}	
	public List<Distract> getAllDistractList() throws SQLException{
		List<Distract> list = new ArrayList<Distract>();
		Connection c = MysqlDao.getConnection();
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

	public List<Distract> getDistractList(Distract district) throws SQLException{
		List<Distract> list = new ArrayList<Distract>();
		Connection c = MysqlDao.getConnection();
		Statement st = c.createStatement();
		//String sql ="SELECT * FROM Customer WHERE FIRSTNAME = 'Laura'";
		//String sql ="CREATE TABLE Customer(ID INTEGER PRIMARY KEY,FirstName VARCHAR(20),LastName VARCHAR(30),Street VARCHAR(50),City VARCHAR(25));";
		String sql = "";
		if(district==null){
			sql ="SELECT name,pname,url FROM DISTRICT";
		}else if(district.getPname()==null){
			sql ="SELECT name,pname,url FROM DISTRICT where pname is null ";
			if(district.getSubDistract()!=null){
				sql ="SELECT name,pname,url FROM DISTRICT where pname is not null ";
			}
		}else{
			sql ="SELECT name,pname,url FROM DISTRICT where pname='"+district.getPname()+"'";	
		}
			
		ResultSet rs =  st.executeQuery(sql);
		while(rs.next()){
			Distract dis = this.getDistract(rs);
			list.add(dis);
		}
		c.close();		
		return list;
	}	
	public List<Community> getAllCommunityList() throws SQLException{
		List<Community> list = new ArrayList<Community>();
		Connection c = MysqlDao.getConnection();
		Statement st = c.createStatement();
		//String sql ="SELECT * FROM Customer WHERE FIRSTNAME = 'Laura'";
		//String sql ="CREATE TABLE Customer(ID INTEGER PRIMARY KEY,FirstName VARCHAR(20),LastName VARCHAR(30),Street VARCHAR(50),City VARCHAR(25));";
		String sql ="SELECT name, pname, url, price, num FROM Community";
		ResultSet rs =  st.executeQuery(sql);
		while(rs.next()){
			Community dis = this.getCommunity(rs);
			list.add(dis);
		}
		c.close();		
		return list;
	}
	public List<House> getHouseList(HousePara param) throws SQLException{
		List<House> list = new ArrayList<House>();
		Connection c = MysqlDao.getConnection();
		Statement st = c.createStatement();
		StringBuilder sb = new StringBuilder();
		String sudDisSql = this.getSubDisStr(param.getSubDisList());
		int start = (param.getPage()-1)*param.PAGESIZE;
		sb.append("select h.name, h.pname, h.url, h.price, h.value, h.area, c.price,(c.price-h.price)/c.price as relPrice from District d, Community c, House h");
		sb.append("  where d.url = c.pname");
		sb.append("  and c.url = h.pname");
		sb.append("  and (c.price-h.price)/c.price > "+param.getPercent());
		sb.append("  and c.url not in (select url from blackname where areatype='C')");
		sb.append("  and h.url not in (select url from blackname where areatype='H')");
		sb.append("  and d.url not in (select url from blackname where areatype='D')");
		sb.append("  and d.url in ("+sudDisSql+")");
		sb.append("  and h.value>"+param.getMin());
		sb.append("  and h.value<"+param.getMax());
		sb.append("  and h.area>"+param.getMinArea());
		sb.append("  and h.area<"+param.getMaxArea());	
		sb.append("  and h.price<"+param.getMaxPrice());	
		sb.append("  and h.rooms like '%"+param.getRooms() +"%'");
		
		sb.append("  order by relPrice desc");
		sb.append("  limit "+start+", "+param.PAGESIZE);
		
System.out.println("#########SQl:" + sb.toString());		
		ResultSet rs =  st.executeQuery(sb.toString());
		while(rs.next()){
			House dis = this.getHouse(rs);
			list.add(dis);
		}
		c.close();		
		return list;
	}
	private String getSubDisStr(List<String> subDisList){
	  StringBuilder sqlStr = new StringBuilder(); 
	  if(subDisList==null) return "";
	   
	   for(int i=0; i<subDisList.size(); i++){
	     if(i==0){
	       sqlStr.append("'").append(subDisList.get(i)).append("'");
	     }else{
	       sqlStr.append(",").append("'").append(subDisList.get(i)).append("'");
	     }
	     
	   }
	   return sqlStr.toString();
	}
	public List<Community> getCommunityByPage(int pageNum) throws SQLException{
		List<Community> list = new ArrayList<Community>();
		Connection c = MysqlDao.getConnection();
		Statement st = c.createStatement();
		//String sql ="SELECT * FROM Customer WHERE FIRSTNAME = 'Laura'";
		//String sql ="CREATE TABLE Customer(ID INTEGER PRIMARY KEY,FirstName VARCHAR(20),LastName VARCHAR(30),Street VARCHAR(50),City VARCHAR(25));";
		int start = (pageNum-1)* rowsPerPage;
		String sql ="SELECT name, pname, url, price, num FROM Community limit "+start+", "+rowsPerPage;
		ResultSet rs =  st.executeQuery(sql);
		while(rs.next()){
			Community dis = this.getCommunity(rs);
			list.add(dis);
		}
		c.close();		
		return list;
	}	
	public int getCommunityPages() throws SQLException{
		List<Community> list = new ArrayList<Community>();
		Connection c = MysqlDao.getConnection();
		Statement st = c.createStatement();
		String sql ="SELECT count(*) FROM Community";
		ResultSet rs =  st.executeQuery(sql);
		int pages = 0;
		if(rs.next()){
			int total = rs.getInt(1);
			pages = (total+this.rowsPerPage-1)/rowsPerPage;
		}	
		return pages;
	}	
	private Distract getDistract(ResultSet rs) throws SQLException{
		Distract dis = new Distract();
		dis.setName(rs.getString(1));
		dis.setPname(rs.getString(2));
		dis.setUrl(rs.getString(3));
		return dis;
		//System.out.println("ID:"+rs.getString(1) + " FirstName:" +rs.getString(2) +" LastName" +rs.getString(3) +" Street:"+rs.getString(4)+" Street:"+rs.getString(5));
	}
	private Community getCommunity(ResultSet rs) throws SQLException{
		Community com = new Community();
		com.setName(rs.getString(1));
		com.setPname(rs.getString(2));
		com.setUrl(rs.getString(3));
		com.setPrice(rs.getString(4));
		com.setNum(rs.getString(5));
		return com;
		//System.out.println("ID:"+rs.getString(1) + " FirstName:" +rs.getString(2) +" LastName" +rs.getString(3) +" Street:"+rs.getString(4)+" Street:"+rs.getString(5));
	}	
	private House getHouse(ResultSet rs) throws SQLException{
		House hou = new House();
		hou.setName(rs.getString(1));
		hou.setPname(rs.getString(2));
		hou.setUrl(rs.getString(3));
		hou.setPrice(rs.getString(4));
		hou.setValue(rs.getString(5));
		hou.setArea(rs.getString(6));
		hou.setCprice(rs.getString(7));
		return hou;
		//System.out.println("ID:"+rs.getString(1) + " FirstName:" +rs.getString(2) +" LastName" +rs.getString(3) +" Street:"+rs.getString(4)+" Street:"+rs.getString(5));
	}
	public void stopDB() throws SQLException{
		BaseDao.stop();
	}	
    public static void clearDistrict() throws SQLException{
		//BaseDao service = new BaseDao();
		Connection conn = MysqlDao.getConnection();
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
    
    public static void main(String[] args){
    	MysqlDaoService dao = new MysqlDaoService();
    	Distract distract = new Distract();
    	distract.setName("大山子");
    	distract.setPname("朝阳");
    	distract.setUrl("www.sohu.com");
    	distract.setNum("1000");
    	try {
			dao.saveDistrict(distract);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	String filename = "configure_mysql.xml";
//    	URL url = MysqlDaoService.class.getResource(filename);
//    	System.out.println(url);
//    	System.out.println(url.toString());
//    	System.out.println(url.getPath());
    	

    	
    }
}
