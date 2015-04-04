/*
 * RuntimeConstantPoolOOM.java
 * Copyright 2002-2013 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.oom;

/**
 * vm args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 原因： 常量池满了,常量池在方法区
 */
import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {
  
  public static void main(String[] args){
    List<String> list = new ArrayList<String>(); //list 保持常量池的引用，避免full gc回收常量池
    int i=0;
    while(true){
      list.add(String.valueOf(i++).intern());
    }
  } 
}

/**
 * result:
 * Exception in thread "main" java.lang.OutOfMemoryError: PermGen space
    at java.lang.String.intern(Native Method)
    at com.study.javase.oom.RuntimeConstantPoolOOM.main(RuntimeConstantPoolOOM.java:22)
 */
