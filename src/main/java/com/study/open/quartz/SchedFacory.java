/*
 * SchedFacory.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.open.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class SchedFacory {

  private static SchedulerFactory sf = new StdSchedulerFactory();
  public Scheduler getScheduler(){
    try {
      return sf.getScheduler();
    } catch (SchedulerException e) {
      e.printStackTrace();
    }
    return null;
  }
}
