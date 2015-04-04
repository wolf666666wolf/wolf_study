/*
 * Job.java
 * Copyright 2002-2013 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.test;

import java.util.Random;

public class Job {

  public Job(String name) {
      this.name = name;
  }

  private String name;

  public String getName() {
      return name;
  }

  public static int generateId() {
      return new Random().nextInt(1000);
  }

}
