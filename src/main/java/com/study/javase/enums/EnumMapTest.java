/*
 * EnumMapTest.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.enums;

import java.util.EnumMap;

public class EnumMapTest {
  public enum Priority{
    Heith(38),
    Medium(36.5),
    Low(6.5);
    
    double temperature;
    Priority(double p){ //can not use public , the construct menthod is private
      this.temperature = p;
    }
  }
  public static void test1(){
    EnumMap<Priority, String> descriptionMessage = new EnumMap<Priority, String>(Priority.class);
    descriptionMessage.put(Priority.Heith, "Temperature is to heigh");
    descriptionMessage.put(Priority.Medium, "Temperature is medium");
    descriptionMessage.put(Priority.Low, "Temperature is to low");
    for(Priority p: Priority.values()){
      System.out.println("message:" + p.name() +" " +descriptionMessage.get(p));
    }
  }
  public static void main(String[] args){
    test1();
  }
}




