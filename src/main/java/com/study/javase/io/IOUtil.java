/*
 * IOUtil.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtil {
  public static InputStream String2InputStream(String str){
    ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());
    return stream;
  }
  public static String InputStream2String(InputStream is) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();
    String line = "";
    while((line = in.readLine())!=null){
      sb.append(line);
    }
    return sb.toString();
  }
  
  
  public static void main(String[] args){
    
  }
}
