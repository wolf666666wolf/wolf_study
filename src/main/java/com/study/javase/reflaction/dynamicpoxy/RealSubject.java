/*
 * RealSubject.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.reflaction.dynamicpoxy;

public class RealSubject implements Subject{

  @Override
  public void request() {
   System.out.println("Hello world");
  }

}
