/*
 * JDKDemo.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.open.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JDKDemo {

  public static void parseXmlWithJdk(File file) throws XPathExpressionException{
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder dbd;
    Document dom = null;
    try {
      dbd = dbf.newDocumentBuilder();
      dom = dbd.parse(file);
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    XPathFactory f = XPathFactory.newInstance();
    XPath path = f.newXPath();
    NodeList persons = (NodeList) path.evaluate("persons/person", dom, XPathConstants.NODESET);
    System.out.println("person.length:"+persons.getLength());
    if(persons != null){
      for(int i=0; i<persons.getLength(); i++){
        Node person = persons.item(i);
        System.out.println("nodename:"+person.getNodeName());
      }
    }
    
  //获得book的authors的第一个子节点,注意NODESET和NODE的区别
    Node person = (Node) path.evaluate("persons/person", dom, XPathConstants.NODE);
    System.out.println("nodename:"+person.getNodeName());
//    System.out.println("nodetext:"+person.getTextContent());
  //获取节点的属性
    NamedNodeMap attr = person.getAttributes();
    if(attr != null){
      for(int i=0; i<attr.getLength(); i++){
        System.out.println("attr.name:"+attr.item(i).getNodeName());
        System.out.println("attr.value:"+attr.item(i).getNodeValue());
      }
    }
    
    
  }
  public static void main(String[] args) throws ParserConfigurationException{
    File xmlFile = new File(JDomDemo.class.getResource("person.xml").getPath());
    try {
      parseXmlWithJdk(xmlFile);
    } catch (XPathExpressionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }  
}
