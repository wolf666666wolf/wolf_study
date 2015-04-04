package com.study.javase.current;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;



public class BlockingQueueTest {

	public static void main(String[] args){
		final BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(3);
		Thread producer = new Thread(new Producer(blockingQueue));
		Thread consumer = new Thread(new Consumer(blockingQueue));
		
		producer.start();
		consumer.start();
	}
}
class Producer implements Runnable{
	private BlockingQueue<Integer> blockingQueue;
	public Producer(BlockingQueue<Integer> blockingQueue){
		this.blockingQueue = blockingQueue;
	}
	@Override
	public void run() {
		Random random = new Random();
		while(true){
			int i = random.nextInt(100);
			try {
				blockingQueue.put(i);
				System.out.println("produce:"+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(blockingQueue.size()==3){
				System.out.println("###########:queue is full");
			}
		}
		
	}
	
}
class Consumer implements Runnable{
	private BlockingQueue<Integer> blockingQueue;
	public Consumer(BlockingQueue<Integer> blockingQueue){
		this.blockingQueue = blockingQueue;
	}
	@Override
	public void run() {
		
		while(true){
			try {
				Integer i=blockingQueue.take();
				System.out.println("consume:"+i);
				Thread.sleep(3*1000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			
		}
		
	}
}