package com.study.javase.thread.muti;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestBlockingQueueWithThread {
	
	public static void main(String[] args){
		final BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
		//队列末尾标志
		final Integer endInt = new Integer(0);
		
		//写队列的线程
		Runnable setter = new Runnable(){
			public void run(){
				try{
					for(int i=1; i<10; i++){
						queue.put(new Integer(i));
						System.out.println(Thread.currentThread().getName() + ":先队列写入数字 "+i);
					}
					queue.put(new Integer(0));
				}catch(InterruptedException ie){
					ie.printStackTrace();
				}
			}
		};
		new Thread(setter).start();
		
		//两个读队列的线程
		for(int i=0; i<2; i++){
			Runnable getter = new Runnable(){
				public void run(){
					while(true){
						try{
							Thread.sleep(500);
							Integer num = queue.take();
							//队列已经无对象
							if( num.intValue() == 0){
								//再次添加队列末尾,以让其他线程结束
								queue.put(new Integer(0));
								break;
							}
							System.out.println(Thread.currentThread().getName() + ":向队列读出数字 " + num.intValue());
						}catch(InterruptedException ie){}
					}
				}
			};
			new Thread(getter).start();
		}
	}
	
}
