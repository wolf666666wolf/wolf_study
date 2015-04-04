package com.study.javase.thread.pattern.guarededSuspension;

public class ServerThread extends Thread{
	private RequestQueue requestQueue;
	public ServerThread(RequestQueue requestQueue, String name){
		super(name);
		this.requestQueue = requestQueue;
	}
	
	public void run(){
		while(true){
			final Request request = requestQueue.getRequest();
			try {
				Thread.sleep(100); //模拟请求耗时
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " handles " + request);
		}
	}
	
}
