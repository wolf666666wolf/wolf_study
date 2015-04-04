package com.study.javase.thread.muti;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		final ExecutorService exec = Executors.newFixedThreadPool(3);
		Callable<String> call = new Callable(){
			public String call() throws Exception{
				Thread.sleep(1000 * 6);
				return "Thread is finished.";
			}
		};
		
		Future<String> task = exec.submit(call);
		System.out.println("before start");
		String obj = task.get();
		System.out.println("子线程返回的结果：" + obj);
		exec.shutdown();
	}
}
