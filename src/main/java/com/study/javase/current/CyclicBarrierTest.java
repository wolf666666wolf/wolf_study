package com.study.javase.current;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 假设有只有的一个场景：每个线程代表一个跑步运动员，当运动员都准备好后，才一起出发，只要有一个人没有准备好，大家都等待.
 * @author BULL
 *
 */
public class CyclicBarrierTest {

	
	public static void main(String[] args){
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);

		Thread t1 = new Thread(new Runner(cyclicBarrier, "zhangsan"));
		Thread t2 = new Thread(new Runner(cyclicBarrier, "lisi"));
		Thread t3 = new Thread(new Runner(cyclicBarrier, "wangwu"));	
		executor.submit(t1);
		executor.submit(t2);
		executor.submit(t3);
		 
		executor.shutdown();
	}

}

class Runner implements Runnable{
	private String name;
	private CyclicBarrier cyclicBarrier;
	
	public Runner(CyclicBarrier cyclicBarrier, String name){
		this.cyclicBarrier=cyclicBarrier;
		this.name = name;
	}
	@Override
	public void run() {
		
		try {
			Thread.sleep(5000 * (new Random()).nextInt(8));
			System.out.println(name + " 准备OK."); 
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}  
		System.out.println(name + " GO!."); 
	}
	
}