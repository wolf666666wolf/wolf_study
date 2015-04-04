/*
 * SchedEventLister.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.open.quartz;

import org.apache.log4j.Logger;
import org.quartz.Scheduler;



public class SchedEventLister implements Runnable{
  private static Logger log = Logger.getLogger(SchedEventLister.class);
  private Scheduler sched = null;
 // private TriggerKey triggerKey = null;
  @Override
  public void run() {
    
  }

  
}
