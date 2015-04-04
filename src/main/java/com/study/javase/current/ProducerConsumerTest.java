package com.study.javase.current;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumerTest {

	public static void main(String[] args){
		ProductPool pool = new ProductPool();
		new Thread(new Producer1(pool)).start();
		new Thread(new Consumer1(pool)).start();
	}
}

class ProductPool{
	private LinkedList<Integer> pool = new LinkedList<Integer>();
	private static int POOL_SIZE = 5;
	public synchronized void put(Integer product){
		if(pool.size()==POOL_SIZE){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		pool.addLast(product);
		System.out.println("produce:"+product);
		notifyAll();
	}
	public synchronized Integer pop(){
		while(pool.size()<=0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Integer value = pool.removeFirst();
		System.out.println("consume:"+value);
		this.notifyAll();
		
		return value;
	}
}
class Producer1 implements Runnable{
	private ProductPool pool;
	public Producer1(ProductPool pool){
		this.pool = pool;
	}
	@Override
	public void run() {
		Random random = new Random();
		
		while(true){
			int product = random.nextInt(100);
			pool.put(product);
			
		}	
	}	
}
class Consumer1 implements Runnable{
	private ProductPool pool;
	public Consumer1(ProductPool pool){
		this.pool = pool;
	}
	@Override
	public void run() {
		while(true){
			pool.pop();
			try {
				Thread.sleep((int)Math.random() * 3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
}