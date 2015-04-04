/*
 * SchemaValidate.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.xml;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXValidator;
import org.dom4j.io.XMLWriter;
import org.dom4j.util.XMLErrorHandler;



public class SchemaValidate {
  private static String xmlFileName = SchemaValidate.class.getResource("note.xml").getPath();//"Q:\\_dev_stu\\xsdtest\\src\\note.xml";
  private static String xsdFileName = SchemaValidate.class.getResource("note.xsd").getPath(); 
  /**
   * 通过XSD（XML Schema）校验XML
   */
  public static void validateXMLByXSDWithDom4j() {

      try {
          //创建默认的XML错误处理器
          XMLErrorHandler errorHandler = new XMLErrorHandler();
          //获取基于 SAX 的解析器的实例
          SAXParserFactory factory = SAXParserFactory.newInstance();
          //解析器在解析时验证 XML 内容。
          factory.setValidating(true);
          //指定由此代码生成的解析器将提供对 XML 名称空间的支持。
          factory.setNamespaceAware(true);
          //使用当前配置的工厂参数创建 SAXParser 的一个新实例。
          SAXParser parser = factory.newSAXParser();
          //创建一个读取工具
          SAXReader xmlReader = new SAXReader();
          //获取要校验xml文档实例
          Document xmlDocument = (Document) xmlReader.read(new File(xmlFileName));
          //设置 XMLReader 的基础实现中的特定属性。核心功能和属性列表可以在 [url]http://sax.sourceforge.net/?selected=get-set[/url] 中找到。
          parser.setProperty(
                  "http://java.sun.com/xml/jaxp/properties/schemaLanguage",
                  "http://www.w3.org/2001/XMLSchema");
          parser.setProperty(
                  "http://java.sun.com/xml/jaxp/properties/schemaSource",
                  "file:" + xsdFileName);
          //创建一个SAXValidator校验工具，并设置校验工具的属性
          SAXValidator validator = new SAXValidator(parser.getXMLReader());
          //设置校验工具的错误处理器，当发生错误时，可以从处理器对象中得到错误信息。
          validator.setErrorHandler(errorHandler);
          //校验
          validator.validate(xmlDocument);

          XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());
          //如果错误信息不为空，说明校验失败，打印错误信息
          if (errorHandler.getErrors().hasContent()) {
              System.out.println("XML文件通过XSD文件校验失败！");
              writer.write(errorHandler.getErrors());
          } else {
              System.out.println("Good! XML文件通过XSD文件校验成功！");
          }
      } catch (Exception ex) {
          System.out.println("XML文件: " + xmlFileName + " 通过XSD文件:" + xsdFileName + "检验失败。\n原因： " + ex.getMessage());
          ex.printStackTrace();
      }
  }
  
  public static void valideWithJDK(){
    Schema schema=null;  
    try {  
          
        //String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String language = XMLConstants.XML_NS_URI; 
        SchemaFactory factory = SchemaFactory.newInstance(language);  
        schema = factory.newSchema(new File(xsdFileName));//Schema.xml改成您的schema文件名 后缀可以为xsd  
        Validator validator=schema.newValidator();  
        validator.validate(new StreamSource(xmlFileName));//patterns.xml改为您要验证的xml文件名  
        System.out.println("success!!!");
    } catch (Exception e) {  
        System.out.println(e.getMessage());  
    }     
  }
  public static void main(String[] args){
    //validateXMLByXSDWithDom4j();
    valideWithJDK();
  }
}
