package com.study.javase.thread;
/**
 * single instance, muti thread
 * @author Administrator
 *
 */
public class RunnableTest implements Runnable{
	private int count = 0;
	public void run() {
		while(count <  100){
			System.out.println("[count:" + count++ +"] [threadid:"+Thread.currentThread().getId()+"]");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args){
		RunnableTest rt = new  RunnableTest();
		Thread t1 = new Thread(rt);
		Thread t2 = new Thread(rt);
		
		t1.start();
		t2.start();
	}


	
}
