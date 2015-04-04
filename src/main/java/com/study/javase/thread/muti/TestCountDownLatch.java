package com.study.javase.thread.muti;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch {
	public static void main(String[] args) throws InterruptedException{
		//计数值为1的同步辅助对象
		final CountDownLatch begin = new CountDownLatch(1);
		//计数值为10的同步辅助对象
		final CountDownLatch end = new CountDownLatch(10);
		final ExecutorService exec = Executors.newFixedThreadPool(10);
		for(int i=0; i<10; i++){
			Runnable run = new Runnable(){
				public void run(){
					try{
						begin.await();
						System.out.println(new Date() + " " + Thread.currentThread().getName() + "开始运行");
						Thread.sleep((long)(Math.random() * 10000));
						System.out.println(new Date() + " " + Thread.currentThread().getName() + "运行完毕");
					}catch(InterruptedException ie){
						
					}finally{
						end.countDown();
					}
				}
			};
			exec.submit(run);
		}
		begin.countDown();
		end.await();
		System.out.println(new Date() + " " + Thread.currentThread().getName() + "运行完毕");
		exec.shutdown();
	}
}
