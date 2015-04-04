/*
 * ReflectionUtil.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.reflaction;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

public class ReflectionUtil {
  /**
   * search all method: include private, protected, friendly, public from current class and super classes
   */
  public static Method getSupportedMethod(Class cls, String name, Class[] paramTypes)throws NoSuchMethodException{
      if(cls == null){
        throw new NoSuchMethodException();
      }
      try {
        return cls.getDeclaredMethod(name, paramTypes);
      } catch (NoSuchMethodException e) {
        return getSupportedMethod(cls.getSuperclass(), name, paramTypes);
      }
  }
  /**
   * this is just a test example
   * @description 
   * @author Bull
   * @param obj
   * @param color
   */
  public static void setObjectColor(Object obj, String color){
    Class cls = obj.getClass();

      Method method;
      try {
        method = getSupportedMethod(cls, "setColor", new Class[]{String.class});
        method.invoke(obj, color);
      } catch (NoSuchMethodException e) {
        throw new IllegalArgumentException(cls.getName()+ " does not support method setColor(String)");
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException(cls.getName()+ " does not support method setColor(String)");
      } catch (IllegalAccessException e) {
        throw new IllegalArgumentException("Insufficient assess permissions to call setColor(String) in class " + cls.getName());
      } catch (InvocationTargetException e) {
        throw new RuntimeException(e);
      }

  }
  /**
   * search all field which is no abstract
   * @description 
   * @author Bull
   * @param cls
   * @return
   */
  public static Field[] getInstanceVariables(Class cls){
    List<Field> accum = new LinkedList<Field>();
    while(cls != null){
      Field[] fields = cls.getDeclaredFields();
      for(int i=0; i<fields.length; i++){
        if(!Modifier.isAbstract(fields[i].getModifiers())){
          accum.add(fields[i]);
        }
      }
      cls = cls.getSuperclass();
    }
    return accum.toArray(new Field[accum.size()]);
  }
}
