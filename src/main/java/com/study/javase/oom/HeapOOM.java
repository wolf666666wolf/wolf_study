/*
 * HeapOOM.java
 * Copyright 2002-2013 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * vm args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @description 
 * @author Bull
 * @version 0.1
 * @date Mar 5, 2013 5:46:22 PM
 */
public class HeapOOM {

  static class OOMObject{
    private byte[] test=new byte[1024];
  }
  
  public static void main(String[] args){
    List<OOMObject> oomList = new ArrayList<OOMObject>();
    while(true){
      oomList.add(new OOMObject());
    }
  }
  
}

/**
result:
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid7312.hprof ...
Heap dump file created [20622066 bytes in 0.048 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    at com.study.javase.oom.HeapOOM$OOMObject.<init>(HeapOOM.java:22)
    at com.study.javase.oom.HeapOOM.main(HeapOOM.java:28)
*/