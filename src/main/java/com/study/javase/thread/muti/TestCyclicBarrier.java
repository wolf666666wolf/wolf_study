package com.study.javase.thread.muti;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCyclicBarrier {
	public static void main(String[] args){
		//创建需要同步3个线程的同步辅助对象
		CyclicBarrier barrier = new CyclicBarrier(3);
		//创建容量为3的固定线程池，wait
		ExecutorService exec = Executors.newFixedThreadPool(3);
		exec.submit(new Runner(barrier, 0, new int[]{4, 8, 12}));
		exec.submit(new Runner(barrier, 1, new int[]{1, 2, 3}));
		exec.submit(new Runner(barrier, 2, new int[]{2, 4, 6}));
		//销毁线程池
		exec.shutdown();
	}
}

class Runner implements Runnable{
	private int no=0;
	private int[] times = null;//到达每个集合点需要的时间
	private CyclicBarrier barrier = null;//同步辅助对象
	public Runner(CyclicBarrier barrier, int no, int[] times){
		this.no = no;
		this.times = times;
		this.barrier = barrier;
	}
	public void run(){
		try{
			Thread.sleep(times[0] * 1000);
			System.out.println(new Date() + " Thread_" + no + "Arrive at point 1");
			barrier.await();
			Thread.sleep(times[1] * 1000);
			System.out.println(new Date() + " Thread_" + no + "Arrive at point 2");
			barrier.await();
			Thread.sleep(times[2] * 1000);
			System.out.println(new Date() + " Thread_" + no + "Arrive at point 3");
			barrier.await();
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}catch(BrokenBarrierException bbe){
			bbe.printStackTrace();
		}
	}
}
