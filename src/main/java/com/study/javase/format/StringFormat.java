/*
 * StringFormat.java
 * Copyright 2002-2012 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.javase.format;

import java.util.Date;
import java.util.Locale;

public class StringFormat {
  public static void main(String[] args){
    //testString();
    testDate();
    //testTime();
    java.sql.Date d = new java.sql.Date(new java.util.Date().getTime());
    
    String s = String.format(Locale.TRADITIONAL_CHINESE,"%tc", d);
    String s1 = String.format("%tY%tm%td", d,d,d);

    System.out.println(s1);
  }
  public static void testNumber(){
    String str = String.format("%04d", 23);
    System.out.println(str); //0023
    
    System.out.println(String.format("%1$,09d", -3123));
    System.out.println(String.format("%,09d", -3123)); //-0003,123
    
    System.out.println(String.format("%1$09d", -31)); //-00000031
    System.out.println(String.format("%1$-9d", -31));
    System.out.println(String.format("%1$(9d", -31));
    System.out.println(String.format("%1$#9x", 5689));     
  }
  
  public static void testString(){ // string and renturn
    System.out.println(String.format("hello world %9s age:%d %n province:%s", "lisi", 24, "shangdong"));
    String str=null;

    str=String.format("Hi,%s", "飞龙");          // 格式化字符串

    System.out.println(str);                             // 输出字符串变量str的内容

    System.out.printf("字母a的大写是：%c %n", 'A');

    System.out.printf("3>7的结果是：%b %n", 3>7);

    System.out.printf("100的一半是：%d %n", 100/2);

    System.out.printf("100的16进制数是：%x %n", 100);

    System.out.printf("100的8进制数是：%o %n", 100);

    System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);

    System.out.printf("上面价格的16进制数是：%a %n", 50*0.85);

    System.out.printf("上面价格的指数表示：%e %n", 50*0.85);

    System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50*0.85);

    System.out.printf("上面的折扣是%d%% %n", 85);

    System.out.printf("字母A的散列码是：%h %n", 'A');    
  }
  public static void testDate(){
    Date date=new Date();                                                                    // 创建日期对象

    System.out.printf("yyyymmdd:"+String.format("%tY%tm%td%n", date,date,date)); //YYYYmmdd
    System.out.printf("yyyy-mm-dd:"+String.format("%tY-%tm-%td%n", date,date,date));//YYYY-mm-dd
    System.out.printf("yyyy-mm-dd HH:MM:SS:"+String.format("%tY-%tm-%td %tT%n", date,date,date,date));//YYYY-mm-dd
    
    System.out.printf("全部日期和时间信息：%tc%n",date);                // 格式化输出日期或时间

    System.out.printf("年-月-日格式：%tF%n",date);

    System.out.printf("月/日/年格式：%tD%n",date);

    System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);

    System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);

    System.out.printf("HH:MM格式（24时制）：%tR",date);  
                                                                               // 创建日期对象

    String str=String.format(Locale.US,"英文月份简称：%tb",date);      // 格式化日期字符串

    System.out.println(str);                                                                              // 输出字符串内容

    System.out.printf("本地月份简称：%tb%n",date);

    str=String.format(Locale.US,"英文月份全称：%tB",date);

    System.out.println(str);

    System.out.printf("本地月份全称：%tB%n",date);

    str=String.format(Locale.US,"英文星期的简称：%ta",date);

    System.out.println(str);

    System.out.printf("本地星期的简称：%tA%n",date);

    System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n",date);

    System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n",date);

    System.out.printf("一年中的天数（即年的第几天）：%tj%n",date);

    System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n",date);

    System.out.printf("两位数字的日（不足两位前面补0）：%td%n",date);

    System.out.printf("月份的日（前面不补0）：%te",date);    
  }
  
  public static void testTime(){
    Date date=new Date();                               // 创建日期对象

    System.out.printf("2位数字24时制的小时（不足2位前面补0）:%tH%n",date);

    System.out.printf("2位数字12时制的小时（不足2位前面补0）:%tI%n",date);

    System.out.printf("2位数字24时制的小时（前面不补0）:%tk%n",date);

    System.out.printf("2位数字12时制的小时（前面不补0）:%tl%n",date);

    System.out.printf("2位数字的分钟（不足2位前面补0）:%tM%n",date);

    System.out.printf("2位数字的秒（不足2位前面补0）:%tS%n",date);

    System.out.printf("3位数字的毫秒（不足3位前面补0）:%tL%n",date);

    System.out.printf("9位数字的毫秒数（不足9位前面补0）:%tN%n",date);

    String str=String.format(Locale.US,"小写字母的上午或下午标记(英)：%tp",date);

    System.out.println(str);                          // 输出字符串变量str的内容

    System.out.printf ("小写字母的上午或下午标记（中）：%tp%n",date);

    System.out.printf("相对于GMT的RFC822时区的偏移量:%tz%n",date);

    System.out.printf("时区缩写字符串:%tZ%n",date);

    System.out.printf("1970-1-1 00:00:00 到现在所经过的秒数：%ts%n",date);

    System.out.printf("1970-1-1 00:00:00 到现在所经过的毫秒数：%tQ%n",date); 
    
    
  }
}
