/*
 * FileEncode.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.encode;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * 在这个示例中
 * @description 
 * @author Bull
 * @version 0.1
 * @date Aug 15, 2012 2:43:17 PM
 */
public class FileEncode {

  public static void main(String[] args) throws IOException{
    
    
    String ansiFileName = "ANSI_ENCODE.txt";
    String utf8FileName = "UTF8_ENCODE.txt";
    int BUFFER=1024;
    File ansiFile = new File(FileEncode.class.getResource(ansiFileName).getPath());
    InputStream isa = FileEncode.class.getResourceAsStream(ansiFileName);
    InputStream isu = FileEncode.class.getResourceAsStream(utf8FileName);

    //System.out.println("@@@:"+getEncode(isa));
    //InputStreamReader isr = new InputStreamReader(isa);
    BufferedOutputStream bos = null;
    int count;
    byte[] data = new byte[BUFFER]; 
    ByteArrayOutputStream baosa = new ByteArrayOutputStream();
    while((count = isa.read())!=-1){
      baosa.write(count);
    }
    System.out.println("ansi:"+ new String(baosa.toByteArray()));
    System.out.println("ansi:"+ new String(baosa.toByteArray(), "UTF-8"));
    System.out.println("ansi:"+ new String(baosa.toByteArray(), "GBK"));
    System.out.println("ansi:"+baosa.toString("UTF-8"));
    System.out.println("ansi:"+baosa.toString("GBK"));
    System.out.println("ansi:"+baosa.toString("GB2312"));
    
    ByteArrayOutputStream baosu = new ByteArrayOutputStream();
    while((count = isu.read(data, 0, BUFFER))!=-1){
      baosu.write(data, 0, count);
    }    
    System.out.println("utf8:"+baosu.toString());
    
    

    
    
    
    //BufferedReader d = new BufferedReader(new InputStreamReader(isa, "GBK"));// , "UTF-8"
    InputStreamReader isr = new InputStreamReader(new FileInputStream(ansiFile), "gb2312");
    BufferedReader d = new BufferedReader(isr);
    String str = null;
    while((str = d.readLine())!=null){
      System.out.println("read line:"+str);  
    }
    
    String line = null;
    
    while((count = isr.read())!=-1){
      baosa.write(count);
    }
    System.out.println("###:"+baosa.toString("gb2312"));
    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    
    Writer ow = new OutputStreamWriter(baos, "gb2312");
    ow.write(baosa.toString());
    ow.flush();
    //String outstr = ow.toString();
    //ow.write(content.toString());
    System.out.println("####1:" + baos.toString());
    
    
    ow.close();    
    
    
    isa.close();
    baosa.close();
    isu.close();
    baosu.close();    
    
    //d.close();
    isr.close();
  }
  /**
   * file ANSI_ENCODE.txt is ANSI encode file.
   * I hava try a lot method, but still can not read the content
   * @description 
   * @author Bull
   * @throws IOException 
   */
  public static void readAnsiFile() throws IOException{
    String ansiFileName = "ANSI_ENCODE.txt";
    InputStream isa = FileEncode.class.getResourceAsStream(ansiFileName);
    int count;
    ByteArrayOutputStream baosa = new ByteArrayOutputStream();
    while((count = isa.read())!=-1){
      baosa.write(count);
    }
    System.out.println("ansi:"+ new String(baosa.toByteArray()));
    System.out.println("ansi:"+ new String(baosa.toByteArray(), "UTF-8"));
    System.out.println("ansi:"+ new String(baosa.toByteArray(), "GBK"));
    System.out.println("ansi:"+baosa.toString("UTF-8"));
    System.out.println("ansi:"+baosa.toString("GBK"));
    System.out.println("ansi:"+baosa.toString("GB2312"));
  }
  
  /**
   * some times we know a file encode eg: GBK, UTF-8, 
   * we can read and write the file with a specfied encode
   * we nee use InputStreamReader and InputStreamWriter
   * @description 
   * @author Bull
   */
  public static void readFileWithEncode(){
    
  }
  
  public static String getEncode(InputStream in){
    
    byte[] head = new byte[3];
    try {
      in.read(head);
    } catch (IOException e) {
      e.printStackTrace();
    }
    String code = "GB2312";
    if(head[0]==-1 && head[1]==-2){
      code = "UTF-16";
    }else if(head[0]==-2 && head[1]==-1){
      code = "Unicode";
    }else if(head[0]==-17 && head[1]==-69 && head[2]==-65){
      code = "UTF-8";
    }
    return code;
    
  }
}
