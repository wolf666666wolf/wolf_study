/*
 * EnumSetTest.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.enums;

import java.util.EnumSet;

public class EnumSetTest {

  public enum ColorFeature{
    RED, BLUE, GREEN, YELLOW, BLACK
  };
  public static void main(String[] args){
    EnumSet allFeatures = EnumSet.allOf(ColorFeature.class);
    EnumSet warmColorFeatures = EnumSet.of(ColorFeature.RED, ColorFeature.YELLOW);
    EnumSet no_warmColorFeatures = EnumSet.complementOf(warmColorFeatures);
    EnumSet notBlack = EnumSet.range(ColorFeature.RED, ColorFeature.YELLOW);
    
    for(ColorFeature of: ColorFeature.values()){
      if(warmColorFeatures.contains(of)){
        System.out.println("WarmColor:" + of.name());
      }
      if(no_warmColorFeatures.contains(of)){
        System.out.println("NON_WarmColor:" + of.name());
      }
    }
  }
}
