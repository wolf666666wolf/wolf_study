/*
 * DumpMethod.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.reflaction;

import java.lang.reflect.Method;

public class DumpMethod {

  public static void main(String[] args) throws ClassNotFoundException{
    Class<?> clas = Class.forName(args[0]);
    Method[] methods = clas.getDeclaredMethods();
    for(Method method: methods){
      System.out.println(method.toString());
    }
  }
}
