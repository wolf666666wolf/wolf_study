package com.study.open.htmlparser.bean;

import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


public class Distract {
	private String pname;
	private String name;
//	private String link;
//	private String baseUrl;
	private String url;
	private String num;
	private Set<Distract> subDistract;
	public Distract(){}
	public Distract(String name, String url) {
		this.name = name;
		this.url = url;
//		this.link = link;
//		this.baseUrl = baseUrl;
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

	public Set<Distract> getSubDistract() {
		return subDistract;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public void setSubDistract(Set<Distract> subDistract) {
		this.subDistract = subDistract;
	}

//	public String getBaseUrl() {
//		return baseUrl;
//	}
//
//	public void setBaseUrl(String baseUrl) {
//		this.baseUrl = baseUrl;
//	}

	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}
		if(obj.getClass() != this.getClass()){
			return false;
		}
		Distract stuff = (Distract)obj;
//		return new EqualsBuilder().append(this.getPname(), stuff.getPname())
//		.append(this.getName(), stuff.getName())
//		.append(this.getLink(), stuff.getLink()).isEquals();
		return new EqualsBuilder().append(this.getUrl(), stuff.getUrl()).isEquals();		
	}
	@Override
	public int hashCode(){
		return new HashCodeBuilder(11, 23).append(this.getUrl()).toHashCode();
	}
	@Override 
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.name).append(" : ").append(this.url).append("\n");
		if(subDistract!=null && !subDistract.isEmpty()){
			for(Distract dis: subDistract)
			sb.append("    +").append(dis.getName()).append(" : ").append(dis.getUrl()).append("\n");
		}
		
		
		return sb.toString();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
