package com.study.open.htmlparser.visitor;

import java.util.ArrayList;
import java.util.List;

import org.htmlparser.Tag;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.Span;
import org.htmlparser.visitors.NodeVisitor;

import com.study.open.htmlparser.StaticData;
import com.study.open.htmlparser.bean.Community;

public class CommunityPageDivVisitor extends NodeVisitor{
	private List<Community> communityList = new ArrayList<Community>();
	private String nextPageLink;
//	private String name;
//	private String link;
//	private String price;
	@Override
	public void visitTag(Tag tag){
		
        if (tag instanceof Div) {    
            Div div = (Div) tag;    
            String attr = div.getAttribute("class"); //detailed_rig
            //System.out.println("attr:" + attr);
            if("detailed_rig".equals(attr)){ //小区div
            	
            	//System.out.println("========================="+div.toHtml());
            	SpanVisitor sv = new SpanVisitor();
            	//LinkVisitor lv = new LinkVisitor();
            	//div.accept(lv);
            	//link = lv.getLink();
            	div.accept(sv);
            	Community com = new Community(sv.getName(), sv.getLink()+"esf/", sv.getPrice());
            	communityList.add(com);
//            	System.out.println("name:"+name +" price:"+price + " link:"+link);
            }
            if("fanye".equals(attr)){
            	NextPageVisitor np = new NextPageVisitor();
            	div.accept(np);
            	nextPageLink =np.getLink();
            	//System.out.println("link:" +np.getLink() );
            }
            //line = textnode.toPlainTextString().trim();    
            //line = textnode.getText();    
        } 		
	}
	public List<Community> getCommunityList() {
		return communityList;
	}
	public String getNextPageLink() {
		return nextPageLink;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Community com: communityList){
			sb.append(com.getName()+" : "+com.getPrice()+" : " +com.getUrl()+"\n");
		}
		return sb.toString();
	}
}

class SpanVisitor  extends NodeVisitor{
	//private List<Span> list = new ArrayList<Span>();
	private String name;
	private String link;
	private String price;
	private int i =0;
	@Override
	public void visitTag(Tag tag){
        if (tag instanceof Span) {
        	Span span = (Span)tag;
        	i++;
        	//System.out.println("Span========"+i+span.getText());
        	LinkVisitor lv = new LinkVisitor();
        	if(i==1){
        		span.accept(lv);
        		link = lv.getLink();
        	}
        	if(i==3){
        		name =span.getStringText();
        	}
        	if(i==4){
        		price = span.getStringText();
        	}
        } 		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}

