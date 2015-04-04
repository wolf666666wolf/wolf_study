package com.study.javase.current;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPoolExecutor
    我们先来学习一下JDK1.5 API中关于这个类的详细介绍：

    "可另行安排在给定的延迟后运行命令，或者定期执行命令。需要多个辅助线程时，或者要求 ThreadPoolExecutor 具有额外的灵活性或功能时，此类要优于 Timer。
    一旦启用已延迟的任务就执行它，但是有关何时启用，启用后何时执行则没有任何实时保证。按照提交的先进先出 (FIFO) 顺序来启用那些被安排在同一执行时间的任务。

    虽然此类继承自 ThreadPoolExecutor，但是几个继承的调整方法对此类并无作用。特别是，因为它作为一个使用 corePoolSize 线程和一个无界队列的固定大小的池，所以调整 maximumPoolSize 没有什么效果。"

    在JDK1.5之前，我们关于定时/周期操作都是通过Timer来实现的。但是Timer有以下几种危险[JCIP]

a. Timer是基于绝对时间的。容易受系统时钟的影响。
b. Timer只新建了一个线程来执行所有的TimeTask。所有TimeTask可能会相关影响
c. Timer不会捕获TimerTask的异常，只是简单地停止。这样势必会影响其他TimeTask的执行。

    如果你是使用JDK1.5以上版本，建议用ScheduledThreadPoolExecutor代替Timer。它基本上解决了上述问题。它采用相对时间，用线程池来执行TimerTask，会出来TimerTask异常。

    下面通过一个简单的实例来阐述ScheduledThreadPoolExecutor的使用。
  
    我们定期让定时器抛异常
    我们定期从控制台打印系统时间 
 * @author BULL
 *
 */
public class ScheduledThreadPoolExecutorTest {

	public static void main(String[] args){
		ScheduledThreadPoolExecutor exec=new ScheduledThreadPoolExecutor(1);
		//每隔一段时间就触发异常
		exec.scheduleAtFixedRate(new ExceptionRunnable(), 1000, 5000, TimeUnit.MILLISECONDS);
		//每隔一段时间打印系统时间，证明两者是互不影响的
		exec.scheduleAtFixedRate(new PrintRunnable(), 1000, 2000, TimeUnit.MILLISECONDS);
	}
}
class ExceptionRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("exception occured start");
		throw new RuntimeException();
		
	}
}
class PrintRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("System.nanoTime():"+System.nanoTime());
	}
	
}