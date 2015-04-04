package com.study.javase.thread.muti;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TestScheduleThread {

	public static void main(String[] args){
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
		final Runnable beeper = new Runnable(){
				int count = 0;
				public void run(){
					System.out.println("[" + new Date() + "] count=" + (++count));
				}
		};
		//1 秒钟后运行，并且每隔2秒运行一次
		final ScheduledFuture<?> beeperHandler = scheduler.scheduleAtFixedRate(beeper, 1, 2, TimeUnit.SECONDS) ;
		//2秒钟后运行，并每次在上次任务运行完成后等待5秒后重新运行
		final ScheduledFuture<?> beeperHandler2 = scheduler.scheduleWithFixedDelay(beeper, 2, 5, TimeUnit.SECONDS);
		//30秒后结束关闭任务，并且关闭Scheduler
		scheduler.schedule(new Runnable(){
			public void run(){
				beeperHandler.cancel(true);
				beeperHandler2.cancel(true);
				scheduler.shutdown();
			}
		}, 30, TimeUnit.SECONDS);
	}
}
