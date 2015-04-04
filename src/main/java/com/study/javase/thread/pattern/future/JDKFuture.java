package com.study.javase.thread.pattern.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class JDKFuture {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		FutureTask<String> future = new FutureTask<String>(new RealData1("Hello World \n"));
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(future);
		System.out.println("request finished!");
		
		Thread.sleep(2000);
		System.out.println("Data="+future.get());
	}
	
}

class RealData1 implements Callable<String>{
	private String para;
	public RealData1(String para){
		this.para = para;
	}
	@Override
	public String call() throws Exception {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<10; i++){
			sb.append(para);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}