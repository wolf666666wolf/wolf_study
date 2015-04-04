package com.study.open.htmlparser;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.htmlparser.Parser;
import org.htmlparser.util.ParserException;

import com.study.open.htmlparser.bean.House;
import com.study.open.htmlparser.dao.MysqlDaoService;
import com.study.open.htmlparser.visitor.HousePageDivVisitor;

public class HouseFindThread extends Thread{
	private String url;
	private String pname;
	//private DaoService dservice = new DaoService();
	private MysqlDaoService dservice = new MysqlDaoService();
	public HouseFindThread(String url){
		this.url = url;
		this.pname = url;
	}
	@Override
	public void run(){
		
		//List<House> communityList = new ArrayList<House>();
		System.out.println("thread start:"+(new Date()).getTime() +"  "+ url);
		Parser myParser;
		try {
			myParser = new Parser(url);
			

	        myParser.setEncoding("UTF-8");
	        HousePageDivVisitor pdv = new HousePageDivVisitor();
	        myParser.visitAllNodesWith(pdv);
	        List<House> houseList = pdv.getHouseList();
	        this.setHouseCommunity(houseList, pname);
	        dservice.saveHouses(houseList);
	        houseList=null;
	        //communityList.addAll(pdv.getCommunityList());
	        //System.out.println("hourseList:"+pdv.toString());
	        while(pdv.getNextPageLink()!=null){
	    		myParser = new Parser(pdv.getNextPageLink());
	            myParser.setEncoding("UTF-8");
	            pdv = new HousePageDivVisitor();
	            myParser.visitAllNodesWith(pdv);
	            houseList = pdv.getHouseList();
	            this.setHouseCommunity(houseList, url);
	            dservice.saveHouses(houseList);
	            houseList=null;
	            Thread.sleep(100);
	            //communityList.addAll(pdv.getCommunityList());  
	            //System.out.println("hourseList:"+pdv.toString());
	        }
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread end:"+(new Date()).getTime());
	}
	private void setHouseCommunity(List<House> comList, String comName){
		if(comList!=null){
			for(House com:comList){
				com.setPname(comName);
			}
		}
	}
}
