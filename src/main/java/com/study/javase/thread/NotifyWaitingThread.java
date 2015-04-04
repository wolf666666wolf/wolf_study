package com.study.javase.thread;

public class NotifyWaitingThread {

	public static void main(String[] args){
		try {
			test1();
			Thread.sleep(1000);
			System.out.println("###########################");
			test2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	public static void test1() throws InterruptedException{
		MyThread[] threads = new MyThread[3];
		for(int i=0;i<3; i++){
			threads[i] = new MyThread();
			threads[i].no=i;
			threads[i].setDaemon(true);
			threads[i].start();
		}
		Thread.sleep(500);
		for(int i=0; i<3; i++){
			synchronized(threads[i]){
				threads[i].notify();
			}
		}
	}
	public static void test2() throws InterruptedException{
		SameRunner sr = new SameRunner();
		Thread[] threads = new Thread[3];
		for(int i=0;i<3; i++){
			threads[i] = new Thread(sr);
			threads[i].setDaemon(true);
			threads[i].start();
		}
		Thread.sleep(500);
		
			synchronized(sr){
				sr.notifyAll();
			}
		
	}		
}
class MyThread extends Thread{
	public int no =0;
	public void run(){
		System.out.println("Thread[ "+this.no+" ]will wait for 5 minites");
		
			try {
				synchronized(this){
					this.wait(5*60*1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Thread[ "+this.no+" ] is notified.");
	}
}
class SameRunner implements Runnable{

	public void run() {
		System.out.println("Thread ["+Thread.currentThread().getId()+" ]will wait 5 minites");
			
				try {
					synchronized(this){
						this.wait(5*60*1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		System.out.println("Thread ["+Thread.currentThread().getId()+"] is notified");	
	}
	
}