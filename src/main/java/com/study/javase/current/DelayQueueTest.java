package com.study.javase.current;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 我们先来学习一下JDK1.5 API中关于这个类的详细介绍：
    “它是包含Delayed 元素的一个无界阻塞队列，只有在延迟期满时才能从中提取元素。该队列的头部 是延迟期满后保存时间最长的 Delayed 元素。如果延迟都还没有期满，则队列没有头部，并且 poll 将返回 null。当一个元素的 getDelay(TimeUnit.NANOSECONDS) 方法返回一个小于等于 0 的值时，将发生到期。即使无法使用 take 或 poll 移除未到期的元素，也不会将这些元素作为正常元素对待。例如，size 方法同时返回到期和未到期元素的计数。此队列不允许使用 null 元素。”
    在现实生活中，很多DelayQueue的例子。就拿上海的SB会来说明，很多国家地区的开馆时间不同。你很早就来到园区，然后急急忙忙地跑到一些心仪的馆区，发现有些还没开，你吃了闭门羹。
    仔细研究DelayQueue，你会发现它其实就是一个PriorityQueue的封装（按照delay时间排序），里面的元素都实现了Delayed接口，相关操作需要判断延时时间是否到了。
    在实际应用中，有人拿它来管理跟实际相关的缓存、session等
   下面我就通过 “上海SB会的例子来阐述DelayQueue的用法” 
 * @author BULL
 *
 */
public class DelayQueueTest {

	public static void main(String[] args) throws InterruptedException{
		DelayQueue<Stadium> queue= new DelayQueue<Stadium>();
		queue.add(new Stadium("中国",5000));
		queue.add(new Stadium("美国",1000));
		queue.add(new Stadium("韩国",3000));
		queue.add(new Stadium("日本",13000));
		
//		Thread.sleep(5000);
		while(true){
			Stadium s = queue.take();
			if(s!=null){
				System.out.println(s.getName()+"开馆了:");
			}
			if(queue.size()==0){
				break;
			}
		}
	}
}
class Stadium implements Delayed{
	private String name;
	private long trigger;
	public Stadium(String name, long i){
		this.name = name;
		this.trigger = System.currentTimeMillis()+i;
	}
	@Override
	public int compareTo(Delayed o) {
 		return (int)(this.getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS));
		
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return this.trigger-System.currentTimeMillis();
	}
	public long getTriggerTime(){
		return trigger;
	}
	public String getName(){
		return name;
	}
}
