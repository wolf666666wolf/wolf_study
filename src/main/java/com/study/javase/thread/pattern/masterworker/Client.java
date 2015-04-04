package com.study.javase.thread.pattern.masterworker;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.time.DurationFormatUtils;

/**
 * Master-worker模式是一种将串行任务并行化的方法，被分解的子任务在系统中
 * 可以被并行处理。同时 如果有需要，Master进程不需要等待所有的子任务都完成计算，
 * 就可以根据已有的部分结果集计算最终结果
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args){
		Date d1 = new Date();
		calcateWithPattern();
		Date d2 = new Date();
		long duration = d2.getTime() - d1.getTime();
		System.out.println("#############duartion:"+DurationFormatUtils.formatDuration(duration, "dd HH mm ss"));
		
		Date d11 = new Date();
		calcute();
		Date d22 = new Date();
		long duration2 = d22.getTime() - d11.getTime();
		System.out.println("$$$$$$$$$$$$$duartion:"+DurationFormatUtils.formatDuration(duration2, "dd HH mm ss"));
		
				
	}
	
	public static void calcateWithPattern(){
		Master m = new Master(new PlusWorker(), 5);
		for(int i=0; i<100; i++){
			m.submit(i);
		}
		m.execute();

		int re=0;
		Map<String, Object> resultMap = m.getResultMap();
		while(resultMap.size()>0 || !m.isComplete()){
			Set<String> keys = resultMap.keySet();
			String key = null;
			for(String k: keys){
				key = k;
				break;
			}
			Integer i = null;
			if(key!=null){
				i=(Integer)resultMap.get(key);				
			}
			if(i!=null){
				re+=i;
			}
			if(key!=null){
				resultMap.remove(key);
			}
		}
		System.out.println("result:"+re);
	}
	public static void calcute(){
		int re = 0;
		for(int i=0; i<100; i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			re+=i*i*i;
		}
		System.out.println("result2:"+re);
	}
}
