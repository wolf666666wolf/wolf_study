package com.study.open.xstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

//From http://xstream.codehaus.org/objectstream.html
public class XstreamTest {

	public static void main(String[] args){
		XstreamTest test = new XstreamTest();
		//test.TestSimple();
		test.TestAlias(); 
		test.testWriteXML4OutStream();
		//test.testPersisterence();
	}
	 
	public void TestSimple(){
		XStream xstream = new XStream();
		//xstream = new XStream(new DomDriver()); // 需要xpp3 jar
		PhoneNumber ph = new PhoneNumber(101,"66661111");
		String xml = xstream.toXML(ph);
		System.out.println("xml=" + xml);
		
		String xmlsrc = "<com.study.xstream.PhoneNumber>"+
					 "<code>100</code>" +
					 "<number>66662222</number>"+
					 "</com.study.xstream.PhoneNumber>";
		PhoneNumber pnumber = (PhoneNumber)xstream.fromXML(xmlsrc);
		System.out.println("code=" + pnumber.getCode());
		System.out.println("code=" + pnumber.getNumber());
  	}
	
	public void TestAlias(){
		Person person = new Person();
		person.setFirstname("Alex");
		person.setLastname("Liu");
		person.setPhone(new PhoneNumber(100, "67780000"));
		person.setFax(new PhoneNumber(100, "67781111"));
		List<PhoneNumber> otherPhones = new ArrayList<PhoneNumber>();
		otherPhones.add(new PhoneNumber(101, "10000001"));
		otherPhones.add(new PhoneNumber(101, "10000002"));
		person.setOtherPhones(otherPhones);
		
		XStream xstream = new XStream();
		O("111"+xstream.toXML(person));
		xstream.alias("person", Person.class);
		xstream.alias("otherphone", PhoneNumber.class);
		xstream.aliasField("homephone", Person.class, "phone"); //把Person中的homephone显示为phone
		O("222"+xstream.toXML(person));
		
        //将ListBean中的集合设置空元素，即不显示集合元素标签       
//        xstream.addImplicitCollection(Person.class, "otherPhones"); 
//        O(xstream.toXML(person));
        //设置reference模型        
        //xstream.setMode(XStream.NO_REFERENCES);//不引用        
        xstream.setMode(XStream.ID_REFERENCES);//id引用    
        List<Person> listP = new ArrayList<Person>();
        
        O(xstream.toXML(person));
        //xstream.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);//绝对路径引用                  
        //将name设置为父类（Student）的元素的属性       
       // xstream.useAttributeFor(Student.class, "name");        
        // xstream.useAttributeFor(Birthday.class, "birthday"); 		
		
		
//		String xml = xstream.toXML(person);
//		Person ps = (Person)xstream.fromXML(xml);
//		O(ps.toString());
	}
	
	public void testAnnoaction(){
		
	}
	public void testWriteXML4OutStream(){

		File file = new File("K:/out.txt");
		
		Person person = new Person();
		person.setFirstname("Alex");
		person.setLastname("Liu");
		person.setPhone(new PhoneNumber(100, "67780000"));
		person.setFax(new PhoneNumber(100, "67781111"));
		List<PhoneNumber> otherPhones = new ArrayList<PhoneNumber>();
		otherPhones.add(new PhoneNumber(101, "10000001"));
		otherPhones.add(new PhoneNumber(101, "10000002"));
		person.setOtherPhones(otherPhones);		
		
		XStream xstream = new XStream();
		try{
			OutputStream os = new FileOutputStream(file);
			
			ObjectOutputStream out = xstream.createObjectOutputStream(new OutputStreamWriter(os), "root");
			out.writeObject(person);
			out.write(22);//byte        
			out.writeBoolean(true);       
			out.writeFloat(22.f);        
			out.writeUTF("hello");	
			 
			out.close();
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			Reader reader = new FileReader(file);
			ObjectInputStream in = xstream.createObjectInputStream(reader);
			Person p = (Person)in.readObject();
			
			
			O(p.toString());
			O(""+in.readByte());
	
			//O(utf);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void testPersisterence(){
		
		PersistenceStrategy strategy = new FilePersistenceStrategy(new File("."));
		List list = new XmlArrayList(strategy);
		list.add(new PhoneNumber(100, "67780000"));
		list.add(new PhoneNumber(100, "67780001"));
		list.add(new PhoneNumber(100, "67780002"));
		list.add(new PhoneNumber(100, "67780003"));
		
		list.add(new PhoneNumber(100, "67780004"));
		

		// remember the list is still there! the files int@[1-5].xml are still in /tmp!
		// the list was persisted!
		
		for(Iterator it = list.iterator(); it.hasNext(); ) {
			PhoneNumber phone = (PhoneNumber) it.next();
			if(phone.getNumber().equals("67780004")) {
				System.out.println("Removing 67780004...");
				it.remove();
			} else {
				System.out.println("Keeping " + phone.toString());
			}
		}		
		
	}
	
	public static void O(String outputstr){
		System.out.println("###############################start:");
		System.out.println(outputstr);
		System.out.println("###############################end");
	}
	
	

}
