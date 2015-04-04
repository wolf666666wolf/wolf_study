/*
 * CronTriggerExample.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.open.quartz;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;



public class CronTriggerExample {

  public void run(){
    Logger log = Logger.getLogger(CronTriggerExample.class);
    //Scheduler sched = SchedFacory.getScheduler();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
    CronTrigger trigger = null;  
    JobDetail job = null;  
    Date ft = null;  
    
    //job = new Job()
  }
}
