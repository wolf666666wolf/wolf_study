package com.study.open.htmlparser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.study.open.htmlparser.bean.Community;
import com.study.open.htmlparser.bean.Distract;
import com.study.open.htmlparser.bean.House;
import com.study.open.htmlparser.dao.DaoService;
import com.study.open.htmlparser.visitor.CommunityNumVisitor;
import com.study.open.htmlparser.visitor.CommunityPageDivVisitor;
import com.study.open.htmlparser.visitor.HousePageDivVisitor;

public class StaticData {
	public static String baseUrl = "http://beijing.homelink.com.cn";
	private static Set<Distract> districtSet = new HashSet<Distract>();
	private static Set<Distract> subDistrictSet = null;

	//private static 
	public static List<Community> getCommunityList(String url) throws ParserException{
		List<Community> communityList = new ArrayList<Community>();
		Parser myParser = new Parser(url);
        myParser.setEncoding("UTF-8");
        CommunityPageDivVisitor pdv = new CommunityPageDivVisitor();
        myParser.visitAllNodesWith(pdv);
        communityList.addAll(pdv.getCommunityList());
        while(pdv.getNextPageLink()!=null){
    		myParser = new Parser(pdv.getNextPageLink());
            myParser.setEncoding("UTF-8");
            pdv = new CommunityPageDivVisitor();
            myParser.visitAllNodesWith(pdv);
            communityList.addAll(pdv.getCommunityList());        	
        }
        if(communityList!=null){
        	for(Community com: communityList){
        		com.setPname(url);
        		myParser = new Parser(com.getUrl());
                myParser.setEncoding("UTF-8");
                CommunityNumVisitor cnv = new CommunityNumVisitor();
                myParser.visitAllNodesWith(cnv);
                com.setNum(cnv.getNum());
                        		
        	}
        }
		return communityList;
	}

	private static List<House> getHouseList(String url) throws ParserException{
		List<House> houseList = new ArrayList<House>();
		Parser myParser = new Parser(url);
        myParser.setEncoding("UTF-8");
        HousePageDivVisitor pdv = new HousePageDivVisitor();
        myParser.visitAllNodesWith(pdv);
        houseList.addAll(pdv.getHouseList());
        while(pdv.getNextPageLink()!=null){
    		myParser = new Parser(pdv.getNextPageLink());
            myParser.setEncoding("UTF-8");
            pdv = new HousePageDivVisitor();
            myParser.visitAllNodesWith(pdv);
            houseList.addAll(pdv.getHouseList());        	
        }
		return houseList;		
	}
    public static Set<Distract> getDistrictSet() throws ParserException{
    	if(districtSet != null && !districtSet.isEmpty()) return districtSet;
    	initDistrict();
    	for(Distract dis: districtSet){
    		dis.setSubDistract(getSubDistract(dis));
    	}
    	return districtSet;
    }
	   private static Set<Distract> getSubDistract(Distract pdis) throws ParserException {    
	    	
	    	Parser myParser;    
	        NodeList nodeList = null;    
	        Set<Distract> subDisList = new HashSet<Distract>();
	        
	        //myParser = Parser.createParser(content, "GBK");
	        myParser = new Parser(pdis.getUrl());
	        myParser.setEncoding("UTF-8");
	        
	        
	    
	        //NodeFilter textFilter = new NodeClassFilter(TextNode.class);    
	        NodeFilter linkFilter = new NodeClassFilter(LinkTag.class);    
	    
	        //暂时不处理 meta    
	        //NodeFilter metaFilter = new NodeClassFilter(MetaTag.class);    
	    
	        OrFilter lastFilter = new OrFilter();    
	        lastFilter.setPredicates(new NodeFilter[] { linkFilter });    
	    
	        nodeList = myParser.parse(lastFilter);    
	    
	        Node[] nodes = nodeList.toNodeArray();    
	        List<LinkTag> result = new ArrayList<LinkTag>();
	        String distLink = getSubDisLink(pdis.getUrl());
	        for (int i = 0; i < nodes.length; i++) {    
	            Node anode = (Node) nodes[i];    
	    
	            String line = "";    

	            
	                LinkTag linknode = (LinkTag) anode;    
	                //System.out.println("linknode = " + linknode);
	                line = linknode.getLink(); 
	                String text = linknode.getLinkText().trim();
	                String link = linknode.getLink().trim();
	                
	                //String abUrl = "/xiaoqu/d1" +"b";
	                
	                
	                String fullDistLink = baseUrl + distLink;
	                if(link.indexOf(distLink)>=0 || link.indexOf(fullDistLink)>=0){
	                	Distract dis = new Distract(text,link);
	                	dis.setPname(pdis.getName());
	                	
	                	subDisList.add(dis);
	                }
   
	             
	    
	            if (isTrimEmpty(line))    
	                continue;    
	 
	                
	        } 
          for(Iterator<Distract> it=subDisList.iterator(); it.hasNext();){
           	Distract node = it.next();
           	System.out.println("{[name:" + node.getName()+"][URL:"+node.getUrl()+"][hashCode:"+node.hashCode()+"]");
           }
	           
	       return subDisList;
	        
	    }   
	    private static String getSubDisLink(String plink){
	    	return plink.substring(0, plink.lastIndexOf("/")) + "b";
	    }
	    public static boolean isTrimEmpty(String astr) {    
	        if ((null == astr) || (astr.length() == 0)) {    
	            return true;    
	        }    
	        if (isBlank(astr.trim())) {    
	            return true;    
	        }    
	        return false;    
	    } 
	    public static boolean isBlank(String astr) {    
	        if ((null == astr) || (astr.length() == 0)) {    
	            return true;    
	        } else {    
	            return false;    
	        }    
	    }	
	public static void initDistrict(){
    	//List<Distract> disList = new ArrayList<Distract>();
		if(districtSet!=null && !districtSet.isEmpty()){
			return ;
		}
    	Set<Distract> disList = districtSet;
    	disList.add(new Distract("朝阳", baseUrl+"/xiaoqu/d1/"));
//    	disList.add(new Distract("海淀", baseUrl+"/xiaoqu/d2/"));
//    	disList.add(new Distract("丰台", baseUrl+"/xiaoqu/d3/"));
//    	disList.add(new Distract("东城", baseUrl+"/xiaoqu/d4/"));
//    	disList.add(new Distract("西城", baseUrl+"/xiaoqu/d5/"));
//    	disList.add(new Distract("崇文", baseUrl+"/xiaoqu/d6/"));
//    	disList.add(new Distract("宣武", baseUrl+"/xiaoqu/d7/"));
//    	disList.add(new Distract("石景山", baseUrl+"/xiaoqu/d8/"));
//    	disList.add(new Distract("昌平", baseUrl+"/xiaoqu/d9/"));
//    	disList.add(new Distract("通州", baseUrl+"/xiaoqu/d10/"));
//    	disList.add(new Distract("大兴", baseUrl+"/xiaoqu/d11/"));
//    	disList.add(new Distract("顺义", baseUrl+"/xiaoqu/d12/"));
    }	
//    public static void print(){
//    	System.out.println(districtSet.toString());
//    	
//    }
	
