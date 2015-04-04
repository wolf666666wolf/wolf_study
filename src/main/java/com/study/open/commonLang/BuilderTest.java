package com.study.open.commonLang;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BuilderTest {
	public static void main(String[] args){
		StuffA sA = new StuffA(123, "zhangsan", new Date());
		StuffB sB = new StuffB(123, "zhangsan", new Date());
		System.out.println("StuffA:" +sA);
		System.out.println("StuffA.hashCode:" +sA.hashCode());
		System.out.println("StuffB:" +sB);
		System.out.println("StuffB.hashCode:" +sB.hashCode());
	}
}
class StuffA{
	private long stuffId;
	private String stuffName;
	private Date dateJoined;
	public StuffA(long stuffId, String stuffName, Date dateJoined){
		this.stuffId = stuffId;
		this.stuffName = stuffName;
		this.dateJoined = dateJoined;
	}
	public long getStuffId() {
		return stuffId;
	}
	public void setStuffId(long stuffId) {
		this.stuffId = stuffId;
	}
	public String getStuffName() {
		return stuffName;
	}
	public void setStuffName(String stuffName) {
		this.stuffName = stuffName;
	}
	public Date getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}
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
		StuffA stuff = (StuffA)obj;
		return new EqualsBuilder().append(this.getStuffId(), stuff.getStuffId())
		.append(this.getStuffName(), stuff.getStuffName())
		.append(this.getDateJoined(), stuff.getDateJoined()).isEquals();
	}
	@Override
	public int hashCode(){
		return new HashCodeBuilder(11, 23).append(stuffId).toHashCode();
	} 
	@Override
	public String toString(){
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
		.append("stuffId" + stuffId)
		.append("stuffName" + stuffName)
		.append("dateJoined" + dateJoined).toString();
	}
}

class StuffB{
	private long stuffId;
	private String stuffName;
	private Date dateJoined;
	public StuffB(long stuffId, String stuffName, Date dateJoined){
		this.stuffId = stuffId;
		this.stuffName = stuffName;
		this.dateJoined = dateJoined;
	}
	public long getStuffId() {
		return stuffId;
	}
	public void setStuffId(long stuffId) {
		this.stuffId = stuffId;
	}
	public String getStuffName() {
		return stuffName;
	}
	public void setStuffName(String stuffName) {
		this.stuffName = stuffName;
	}
	public Date getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}
	@Override
	public boolean equals(Object obj){
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	@Override
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this);
	} 
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}