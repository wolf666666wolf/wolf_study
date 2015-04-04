/*
 * DynamicSubject.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.reflaction.dynamicpoxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicSubject implements InvocationHandler{
  private Object obj;
  
  public DynamicSubject(Object obj){
    this.obj = obj;
  }
  @Override
  public Object invoke(Object proxy, Method method, Object[] args)
      throws Throwable {
      System.out.println("Before call method ++++++++++++++++");
      method.invoke(obj, args);
      System.out.println("After call method ++++++++++++++++");
    
    return null;
  }

}
