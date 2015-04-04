package com.study.javase.thread.muti;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class TestCompletionService {

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		ExecutorService exec = Executors.newFixedThreadPool(10);
		CompletionService<String> serv = new ExecutorCompletionService<String>(exec);
		for(int i=0; i<5; i++){
			Callable<String> runner = new Callable<String>(){
				public String call() throws Exception{
					Thread.sleep((long)(Math.random() * 10000));
					return "Thread" + Thread.currentThread().getName() + "is finished";
				}
			};
			serv.submit(runner);
		}
		Thread.sleep(1000 * 2);
		System.out.println("开始等待子线程结束");
		for(int i=0; i<5; i++){
			Future<String> task = serv.take();
			String obj = task.get();
			System.out.println(new Date() + " " + obj);
		}
		
		System.out.println("子线程全部结束");
		exec.shutdown();
	}	
}
