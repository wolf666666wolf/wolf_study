/*
 * JDomDemo.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.open.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.jdom2.Attribute;
import org.jdom2.Comment;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPath;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;




public class JDomDemo {

  public static void parseXml(File xmlFile){
    SAXBuilder sax = new SAXBuilder();
    try {
      Document xmlDom = sax.build(xmlFile);
      Element root = xmlDom.getRootElement();
      System.out.println("根元素是:"+root.getName()); 
      List<Element> children = root.getChildren();
      for(Element ele: children){
        System.out.println("ele.name:"+ele.getName());
      }
      
      Element firstChild = children.get(0);
      List<Attribute> attrList = firstChild.getAttributes();
      for(Attribute attr: attrList){
        System.out.println("attr.name:"+attr.getName() + " attr.value:" + attr.getValue());
      }    
      

      
      XPathExpression<Element> xpath = XPathFactory.instance().compile("/persons/person/address", Filters.element());
      Element emt = xpath.evaluateFirst(xmlDom);
      if (emt != null) {
        System.out.println("XPath has result: " + emt.getName());
      }      
      
      
      
      
//      XPath xpath = XPathFactory.newInstance().newXPath();
//      //XPathExpression  expression = xpath.compile("/persons/person");
//      String address=null;
//      try {
//        address = xpath.evaluate("/persons/person/address", xmlDom);
//      } catch (XPathExpressionException e) {        
//        e.printStackTrace();
//      }
//      System.out.println("XPath address: " + address);
      
//      XPathExpression<Element> xpath = XPathFactory.newInstance()..compile("//persons/info", Filters.element());
//      List<Element> elements = xpath.evaluate(xmlDom);
//      for (Element emt : elements) {
//          System.out.println("XPath has result: " + emt.getName());
//      }   
      
    } catch (JDOMException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void writeXml(String xmlFilePath){
    Document doc = new Document();
    Element root = new Element("persons");
    doc.addContent(root);
    Element person= new Element("person");
    person.addContent(new Comment("this is the first person"));
    Attribute attr = new Attribute("borntime", "1980");
    Element age = new Element("age").setAttribute(attr).setAttribute("bornplace", "beijing");
    age.setText("31");
    person.addContent(age);
    root.addContent(person);

    Format format = Format.getPrettyFormat();
    XMLOutputter out = new XMLOutputter(format);
    String xmlContent = out.outputString(doc);
    System.out.println("xmlContent:"+xmlContent);   
    try {
      out.output(doc, new FileOutputStream(xmlFilePath));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args){
    File xmlFile = new File(JDomDemo.class.getResource("person.xml").getPath());
    parseXml(xmlFile);
    
//    String file = JDomDemo.class.getResource("person.xml").getPath().replace("person.xml", "person1.xml");
//    System.out.println("filepath:" + file);
//    writeXml(file);
    
  }
}
