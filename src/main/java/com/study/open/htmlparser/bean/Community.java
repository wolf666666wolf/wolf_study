package com.study.open.htmlparser.bean;


public class Community {
	private String pname;
	private String name;
//	private String link;
//	private String baseUrl;
	private String price;
	private String url;
	private String num;
	public Community(){}
	public Community(String name, String url, String price) {
		super();
		this.name = name;
		this.url = url;
//		this.link = link;
//		this.baseUrl = baseUrl;
		this.price = price;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getLink() {
//		return link;
//	}
//	public void setLink(String link) {
//		this.link = link;
//	}
//	public String getBaseUrl() {
//		return baseUrl;
//	}
//	public void setBaseUrl(String baseUrl) {
//		this.baseUrl = baseUrl;
//	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}

	
}
