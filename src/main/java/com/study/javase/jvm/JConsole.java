/*
 * JConsole.java
 * Copyright 2002-2013 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.jvm;

import java.util.ArrayList;
import java.util.List;

public class JConsole {

  static class OOMObject{
    public byte[] placeholder = new byte[64 * 1024];
  }
  
  public static void fillHeap(int num){
    List<OOMObject> list = new ArrayList<OOMObject>();
    
  }
}
