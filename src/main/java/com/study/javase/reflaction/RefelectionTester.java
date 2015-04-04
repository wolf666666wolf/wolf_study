/*
 * RefelectionTester.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.reflaction;

import java.lang.reflect.Field;
import java.lang.reflect.Method;



public class RefelectionTester {

  public Object copy(Object obj)throws Exception{
    Class<?> classType = obj.getClass();
    System.out.println("class:"+classType.getName());
    
    //Object objectCopy = classType.getConstructor(new Class[]{}).newInstance(new Object[]{});
    Object objectCopy = classType.newInstance(); 
    Field[] fields = classType.getDeclaredFields();
    for(int i=0; i<fields.length; i++){
      Field field = fields[i];
      String fieldName = field.getName();
      
      String getMethodName = "get"+firstLetterUpperCase(fieldName);
      String setMethodName = "set"+firstLetterUpperCase(fieldName);
      
      Method getMethod = classType.getMethod(getMethodName, new Class[]{});
      Method setMethod = classType.getMethod(setMethodName, new Class[]{field.getType()});
      
      Object value = getMethod.invoke(obj, new Object[]{});
      setMethod.invoke(objectCopy, new Object[]{value});
    }
    
    return objectCopy;
  }

  
  public static void main(String[] args) throws Exception{
    Customer c = new Customer();
    c.setId(100000L);
    c.setName("ZhangSan");
    c.setAge(32);
    RefelectionTester rt = new RefelectionTester();
    Customer newCustomer =(Customer)rt.copy(c);
    
    System.out.println("newOBJ:"+newCustomer.toString());
  }
  
  
  private String firstLetterUpperCase(String str){
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }
}

class Customer{
  private Long id;
  private String name;
  private int age;
  
  public Customer(){}
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  
  public String toString(){
    return new StringBuilder().append("{")
    .append("[").append("Id:").append(id).append("]")
    .append("[").append("Name:").append(name).append("]")
    .append("[").append("age:").append(age).append("]")
    .append("}").toString();
  }
}