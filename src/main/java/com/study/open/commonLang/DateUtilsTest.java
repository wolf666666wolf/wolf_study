package com.study.open.commonLang;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.apache.commons.lang.time.StopWatch;

public class DateUtilsTest {
	public static void main(String[] args){

		testDateUtils();
		testStopWatch();
		testDurationFormatUtils();
		//DateUtils.
	}
	
		public static void testDateUtils(){
			int amount =2;
			Date date = new Date();
			System.out.println(date);
			System.out.printf("%tF %<tT\n", date);
			System.out.printf("%tF %<tT\n", DateUtils.addDays(date, amount));
			System.out.printf("%tF %<tT\n", DateUtils.addHours(date, amount));
			System.out.printf("%tF %<tT\n", DateUtils.addMinutes(date, amount));
			System.out.printf("%tF %<tT\n", DateUtils.addMonths(date, amount));
			System.out.printf("%tF %<tT\n", DateUtils.addWeeks(date, amount));
			System.out.printf("%tF %<tT\n", DateUtils.addYears(date, amount));
			
			System.out.println("only complare the year month date:" + DateUtils.isSameDay(date, new Date()));
			System.out.println("exactly the same time:"+DateUtils.isSameInstant(date, new Date()));
			
			String[] parsePatterns = {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss"};
			date = null;
			try{
				date = DateUtils.parseDate("2011-5-10 19:09:15", parsePatterns);
				System.out.printf("%tF %<tT", date);
				System.out.println();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}			
		}
		
		public static void testStopWatch(){
			System.out.println(StringUtils.center("testStopWatch", 30, "="));
			StopWatch sw = new StopWatch();
			sw.start();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
			sw.stop();
			
			System.out.println("system used: " + sw.getTime() + " milliseconds");
			System.out.println();
		}
		
		public static void testDurationFormatUtils(){
			Date d1 = null;
			Date d2 = null;
			try {
				d1 = DateUtils.parseDate("2010-04-10 09:30:15", new String[] { "yyyy-MM-dd HH:mm:ss" });
				d2 = DateUtils.parseDate("2011-05-11 10:30:25", new String[] { "yyyy-MM-dd HH:mm:ss" });
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			long duration = d2.getTime() - d1.getTime();

			System.out.println("day:"+DurationFormatUtils.formatPeriod(d1.getTime(), d2.getTime(), "d"));
			System.out.println("month:"+DurationFormatUtils.formatPeriod(d1.getTime(), d2.getTime(), "M"));
			System.out.println("year:"+DurationFormatUtils.formatPeriod(d1.getTime(), d2.getTime(), "y"));
			
			System.out.println("duartion:"+DurationFormatUtils.formatDuration(duration, "dd HH mm ss"));

			
		}
		
		
}
