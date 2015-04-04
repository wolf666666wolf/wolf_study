/*
 * Person.java
 * Copyright 2002-2013 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.test;

public class Person {

  private int id;
  private String name;
  private Job job;

  public Person() {
      this(1, "noname", new Job("nojob"));
  }

  public Person(int id, String name, Job job) {
      this.id = id;
      this.name = name;
      this.job = job;
  }

  public String getJobName() {
      return job.getName();
  }

  public int getJobId() {
      return Job.generateId();
  }

  public String getJobNamePrefixId() {
      return getJobId() + getJobName();
  }

  public String toString() {
      return "#" + id + ": " + name;
  }
}
