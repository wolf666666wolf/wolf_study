/*
 * SimpleDateFormatTest.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleDateFormatTest {
  
  
  public static void main(String[] args){    
    testDateFormat();
   
  }
  
  /**
   G 年代标志符
   y 年
   M 月
   d 日
   h 时 在上午或下午 (1~12)
   H 时 在一天中 (0~23)
   m 分
   s 秒
   S 毫秒
   E 星期
   D 一年中的第几天
   F 一月中第几个星期几
   w 一年中第几个星期
   W 一月中第几个星期
   a 上午 / 下午 标记符
   k 时 在一天中 (1~24)
   K 时 在上午或下午 (0~11)
   z 时区
   * @description 
   * @author Bull
   */
  public static void testDateFormat(){
    SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒"); //2012年08月07日 15时08分44秒
    SimpleDateFormat myFmt1=new SimpleDateFormat("yy/MM/dd HH:mm"); // 12/08/07 15:08
    SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//等价于now.toLocaleString() 2012-08-07 15:08:44
    SimpleDateFormat myFmt22=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");//
    SimpleDateFormat myFmt3=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E "); //2012年08月07日 15时08分44秒 Tue
    SimpleDateFormat myFmt4=new SimpleDateFormat("一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区"); //一年中的第 220 天 一年中第32个星期 一月中第2个星期 在一天中15时 CST时区
    
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY, 15);
    System.out.println(myFmt.format(cal.getTime()));
    System.out.println(myFmt1.format(cal.getTime())); 
    System.out.println(myFmt2.format(cal.getTime()));
    System.out.println(myFmt2.format(cal.getTime()));
    System.out.println(myFmt22.format(cal.getTime())); 
    System.out.println(myFmt3.format(cal.getTime())); 
    System.out.println(myFmt4.format(cal.getTime())); 
  }
  
  public static void testOracleDateFormat(){
  /**
    TO_DATE格式(以时间:2007-11-02   13:45:25为例)
  
        Year:     
        yy two digits 两位年                显示值:07
        yyy three digits 三位年                显示值:007
        yyyy four digits 四位年                显示值:2007
           
        Month:     
        mm    number     两位月              显示值:11
        mon    abbreviated 字符集表示          显示值:11月,若是英文版,显示nov    
        month spelled out 字符集表示          显示值:11月,若是英文版,显示november
         
        Day:     
        dd    number         当月第几天        显示值:02
        ddd    number         当年第几天        显示值:02
        dy    abbreviated 当周第几天简写    显示值:星期五,若是英文版,显示fri
        day    spelled out   当周第几天全写    显示值:星期五,若是英文版,显示friday       
        ddspth spelled out, ordinal twelfth
            
        Hour:
        hh    two digits 12小时进制            显示值:01
        hh24 two digits 24小时进制            显示值:13
       
        Minute:
        mi    two digits 60进制                显示值:45
       
        Second:
        ss    two digits 60进制                显示值:25
             
              其它
        Q     digit         季度                  显示值:4
        WW    digit         当年第几周            显示值:44
        W    digit          当月第几周            显示值:1
             
        24小时格式下时间范围为： 0:00:00 - 23:59:59....     
        12小时格式下时间范围为： 1:00:00 - 12:59:59 ....
           
      1. 日期和字符转换函数用法（to_date,to_char）
              
      select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') as nowTime from dual;   //日期转化为字符串  
      select to_char(sysdate,'yyyy') as nowYear   from dual;   //获取时间的年  
      select to_char(sysdate,'mm')    as nowMonth from dual;   //获取时间的月  
      select to_char(sysdate,'dd')    as nowDay    from dual;   //获取时间的日  
      select to_char(sysdate,'hh24') as nowHour   from dual;   //获取时间的时  
      select to_char(sysdate,'mi')    as nowMinute from dual;   //获取时间的分  
      select to_char(sysdate,'ss')    as nowSecond from dual;   //获取时间的秒
      
      select to_date('2004-05-07 13:23:44','yyyy-mm-dd hh24:mi:ss')    from dual//     
   */
  }
}
