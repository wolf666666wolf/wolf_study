/*
 * Reminder.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.timer;

import java.util.Timer;
import java.util.TimerTask;

public class Reminder {
  Timer timer;
  public Reminder(int seconds){
    timer=new Timer();
    timer.schedule(new ReminderTask(), seconds*1000, 2*1000);  //execute every 2 seconds
  }
  public static void main(String[] args){
    System.out.println("start schedule");
    new Reminder(5);
    System.out.println("end schedule");
  }
}

class ReminderTask extends TimerTask{
  @Override
  public void run() {  
    System.out.println("Hello world");
  }
}