/*
 * JavaVmStackSOF.java
 * Copyright 2002-2013 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.oom;

/**
 * vm args: -Xss128k
 * 原因：线程请求的栈深度大于虚拟机允许的栈深度
 * @description 
 * @author Bull
 * @version 0.1
 * @date Mar 5, 2013 6:02:33 PM
 */
public class JavaVmStackSOF {

  private int staticLength = 1;
  public void stackLeak(){
    staticLength++;
    stackLeak();
  }
  
  public static void main(String[] args) throws Throwable{
    JavaVmStackSOF sof = new JavaVmStackSOF();
    try{
      sof.stackLeak();
    }catch(Throwable e){
      System.out.println("static length:" + sof.staticLength);
      throw e;
    }
  }
}

/**
 * result:
 * Exception in thread "main" static length:1007
   java.lang.StackOverflowError
*/