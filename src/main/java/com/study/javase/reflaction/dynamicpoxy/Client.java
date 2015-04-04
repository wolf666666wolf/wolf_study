/*
 * Client.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.reflaction.dynamicpoxy;

import java.lang.reflect.Proxy;

public class Client {

  public static void main(String[] args){
    Subject sub = new RealSubject();
    DynamicSubject ds = new DynamicSubject(sub);
    Class<?> cls = sub.getClass();
    Subject dsub = (Subject)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
    dsub.request();
  }
}
