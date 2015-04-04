package com.study.javase.thread.muti;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFuture1 {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		final ExecutorService exec = Executors.newFixedThreadPool(10);
		List result = new ArrayList();
		Date start = new Date();
		for(int i=0; i<10; i++){
			Callable<String> call = new MyTask(""+i);
			
			Future<String> task = exec.submit(call);
			result.add(task);
			System.out.println("start sub thread");
//			System.out.println("before start");
//			String obj = task.get();
//			System.out.println("子线程返回的结果：" + obj);
		}
		for(int i=0; i<result.size(); i++){
			String obj = ((Future<String>)result.get(i)).get();
			System.out.println("子线程返回的结果：" + obj);			
		}
		exec.shutdown();
		Date end = new Date();
		System.out.println("time is ：" + (end.getTime()-start.getTime())/1000+ " seconds");
	}
}
class MyTask implements Callable{
	private String engineXml;
	public MyTask(String engineXml){
		this.engineXml = engineXml;
	}
	@Override
	public String call() throws Exception {
		Thread.sleep(1000 * 6);
		return this.getEngineXml() + " Thread is finished.";
	}
	public String getEngineXml() {
		return engineXml;
	}
	public void setEngineXml(String engineXml) {
		this.engineXml = engineXml;
	}

	
} 