package com.study.javase.thread.muti;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class TestThreadPool {
	public static void main(String[] args){
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int index=0; index<10; index++){
			System.out.println("index:"+index);
			Runnable run = new Runnable(){
				public void run(){
					long time = (long)(Math.random() * 10000);
					System.out.println("休眠 " + time +" 秒");
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			exec.execute(run);
		}
		exec.shutdown();
	}
}
