/*
 * XSLTTransform.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.xml;

import java.io.StringWriter;
import java.io.Writer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTTransform {
  private static String xmlFileName = SchemaValidate.class.getResource("ReturnForm.xml").getPath();
  private static String xsltFileName = SchemaValidate.class.getResource("ReturnForm_Engine.xslt").getPath();

  public static String transform(String xmlname, String xsltname) throws TransformerException{
    TransformerFactory factory = TransformerFactory.newInstance();
    Transformer transformer = factory.newTransformer(new StreamSource(xsltname));
    Writer outWriter = new StringWriter();
    StreamResult outSource = new StreamResult(outWriter);
    transformer.transform(new StreamSource(xmlname), outSource);
    return outWriter.toString();  
       
  }
  public static void main(String[] args){
     try {
      String xml = transform(xmlFileName, xsltFileName);
      System.out.println(xml);
    } catch (TransformerException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
