/*
 * ZipUtil.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtil {
  private static final String EXT=".zip";
  private static final String BASE_DIR="";  // 压缩包内相对路径
  private static final int BUFFER=1024;
  private static final String PATH="/";
  
  public static void compress(String srcPath) throws Exception{
    File srcFile = new File(srcPath);
    compress(srcFile);
  }
  public static void compress(File srcFile) throws Exception{
    String name = srcFile.getName();
    String basePath = srcFile.getParent();
    String destPath = basePath + PATH + name + EXT;   //输出路径
    compress(srcFile, destPath);
  }
  
  public static void compress(File srcFile, String destPath)throws Exception{
    File destFile = new File(destPath);
    CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(destPath), new CRC32());
    ZipOutputStream zos = new ZipOutputStream(cos);
    compress(srcFile, zos, BASE_DIR);
    zos.flush();
    zos.close();
  }
  
  public static void compress(File srcFile, ZipOutputStream zos, String baseDir) throws Exception{
    if(srcFile.isDirectory()){
      compressDir(srcFile, zos, baseDir);
    }else{
      compressFile(srcFile, zos, baseDir);
    }
  }

  
  public static void compressDir(File dir, ZipOutputStream zos, String basePath) throws Exception{
    File[] files = dir.listFiles();
    if(files.length < 1){
      ZipEntry entry = new ZipEntry(basePath + dir.getName() + PATH);
      zos.putNextEntry(entry);
      zos.closeEntry();
    }
    for(File file: files){
      compress(file, zos, basePath + file.getName());
    }
  }
  
  public static void compressFile(File file, ZipOutputStream zos, String dir) throws Exception{
    /** 
     * 压缩包内文件名定义 
     *  
     * <pre> 
     * 如果有多级目录，那么这里就需要给出包含目录的文件名 
     * 如果用WinRAR打开压缩包，中文名将显示为乱码 
     * </pre> 
     */
    ZipEntry entry = new ZipEntry(dir + file.getName());
    zos.putNextEntry(entry);
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
    int count;
    byte[] data = new byte[BUFFER];
    while((count = bis.read(data, 0, BUFFER))!=-1){
      zos.write(data, 0, count);
    }
    bis.close();
    zos.closeEntry();
  }
  
  
  public static void decompress(String srcPath) throws Exception{
    File srcFile = new File(srcPath);
    decompress(srcFile);
  }
  public static void decompress(File srcFile) throws Exception{
    String basePath = srcFile.getParent();
    decompress(srcFile, basePath);
  }
  public static void decompress(File srcFile, String destPath) throws Exception{
    decompress(srcFile, new File(destPath));
  }
  public static void decompress(File srcFile, File destFile) throws Exception{
    CheckedInputStream cis = new CheckedInputStream(new FileInputStream(srcFile), new CRC32());
    ZipInputStream zis = new ZipInputStream(cis);
    decompress(destFile, zis);
    zis.close();
  }
  public static void decompress(File destFile, ZipInputStream zis) throws Exception{
    ZipEntry entry = null;
    while((entry = zis.getNextEntry())!=null){
      String dir = destFile.getPath() + File.separator + entry.getName();
      File dirFile = new File(dir);
      //文件检查
      fileProber(dirFile);
      
      if(entry.isDirectory()){
        dirFile.mkdirs();
      }else{
        decompressFile(destFile, zis);
      }     
    }
  }
  private static void fileProber(File dirFile){
    File parentFile = dirFile.getParentFile();
    if(!parentFile.exists()){
      fileProber(parentFile);
      parentFile.mkdir();
    }
  }
  private static void decompressFile(File destFile, ZipInputStream zis) throws Exception{
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
    int count;
    byte[] data = new byte[BUFFER];
    while((count = zis.read(data, 0, BUFFER))!=-1){
      bos.write(data, 0, count);
    }
    bos.close();
  }
  public static void main(String[] args){
    String file1 = "K:/xml/deem.xml";
    String file2 = "K:/xml";
    try {
      ZipUtil.compress(file1);
      ZipUtil.compress(file2);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
