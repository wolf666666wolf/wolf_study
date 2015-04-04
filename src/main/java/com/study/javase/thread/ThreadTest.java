package com.study.javase.thread;

public class ThreadTest extends Thread{
	int count = 0;
	public void run(){
		while(count < 100){
			System.out.println("[count:" + count++ +"] [threadid:"+Thread.currentThread().getId()+"]");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
	
	public static void main(String[] args){
		ThreadTest tt1 = new ThreadTest();
		ThreadTest tt2 = new ThreadTest();
		
		tt1.start();
		tt2.start();
		System.out.println("##########main thread");
	}
}
