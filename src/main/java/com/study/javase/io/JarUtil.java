/*
 * JarUtil.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.hsqldb.lib.FileUtil;

public class JarUtil {

  public static void main(String[] args) throws IOException, ClassNotFoundException{
           
    String path = getJarPath(FileUtil.class);
    listJarFiles(path);
    
    getJarContent(path);

  }
  
  /**
   * 这个方法有个问题： 当调用String.class时会失败
   * @description 
   * @author Bull
   * @param cls
   * @return
   * @throws UnsupportedEncodingException
   */
  public static String getJarPath(Class cls) throws UnsupportedEncodingException{
    String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
    System.out.println(path);
    File file = new File(path);
    path = file.getAbsolutePath();
    path = java.net.URLDecoder.decode(path, "UTF-8");
    System.out.println(path);  
    return path;
  }
  
  /**
   *  遍历jar中的内容
   * @description 
   * @author Bull
   * @param jarPath
   * @throws IOException
   */
  public static void listJarFiles(String jarPath) throws IOException{
    JarFile jarFile = new JarFile(jarPath);
    Enumeration<JarEntry> jarEntrys = jarFile.entries();
    while(jarEntrys.hasMoreElements()){
      JarEntry jarEntry = jarEntrys.nextElement();
      System.out.println(jarEntry.getName());
    }
  }
  
  /**
   * read the content of on item
   * @description 
   * @author Bull
   * @throws IOException 
   */
  public static void getJarContent(String jarFilePath) throws IOException{
    System.out.println("##############################################");
    JarFile jarFile = new JarFile(jarFilePath);
    JarEntry jarEntry = jarFile.getJarEntry("META-INF/hsqldb_lic.txt");
    InputStream in = jarFile.getInputStream(jarEntry);
    int c=-1;
    while((c=in.read()) != -1){
      System.out.print((char)c);
    }   
    
  }
}
