package com.study.open.htmlparser.visitor;

import java.util.ArrayList;
import java.util.List;

import org.htmlparser.Tag;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.Span;
import org.htmlparser.visitors.NodeVisitor;

import com.study.open.htmlparser.bean.House;
import com.study.open.htmlparser.v1.HouseULVisitor;

public class HousePageDivVisitor extends NodeVisitor{
	private List<House> houseList = new ArrayList<House>();
	private String nextPageLink;
//	private String name;
//	private String link;
//	private String price;
	@Override
	public void visitTag(Tag tag){
		
        if (tag instanceof Div) {    
            Div div = (Div) tag;    
            String attr = div.getAttribute("class"); //detailed_rig
            System.out.println("attr:" + attr);
            
            //if("detailed_information".equals(attr)){ //小区div
            if("genoce".equalsIgnoreCase(attr)){ //小区div
                System.out.println("genoce:"+div.toHtml());
                HouseULVisitor hlv = new HouseULVisitor();
            	div.accept(hlv);

//            	HouseSpanVisitor sv = new HouseSpanVisitor();

//            	div.accept(sv);
            	House house = new House();
            	house.setArea(hlv.getArea());
//            	house.setBaseUrl(StaticData.baseUrl);
            	house.setUrl(hlv.getLink());
            	house.setName(hlv.getName());
            	house.setPrice(hlv.getPrice());
            	house.setValue(hlv.getValue());
            	house.setRooms(hlv.getRooms());
            	
            	houseList.add(house);
            	//System.out.println("housename:" + house.toString());
            }
            if("fanye".equalsIgnoreCase(attr)){
            	NextPageVisitor np = new NextPageVisitor();
            	
            	div.accept(np);
            	nextPageLink =np.getLink();
            	//System.out.println("link:" +np.getLink() );
            }
            //line = textnode.toPlainTextString().trim();    
            //line = textnode.getText();    
        } 		
	}
	public List<House> getHouseList() {
		return houseList;
	}
	public String getNextPageLink() {
		return nextPageLink;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(House com: houseList){
			sb.append(com.getName()+" : "+com.getPrice()+" : " +com.getUrl()+"\n");
		}
		return sb.toString();
	}
}
class HouseSpanVisitor  extends NodeVisitor{
	//private List<Span> list = new ArrayList<Span>();
	private final String UNIT="万";
	private String name;
	private String link;
	private String value;
	private int i =0;
	@Override
	public void visitTag(Tag tag){
        if (tag instanceof Span) {
        	Span span = (Span)tag;
        	//System.out.println("span---------"+span.toHtml());
        	i++;
        	//System.out.println("Span========"+i+span.getText());
        	LinkVisitor lv = new LinkVisitor();
        	if(i==1){
        		span.accept(lv);
        		link = lv.getLink();
        		name = lv.getName();
        		//name = span.getStringText();
        	}
        	if(i==2){
        		value =span.getStringText();
        		if(value!=null && value.indexOf(UNIT)>=0){
        			value = value.substring(0, value.indexOf(UNIT));
        		}
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}

/**<ul>

				<li><strong class="font14"><span><a href="/ershoufang/ff80808133ee5b080133f87345cc5204.shtml" target="_blank">龙湖香醍漫步托斯卡纳风格业主急售中急急急</a></span></strong></li>
				<li class="juli">
131平米&nbsp;&nbsp;13358.78元/平米&nbsp;&nbsp;3室2厅<br>
高楼层/8层&nbsp;&nbsp;南北&nbsp;&nbsp;-1年房龄</li>
<li>梁杰锋&nbsp;<label>400-010-1111转5600</label></li>
			</ul>
 * 
 */

class HouseLiVisitor  extends NodeVisitor{
	//private List<Span> list = new ArrayList<Span>();
	private String area;
	private String unit;
	private String price;
	private String rooms;
	@Override
	public void visitTag(Tag tag){
		String attr = tag.getAttribute("class");
		if("juli".equals(attr)){
			String text = tag.toPlainTextString();
//			128平米&nbsp;&nbsp;14062.5元/平米&nbsp;&nbsp;3室1厅
//			高楼层/9层&nbsp;&nbsp;南北&nbsp;&nbsp;3年房龄
			
//			#################0:
//				128平米
//				#################1:14062.5元/平米
//				#################2:3室1厅
//				高楼层/9层
//				#################3:南北			
			String[] temp = text.split("&nbsp;&nbsp;");
			area = temp[0].substring(0, temp[0].indexOf("平米")).trim();
			price = temp[1].substring(0, temp[1].indexOf("元/平米")).trim();
			rooms = temp[2].substring(0, temp[2].indexOf("厅")+"厅".length()).trim();
//			System.out.println("#################0:"+area);
//			System.out.println("#################1:"+price);
//			System.out.println("#################2:"+rooms);

		}		
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRooms() {
		return rooms;
	}
	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

}

