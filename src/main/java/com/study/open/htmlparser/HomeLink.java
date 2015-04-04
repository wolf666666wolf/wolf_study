package com.study.open.htmlparser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.study.open.htmlparser.bean.Distract;
import com.study.open.htmlparser.bean.House;
import com.study.open.htmlparser.visitor.CommunityPageDivVisitor;
import com.study.open.htmlparser.visitor.HousePageDivVisitor;



public class HomeLink {
	private static List<Distract> disList=null;
	private static Set<Distract> subDisList=new HashSet<Distract>();
	private static List<Node> nodeList1 = new ArrayList<Node>();
	private static String baseUrl = "http://beijing.homelink.com.cn";
	private static String nextPageUrl;
	public static void main(String[] args) throws IOException, ParserException{
		//init();
		URL path = ParseHtmlTest.class.getResource("a.txt");
		
		
		System.out.println("path:" + path.getFile());
		//String content = FileUtils.readFileToString(new File(path.getFile()));	
		//test2(content);
		StaticData.getDistrictSet();
		try {
			StaticData.print();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static List<House> getHouseList(String url) throws ParserException{
		List<House> communityList = new ArrayList<House>();
		Parser myParser = new Parser(url);
        myParser.setEncoding("UTF-8");
        HousePageDivVisitor pdv = new HousePageDivVisitor();
        myParser.visitAllNodesWith(pdv);
        communityList.addAll(pdv.getHouseList());
        while(pdv.getNextPageLink()!=null){
    		myParser = new Parser(pdv.getNextPageLink());
            myParser.setEncoding("UTF-8");
            pdv = new HousePageDivVisitor();
            myParser.visitAllNodesWith(pdv);
            communityList.addAll(pdv.getHouseList());        	
        }
		return communityList;		
	}	
	   public static void test2(String content) throws ParserException {    
	    	System.out.println("start test2 ++++++++++++++");
	    	Parser myParser;    
	        NodeList nodeList = null;    
	    
	        //myParser = Parser.createParser(content, "GBK");    
	        myParser = Parser.createParser(content, "GBK");
	    
	        //NodeFilter textFilter = new NodeClassFilter(TextNode.class);    
	        NodeFilter linkFilter = new NodeClassFilter(Div.class);    
	    
	        //暂时不处理 meta    
	        //NodeFilter metaFilter = new NodeClassFilter(MetaTag.class);    
	    
	        OrFilter lastFilter = new OrFilter();    
	        lastFilter.setPredicates(new NodeFilter[] { linkFilter });
	        HousePageDivVisitor pdv = new HousePageDivVisitor();
	        myParser.visitAllNodesWith(pdv);
	        
	        System.out.println(pdv.toString());
	        //nodeList = myParser.parse(lastFilter);
	           
//	        linkFilter = new NodeClassFilter(Span.class);
//	        lastFilter.setPredicates(new NodeFilter[] { linkFilter }); 
//	        nodeList = myParser.parse(lastFilter); 
	        
//	        Node[] nodes = nodeList.toNodeArray();    
//	        List<LinkTag> result = new ArrayList<LinkTag>();
//	        for (int i = 0; i < nodes.length; i++) {    
//	            Node anode = (Node) nodes[i];    
//	    
//	            String line = "";    
//	            if (anode instanceof TextNode) {    
//	                TextNode textnode = (TextNode) anode;    
//	                //line = textnode.toPlainTextString().trim();    
//	                line = textnode.getText();    
//	            } 
//	            if (anode instanceof Div) {    
//	                Div div = (Div) anode;    
//	                String attr = div.getAttribute("class"); //detailed_rig
//	                System.out.println("attr:" + attr);
//	                if("detailed_rig".equals(attr)){
//	                	myParser.p
//	                	nodeList1.add(anode);
//	                }
//	                //line = textnode.toPlainTextString().trim();    
//	                //line = textnode.getText();    
//	            } 	            
//	            else if (anode instanceof LinkTag) {    
//	                LinkTag linknode = (LinkTag) anode;    
//	                //System.out.println("linknode = " + linknode);
//	                line = linknode.getLink(); 
//	                String text = linknode.getLinkText().trim();
//	                String link = linknode.getLink().trim();
//	                
//	                String distLink = "/xiaoqu/d1b";
//	                String fullDistLink = baseUrl +"/xiaoqu/d1b";
//	                if(link.indexOf(distLink)>=0 || link.indexOf(fullDistLink)>=0){
//	                	subDisList.add(new Distract(text,link, baseUrl));
//	                }
//
//	               // System.out.println("{[text:" + linknode.getLinkText()+"][link:"+linknode.getLink()+"]}");
////	                if(containArea(key)){
////	                	result.add(linknode);
////	                }
//	                //System.out.println("line = " + line);
//	                //@todo 过滤jsp标签:可以自己实现这个函数    
//	                //line = StringFunc.replace(line, "<%.*%>", "");    
//	            }    
//	          
//	            if (isTrimEmpty(line))    
//	                continue;    
//	 
//	                
//	        } 
//	           for(Iterator<Distract> it=subDisList.iterator(); it.hasNext();){
//	            	Distract node = it.next();
//	            	System.out.println("{[name:" + node.getName()+"][link:"+node.getLink()+"][hashCode:"+node.hashCode()+"]");
//	            }
//	        for(Node node: nodeList1){
//	        	System.out.println("++++++++++++++++++++++++"+node.toHtml());
//	        }
	        
	    }
	   public static void testCommunity(String content) throws ParserException {    
	    	System.out.println("start test2 ++++++++++++++");
	    	Parser myParser;    
	        NodeList nodeList = null;    
	    
	        //myParser = Parser.createParser(content, "GBK");    
	        myParser = Parser.createParser(content, "GBK");
	    
	        //NodeFilter textFilter = new NodeClassFilter(TextNode.class);    
	        NodeFilter linkFilter = new NodeClassFilter(LinkTag.class);    
	    
	        //暂时不处理 meta    
	        //NodeFilter metaFilter = new NodeClassFilter(MetaTag.class);    
	    
	        OrFilter lastFilter = new OrFilter();    
	        lastFilter.setPredicates(new NodeFilter[] { linkFilter });    
	    
	        nodeList = myParser.parse(lastFilter);    
	    
	        Node[] nodes = nodeList.toNodeArray();    
	        List<LinkTag> result = new ArrayList<LinkTag>();
	        for (int i = 0; i < nodes.length; i++) {    
	            Node anode = (Node) nodes[i];    
	    
	            String line = "";    
	            if (anode instanceof TextNode) {    
	                TextNode textnode = (TextNode) anode;    
	                //line = textnode.toPlainTextString().trim();    
	                line = textnode.getText();    
	            } 
	            else if (anode instanceof LinkTag) {    
	                LinkTag linknode = (LinkTag) anode;    
	                //System.out.println("linknode = " + linknode);
	                line = linknode.getLink(); 
	                String text = linknode.getLinkText().trim();
	                String link = linknode.getLink().trim();
	                
	                String distLink = "/xiaoqu/d1b";
	                String fullDistLink = baseUrl +"/xiaoqu/d1b";
	                if(link.indexOf(distLink)>=0 || link.indexOf(fullDistLink)>=0){
	                	subDisList.add(new Distract(text,link));
	                }

	               // System.out.println("{[text:" + linknode.getLinkText()+"][link:"+linknode.getLink()+"]}");
//	                if(containArea(key)){
//	                	result.add(linknode);
//	                }
	                //System.out.println("line = " + line);
	                //@todo 过滤jsp标签:可以自己实现这个函数    
	                //line = StringFunc.replace(line, "<%.*%>", "");    
	            }    
	    
	            if (isTrimEmpty(line))    
	                continue;    
	 
	                
	        } 
	           for(Iterator<Distract> it=subDisList.iterator(); it.hasNext();){
	            	Distract node = it.next();
	            	System.out.println("{[name:" + node.getName()+"][link:"+node.getUrl()+"][hashCode:"+node.hashCode()+"]");
	            }
	        
	    }	   
//	   public static get(){
//		   Set<Distract> disSet = StaticData.getDistrictSet();
//		   for(Iterator<Distract> it=disSet.iterator(); it.hasNext();){
//			   Distract node = it.next();
//			   
//			   Set<Distract> subSet = getSubDistract(, node.getName());
//		   }
//		   
//	   }
	   public static Set<Distract> getSubDistract(Distract pdis) throws ParserException {    
	    	
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
	        for (int i = 0; i < nodes.length; i++) {    
	            Node anode = (Node) nodes[i];    
	    
	            String line = "";    

	            
	                LinkTag linknode = (LinkTag) anode;    
	                //System.out.println("linknode = " + linknode);
	                line = linknode.getLink(); 
	                String text = linknode.getLinkText().trim();
	                String link = linknode.getLink().trim();
	                
	                String abUrl = "/xiaoqu/d1" +"b";
	                String distLink = abUrl;
	                String fullDistLink = baseUrl + abUrl;
	                if(link.indexOf(distLink)>=0 || link.indexOf(fullDistLink)>=0){
	                	subDisList.add(new Distract(text,link));
	                }
	                if("下一页".equals(text)){
	                	setNextPage(link);
	                }
	               // System.out.println("{[text:" + linknode.getLinkText()+"][link:"+linknode.getLink()+"]}");
//	                if(containArea(key)){
//	                	result.add(linknode);
//	                }
	                //System.out.println("line = " + line);
	                //@todo 过滤jsp标签:可以自己实现这个函数    
	                //line = StringFunc.replace(line, "<%.*%>", "");    
	             
	    
	            if (isTrimEmpty(line))    
	                continue;    
	 
	                
	        } 
           for(Iterator<Distract> it=subDisList.iterator(); it.hasNext();){
            	Distract node = it.next();
            	System.out.println("{[name:" + node.getName()+"][link:"+node.getUrl()+"][hashCode:"+node.hashCode()+"]");
            }
	           
	       return subDisList;
	        
	    }	
	    private static void setNextPage(String url){
	    	nextPageUrl = url;
	    	
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
	    
//	    private static int getArea(String areaKey){
//	    	for(int i=0; i<area.length; i++){
//	    		if(area[i].equals(areaKey)){
//	    			return i;
//	    		}
//	    	}
//	    	
//	    	return -1;
//	    }
//	    private static boolean containArea(String areaKey){
//	    	for(int i=0; i<area.length; i++){
//	    		if(area[i].equals(areaKey)){
//	    			return true;
//	    		}
//	    	}	    	
//	    	return false;
//	    	
//	    }
//	    public static void initSubDis(){
//	    	
//	    }
	    
//	    public static void initDistrict(){
//	    	//List<Distract> disList = new ArrayList<Distract>();
//	    	disList.add(new Distract("朝阳", "/ershoufang/d1/"));
//	    	disList.add(new Distract("海淀", "/ershoufang/d2/"));
//	    	disList.add(new Distract("丰台", "/ershoufang/d3/"));
//	    	disList.add(new Distract("东城", "/ershoufang/d4/"));
//	    	disList.add(new Distract("西城", "/ershoufang/d5/"));
//	    	disList.add(new Distract("崇文", "/ershoufang/d6/"));
//	    	disList.add(new Distract("宣武", "/ershoufang/d7/"));
//	    	disList.add(new Distract("石景山", "/ershoufang/d8/"));
//	    	disList.add(new Distract("昌平", "/ershoufang/d9/"));
//	    	disList.add(new Distract("通州", "/ershoufang/d10/"));
//	    	disList.add(new Distract("大兴", "/ershoufang/d11/"));
//	    	disList.add(new Distract("顺义", "/ershoufang/d12/"));
//	    }
	    
	    
//	    public static void initSubDistrict(){
//	    	//List<Distract> disList = new ArrayList<Distract>();
//	    	disList.add(new Distract("朝阳", "/xiaoqu/d1/", baseUrl));
//	    	disList.add(new Distract("海淀", "/xiaoqu/d2/", baseUrl));
//	    	disList.add(new Distract("丰台", "/xiaoqu/d3/", baseUrl));
//	    	disList.add(new Distract("东城", "/xiaoqu/d4/", baseUrl));
//	    	disList.add(new Distract("西城", "/xiaoqu/d5/", baseUrl));
//	    	disList.add(new Distract("崇文", "/xiaoqu/d6/", baseUrl));
//	    	disList.add(new Distract("宣武", "/xiaoqu/d7/", baseUrl));
//	    	disList.add(new Distract("石景山", "/xiaoqu/d8/", baseUrl));
//	    	disList.add(new Distract("昌平", "/xiaoqu/d9/", baseUrl));
//	    	disList.add(new Distract("通州", "/xiaoqu/d10/", baseUrl));
//	    	disList.add(new Distract("大兴", "/xiaoqu/d11/", baseUrl));
//	    	disList.add(new Distract("顺义", "/xiaoqu/d12/", baseUrl));
//	    }	    
}
