/*
 * BookFacadeCglib.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.reflaction.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class BookFacadeCglib implements MethodInterceptor{
  private Object target;
  
  public Object getInstance(Object target){
    this.target = target;
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(this.target.getClass());
    enhancer.setCallback(this);
    return enhancer.create();
    
  }
  @Override
  public Object intercept(Object obj, Method method, Object[] args,
      MethodProxy proxy) throws Throwable {
      System.out.println("start++++++++++++++++++++++");
      proxy.invokeSuper(obj, args);
      System.out.println("end++++++++++++++++++++++");
    return null;
  }

}
