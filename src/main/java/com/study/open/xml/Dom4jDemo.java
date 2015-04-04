/*
 * Dom4jDemo.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.open.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class Dom4jDemo {
  public static Document parse(File file){
    SAXReader reader = new SAXReader();
    Document document=null;
    try {
      document = reader.read(file);
    } catch (DocumentException e) {
      e.printStackTrace();
    }
    return document;
  }

  public static void readXml(File file){
    Document dom = parse(file);
    Element root = dom.getRootElement();
    for(Iterator it = root.elementIterator(); it.hasNext();){
      Element element = (Element)it.next();
      System.out.println("ele.name:"+element.getName());
      System.out.println("ele.text:"+element.getText());
      System.out.println("ele.strvalue:"+element.getStringValue());
    }
    //element
    for(Iterator it = root.elementIterator("person"); it.hasNext();){
      Element element = (Element)it.next();
      System.out.println("ele.name:"+element.getName());     
    }
    //attribute
    for(Iterator it = root.attributeIterator(); it.hasNext();){
      Attribute attr = (Attribute)it.next();
      System.out.println(attr.getName() + "=" + attr.getValue()); 
    }
    

    
    
    
  }
  public static void testXPath(File file){
    Document dom = parse(file);
    //user xpath  
    Node node = dom.selectSingleNode("//persons/person/address");
    System.out.println("xml123:"+node.asXML());
    System.out.println(node.getName()+"=" + node.getText()); 
    
    
    List list = dom.selectNodes("//persons/person/address");
    for(Iterator iter = list.iterator(); iter.hasNext();){
      Element ele = (Element)iter.next();
      System.out.println(ele.getName() + ":" + ele.getText());
    }
  }
  
  public static void fastLooping(File file){
    Document dom = parse(file);
    fastloop(dom.getRootElement());
  }
  private static void fastloop(Element element){
    for(int i=0, size=element.nodeCount(); i<size; i++){
      Node node = element.node(i);
      
      if(node instanceof Element){
        fastloop((Element)node);
      }else{
        System.out.println("NodeType:" + node.getNodeType() + "NodeTypeName:" + node.getNodeTypeName());
      }
    }
  }
  
  public static void testWrite(File file) throws IOException{
    Document dom = parse(file);
    String text = dom.asXML();
    System.out.println(text);
    
    Document newDom = null;
    try {
      newDom = DocumentHelper.parseText(text);
      System.out.println("newDom:"+newDom.asXML());
    } catch (DocumentException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    String newfile = JDomDemo.class.getResource("person.xml").getPath().replace("person.xml", "person_dom4j.xml");
    System.out.println(newfile);
    XMLWriter writer = null;

      writer = new XMLWriter(new FileWriter(new File(newfile)));
      writer.write(newDom);
      writer.close();


 // Pretty print the document to System.out
    OutputFormat format = OutputFormat.createPrettyPrint();
    writer = new XMLWriter( System.out, format );
    writer.write( newDom );

    // Compact format to System.out
    format = OutputFormat.createCompactFormat();
    writer = new XMLWriter( System.out, format );
    writer.write( newDom );
    
  }
  public static void main(String[] args){
    File xmlFile = new File(Dom4jDemo.class.getResource("person.xml").getPath());
//    readXml(xmlFile);
    testXPath(xmlFile);
//    fastLooping(xmlFile);
    
    try {
      testWrite(xmlFile);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
