/*
 * HouseULVisitor.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.open.htmlparser.v1;

import org.htmlparser.Tag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.visitors.NodeVisitor;

/**
<div class="genoce">
    <a href="/ershoufang/ff8080813673cae101367850e45358dc.shtml" target="_blank"><img src="http://image.homelink.com.cn//houseSource/2012/4/3/29/photo_thumb/photo_thumb_ff8080813673cae101367852264a5969.jpg" alt="天通苑北一区3室1厅" /></a>
    <ul>
        <label>
            <span><a href="/ershoufang/ff8080813673cae101367850e45358dc.shtml" target="_blank">地铁5号线南北通透大三居送25万精装</a></span>
        </label>
        <br />北七家镇天通苑北一区
        <br />145.64平米&nbsp;14007.14元/平米&nbsp;3室1厅
        <br />低楼层/15层&nbsp;8年房龄
        <br />袁小武
        <span>400-010-1111转4878</span>
    </ul>
    <ol><span>204万</span></ol>
    <dl id="gzff8080813673cae101367850e45358dc"><a  href="javascript:;" onclick="guanzhu('ff8080813673cae101367850e45358dc','',1)">关注</a></dl>
</div>
* 
*/

public class HouseULVisitor  extends NodeVisitor{
  //private List<Span> list = new ArrayList<Span>();
  private String area;
  private String unit;
  private String price;
  private String rooms;
  private String value;
  private String link;
  private String name;
  private int i =0;
  private int j =0;
  private String ulStr="";
  @Override
  public void visitTag(Tag tag){
    
    String tagName = tag.getTagName();
    if("ol".equalsIgnoreCase(tagName)){
      String valuestr = tag.toPlainTextString();
      value = valuestr.substring(0, valuestr.indexOf("万"));
    }
    if("a".equalsIgnoreCase(tagName)){
      i++;
      if(i==2){
        LinkTag linkstr = (LinkTag)tag;
        link = linkstr.getLink();
        name = linkstr.getStringText();        
      }
    }
    if("ul".equalsIgnoreCase(tagName)){
      String tagstr= tag.toHtml();
      String[] tags = tagstr.split("<br />");
      String content = tags[2];
      System.out.println("+++++++++++++"+content);
      
      String[] temp = content.split("&nbsp;");
      area = temp[0].substring(0, temp[0].indexOf("平米")).trim();
      price = temp[1].substring(0, temp[1].indexOf("元/平米")).trim();
      rooms = temp[2].substring(0, temp[2].indexOf("厅")+"厅".length()).trim();      
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
  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }
  public String getLink() {
    return link;
  }
  public void setLink(String link) {
    this.link = link;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
}