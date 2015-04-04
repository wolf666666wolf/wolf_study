/*
 * ArrayTester.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.reflaction;

import java.lang.reflect.Array;

public class ArrayTester {



  private static void StringArrayTest() throws ClassNotFoundException {
    Class<?> classType = Class.forName("java.lang.String");
    Object array = Array.newInstance(classType, 10);
    for(int i=0; i<10; i++){
      Array.set(array, i, "HelloWorld"+i);
    }
    
    for(int i=0; i<10; i++){
      System.out.println(""+Array.get(array, i));
    }
    
    String[] s = (String[])array;
    System.out.println("++++++++"+s[3]);
  }
  private static void MutiDeArrayTest(){
    System.out.println("++++++++++++++++Test muti dim array+++++++++++++");
    int[] dims = new int[]{5, 10, 15}; //三维数组
    Object array = Array.newInstance(Integer.class, dims);
    Object obj = Array.get(array, 3);  //得到第三个元素，一个二维数组
    Object obj1 = Array.get(obj, 2);
    Array.set(obj1, 10, 1000);
    Integer[][][] value = (Integer[][][])array;
    System.out.println("+++++++++++"+value[3][2][10]);
    
  }
  
  public static void main(String[] args) throws ClassNotFoundException{
    StringArrayTest();
    MutiDeArrayTest();
  }  
}
