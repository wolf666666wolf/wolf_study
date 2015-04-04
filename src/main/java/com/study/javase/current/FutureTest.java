package com.study.javase.current;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 有时候在实际应用中，某些操作很耗时，但又不是不可或缺的步骤。比如用网页浏览器浏览新闻时，最重要的是显示文字内容，至于与新闻相匹配的图片就没有那么重要的，所以此时首先保证文字信息先显示，而图片信息会后显示，但又不能不显示，由于下载图片是一个耗时的操作，所以必须一开始就得下载。


Java的并发库的Future类就可以满足这个要求。Future的重要方法包括get()和cancel()，get()获取数据对象，如果数据没有加载，就会阻塞直到取到数据，而 cancel()是取消数据加载。另外一个get(timeout)操作，表示如果在timeout时间内没有取到就失败返回，而不再阻塞。 
 * @author BULL
 *
 */
public class FutureTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		ExecutorService exec = Executors.newCachedThreadPool();
		Callable call = new Callable(){

			@Override
			public Object call() throws Exception {
				System.out.println("less important but long time things start");
				Thread.sleep(5*1000);
				return "less important but long time things end";
			}
		};
		
		Future task = exec.submit(call);
		
		
		System.out.println("Let's do important things start");
		Thread.sleep(3*1000); //重要的事情 
		System.out.println("Let's do important things end");
		
		Object result = task.get(); //其他不重要的事情  
		System.out.println(result);
		
		exec.shutdown();
	}
}
