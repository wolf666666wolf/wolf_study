package com.study.javase.thread.muti;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestSemaphore {
	public static void main(String[] args){
		ExecutorService exec = Executors.newCachedThreadPool();
		//只允许3个线程同时运行
		final Semaphore semp = new Semaphore(3);
		for(int i=0; i<10; i++){
			Runnable run = new Runnable(){
				public void run(){
					try{
						semp.acquire();
						System.out.println(new Date() + " 当前运行的线程是:" + Thread.currentThread().getName());
						Thread.sleep((long)(Math.random() * 10000));
						semp.release();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			};
			exec.submit(run);
		}
		exec.shutdown();
	}
}
