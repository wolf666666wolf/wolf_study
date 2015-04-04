package com.study.open.htmlparser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.htmlparser.util.ParserException;

import com.study.open.htmlparser.bean.BlackName;
import com.study.open.htmlparser.bean.Community;
import com.study.open.htmlparser.bean.Distract;
import com.study.open.htmlparser.bean.House;
import com.study.open.htmlparser.bean.HousePara;
import com.study.open.htmlparser.dao.MysqlDaoService;

public class HomeLinkService {

	public List<Distract> getDistrict(Distract district){
		MysqlDaoService daoService = new MysqlDaoService();
		//Distract district = new Distract();
		List<Distract> disList = null;
		try {
			disList = daoService.getDistractList(district);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return disList;
	}
	public List<House> getHouseList(HousePara para){
		MysqlDaoService daoService = new MysqlDaoService();
		//Distract district = new Distract();
		List<House> disList = null;
		try {
			disList = daoService.getHouseList(para);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return disList;
	}
	public void addBlackName(BlackName blackName){
		MysqlDaoService daoService = new MysqlDaoService();
		try {
			daoService.saveBlackName(blackName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void initData() throws ParserException, SQLException{
	    MysqlDaoService daoService = new MysqlDaoService();
	    daoService.clearData("district");
	    daoService.clearData("community");
	    
		Set<Distract> disSet = StaticData.getDistrictSet();
		
		daoService.saveDistricts(disSet);
		for(Distract dis: disSet){
			daoService.saveDistricts(dis.getSubDistract());
		}
		
		Distract dis = new Distract();
		dis.setSubDistract(new HashSet<Distract>());
		List<Distract> subDisSet = daoService.getDistractList(dis);
		for(Distract subdis: subDisSet){
			List<Community> comList = StaticData.getCommunityList(subdis.getUrl());
			daoService.saveCommunity(comList);
		}		
	}
    public void initHouseBySubdis(List<String> list) throws ParserException, SQLException, InterruptedException{
      //List<Distract> subDisList = new ArrayList<Distract>();
      Set<Distract> subDisSet = new HashSet<Distract>();
      for(String url: list){
        Distract subDis = new Distract();
        subDis.setUrl(url);
         System.out.println("UUURRRLLL:"+url);        
        subDisSet.add(subDis);
      }
      
      //Set<Distract> disSet = StaticData.getDistrictSet();
      MysqlDaoService daoService = new MysqlDaoService();
      //daoService.clearData("District");
      //daoService.clearData(Community.class.getSimpleName());
      daoService.clearData(House.class.getSimpleName());
      //daoService.saveDistricts(subDisSet);
      for(Distract subdis: subDisSet){
          List<Community> comList = StaticData.getCommunityList(subdis.getUrl());
          System.out.println("commlist:"+comList);          
          saveAllHouseByCommunity(comList);
      }  

  }
    public void saveAllHouseByCommunity(List<Community> comList) throws SQLException, InterruptedException{

      ExecutorService exec = Executors.newFixedThreadPool(5);

      for(Community com: comList){
          String url = com.getUrl();//.getLink();
          HouseFindThread hft = new HouseFindThread(url);
          exec.execute(hft);
      }       
      
      Thread.sleep(1500);

      
//    List<Community> comList = new ArrayList<Community>();
//    Community comm = new Community();
//    comm.setUrl("http://beijing.homelink.com.cn/c-tiantongyuanbeiqu594/esf/");
//    comList.add(comm);
//    for(Community com: comList){
//        String url = com.getUrl();//.getLink();
//        HouseFindThread hft = new HouseFindThread(url);
//        //exec.execute(hft);
//        hft.run();
//    }
      
      exec.shutdown();
      System.out.println("Finished:"+new Date());
  }    
	public void saveAllHouse() throws SQLException, InterruptedException{
		MysqlDaoService daoService = new MysqlDaoService();
		//List<Community> comList = daoService.getAllCommunityList();
		int pages = daoService.getCommunityPages();
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i=1; i<=pages; i++){
			List<Community> comList = daoService.getCommunityByPage(i);
			System.out.println("pagenum:"+i);
			for(Community com: comList){
				String url = com.getUrl();//.getLink();
				HouseFindThread hft = new HouseFindThread(url);
				exec.execute(hft);
			}		
			
			Thread.sleep(1500);
		}
		
//		List<Community> comList = new ArrayList<Community>();
//		Community comm = new Community();
//		comm.setUrl("http://beijing.homelink.com.cn/c-tiantongyuanbeiqu594/esf/");
//		comList.add(comm);
//		for(Community com: comList){
//			String url = com.getUrl();//.getLink();
//			HouseFindThread hft = new HouseFindThread(url);
//			//exec.execute(hft);
//			hft.run();
//		}
		
		exec.shutdown();
		System.out.println("Finished:"+new Date());
	}
	
	public static void main(String[] args){
		HomeLinkService service = new HomeLinkService();
		try {
			service.initData();
			//service.saveAllHouse();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
