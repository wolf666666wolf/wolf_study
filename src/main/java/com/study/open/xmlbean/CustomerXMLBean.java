package com.study.open.xmlbean;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.xmlbeans.XmlException;

import com.study.open.xmlbean.person.AddressDocument.Address;
import com.study.open.xmlbean.person.BillingAddressDocument.BillingAddress;
import com.study.open.xmlbean.person.CustomerDocument.Customer;
import com.study.open.xmlbean.person.CustomersDocument;
import com.study.open.xmlbean.person.GenderDocument.Gender;
import com.study.open.xmlbean.person.PrimaryAddressDocument.PrimaryAddress;

public class CustomerXMLBean {

	private String filename;
	public CustomerXMLBean(String filename){
		this.filename = filename;
	}
	
	public void customerReader(){
		File xmlfile = new File(filename);
		try {
			CustomersDocument cd = CustomersDocument.Factory.parse(xmlfile);
			Customer[] customers=cd.getCustomers().getCustomerArray();
			for(Customer customer: customers){
				System.out.println("customer.id:"+customer.getId());
				System.out.println("customer.PhoneNumber:"+customer.getPhoneNumber());
				System.out.println("customer.getFirstname:"+customer.getFirstname());
				System.out.println("customer.getLastname:"+customer.getLastname());
				System.out.println("customer.getGender:"+customer.getGender());
				PrimaryAddress pa = customer.getAddress().getPrimaryAddress();
				System.out.println("customer.primaryAddress.postalCode:"+pa.getPostalCode());
				System.out.println("customer.primaryAddress.AddressLine1:"+pa.getAddressLine1());
				System.out.println("customer.primaryAddress.AddressLine2:"+pa.getAddressLine2());
				BillingAddress ba = customer.getAddress().getBillingAddress();
				System.out.println("customer.billingAddress.postalCode:"+ba.getPostalCode());
				System.out.println("customer.billingAddress.AddressLine1:"+ba.getAddressLine1());
				System.out.println("customer.billingAddress.AddressLine2:"+ba.getAddressLine2());
				
			}
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void createCustomer(){
		CustomersDocument cd = CustomersDocument.Factory.newInstance();
		Customer customer = cd.addNewCustomers().addNewCustomer();
		customer.setId(3);
		customer.setPhoneNumber("400-800-123");
		customer.setFirstname("小丸子");
		customer.setLastname("樱桃");
		customer.setGender(Gender.MALE);
		Address address=customer.addNewAddress();
		PrimaryAddress pa = address.addNewPrimaryAddress();
		pa.setPostalCode("100020");
		pa.setAddressLine1("朝阳区");
		pa.setAddressLine2("呼家楼");
		BillingAddress ba = address.addNewBillingAddress();
		ba.setPostalCode("100019");
		ba.setAddressLine1("海淀区");
		ba.setAddressLine2("清河");
		ba.setReceiver("丸子他妈");

		
		File xmlfile = new File(filename);
		try {
			cd.save(xmlfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public void updateCustomer(int id, String firstname){
		File file = new File(filename);
		CustomersDocument cd = null;
		try {
			cd = CustomersDocument.Factory.parse(file);
		} catch (XmlException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Customer[] customers = cd.getCustomers().getCustomerArray();
		for(Customer customer: customers){
			if(customer.getId()==id){
				customer.setFirstname(firstname+new Date());
				break;
			}
		}
		try {
			cd.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCustomer(int id){
		File file = new File(filename);
		CustomersDocument cd = null;
		try {
			cd = CustomersDocument.Factory.parse(file);
		} catch (XmlException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Customer[] customers = cd.getCustomers().getCustomerArray();
		for(Customer customer: customers){
			if(customer.getId()==id){
				customer.setNil();
				break;
			}
		}
		try {
			cd.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	public static void main(String[] args){
		String filename = CustomerXMLBean.class.getResource("customers.xml").getPath();
		System.out.println("filename:"+filename);
		//read
		CustomerXMLBean csb = new CustomerXMLBean(filename);
		csb.customerReader();
		//create
		filename = CustomerXMLBean.class.getResource("").getPath()+"customers_new.xml";
		System.out.println("filename:"+filename);
		csb = new CustomerXMLBean(filename);		
		csb.createCustomer();
		csb.customerReader();
		//update
		csb.updateCustomer(3, "DaoTaiLang");
		csb.customerReader();
		//delete
		csb.deleteCustomer(3);
		csb.customerReader();
	}
}
