/*
 * Client.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.reflaction.cglib;

public class Client {
  public static void main(String[] args){
    BookFacadeCglib bfc = new BookFacadeCglib();
    BookFacadeImpl1 newobj = (BookFacadeImpl1)bfc.getInstance(new BookFacadeImpl1());
    newobj.addBook();
  }
  
  
}
