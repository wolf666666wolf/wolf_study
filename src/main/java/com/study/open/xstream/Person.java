package com.study.open.xstream;

import java.util.List;

public class Person {
	  private String firstname;
	  private String lastname;
	  private PhoneNumber phone;
	  private PhoneNumber fax;
	  private List<PhoneNumber> otherPhones;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public PhoneNumber getPhone() {
		return phone;
	}
	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}
	public PhoneNumber getFax() {
		return fax;
	}
	public void setFax(PhoneNumber fax) {
		this.fax = fax;
	}
	public List<PhoneNumber> getOtherPhones() {
		return otherPhones;
	}
	public void setOtherPhones(List<PhoneNumber> otherPhones) {
		this.otherPhones = otherPhones;
	}

	public String toString(){

		StringBuffer sb = new StringBuffer();
		sb.append("firstname:"+firstname +"\r");
		sb.append("lastname:"+lastname +"\r");
		sb.append("phone:"+phone.toString() +"\r");
		sb.append("fax:"+fax.toString() +"\r");
		sb.append("otherPhones:"+otherPhones.toString() +"\r");
		return sb.toString();
	}

}
