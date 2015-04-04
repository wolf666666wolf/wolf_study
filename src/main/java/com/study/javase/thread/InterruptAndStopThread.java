package com.study.javase.thread;

public class InterruptAndStopThread {
	public static void main(String[] args) throws InterruptedException{
			testInterruptSleeping();
			Thread.sleep(1000);
			System.out.println("#################################test stop");
			testStop();
			System.out.println("#################################test join");
			testJoin();
	}
	
	public static void testInterruptSleeping(){
		WaitingThread wt = new WaitingThread();
		wt.start();
			try {
				wt.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		synchronized(wt){
			wt.interrupt();
		}		
	}
	public static void testStop(){
		WaitingThread2 wt = new WaitingThread2();
		wt.start();

			try {
				wt.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		synchronized(wt){
			wt.interrupt();
		}		
	}	
	public static void testJoin(){
		WaitingThread2 wt = new WaitingThread2();
		wt.start();
		long beginTime = System.currentTimeMillis();
		try {
			wt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Wait "+(endTime-beginTime)/1000 +" sendonds finished");
	}
}

class WaitingThread extends Thread{
	public void run(){
		System.out.println("Thread start to sleep 5 minites");
		try {
			Thread.sleep(5*60*1000);
		} catch (InterruptedException e) {
			//e.printStackTrace();
			System.out.println("Thread stop sleep");
		}
		System.out.println("Thread sleep end");
	}
}
class WaitingThread2 extends Thread{
	public void run(){
		for(int i=0; i<10; i++){
			System.out.println("<"+i+">Thread is running......");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				//e.printStackTrace();
				System.out.println("Thread end");
				break;
			}
		}
	}
}