    public static void print() throws ParserException, SQLException{
    	ExecutorService exec = Executors.newFixedThreadPool(10);
    	String spliter = "                  ";
    	DaoService dservice = new DaoService();
		Set<Distract> disSet = getDistrictSet();
		dservice.saveDistricts(disSet);
		for(Iterator<Distract> it=disSet.iterator(); it.hasNext();){
			//StringBuilder sb = new StringBuilder();
			Distract dis = it.next();
			//sb.append(dis.getName()).append(":").append(dis.getName()).append("\n");
			Set<Distract> subDisSet = dis.getSubDistract();
			
			dservice.saveDistricts(subDisSet);
			if(subDisSet!=null && !subDisSet.isEmpty()){
				for(Distract subdis: subDisSet){
					//sb.append(spliter).append(subdis.getName()).append(":").append(subdis.getUrl()).append("\n");
					List<Community> comList = getCommunityList(subdis.getUrl());
					
					dservice.saveCommunity(comList);
					for(Community com: comList){
						
						//sb.append(spliter).append(com.getName()).append(":").append(com.getPrice()).append(":").append(com.getUrl()).append("\n");
						//String url = com.getLink()+"esf/";
						String url = com.getUrl();//.getLink();
						//System.out.println("CommunityURL:"+url);
						//List<House> houseList = getHouseList(url);
						HouseFindThread hft = new HouseFindThread(url);
						
						exec.execute(hft);
					}
				}
			}
			
			//System.out.println(sb.toString());
		}

		exec.shutdown();
		//return sb.toString();
		List<Distract> dsList = dservice.getDistractList();
		System.out.println("dsList:"+dsList);
		dservice.stopDB();
    }
 
    public static void main(String[] args) throws ParserException{
//    	String link = "/xiaoqu/d12/";
//    	System.out.println(link.length());
//    	System.out.println(link.lastIndexOf("/"));
//    	System.out.println(getSubDisLink(link));   
		//getDistrictSet();
		try {
			StaticData.print();
			//DaoService.clearDistrict();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }
}

