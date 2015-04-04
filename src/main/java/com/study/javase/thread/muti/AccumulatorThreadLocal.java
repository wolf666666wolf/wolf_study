package com.study.javase.thread.muti;


public class AccumulatorThreadLocal implements Runnable{
	public static void main(String[] args) throws InterruptedException{
		//testunsafe();
		//Thread.currentThread().join();
		//testsafe1();
		//testsafe2();
		testThreadLocal();
		
	}
	public static void testunsafe(){
		Runnable accumulator = new Accumulator();
		Thread threada = new Thread(accumulator, "ThreadA");
		Thread threadb = new Thread(accumulator, "ThreadB");
		threada.start();
		threadb.start();
	}
	public static void testsafe1(){
		Runnable accumulator = new Accumulator1();
		Thread threada = new Thread(accumulator, "ThreadSA");
		Thread threadb = new Thread(accumulator, "ThreadSB");
		threada.start();
		threadb.start();
	}	
	public static void testsafe2(){
		Runnable accumulatora = new Accumulator();
		Runnable accumulatorb = new Accumulator();
		Thread threada = new Thread(accumulatora, "ThreadSA");
		Thread threadb = new Thread(accumulatorb, "ThreadSB");
		threada.start();
		threadb.start();
	}
	public static void testThreadLocal(){
		Runnable accumulator = new AccumulatorThreadLocal();
		Thread threada = new Thread(accumulator, "ThreadA");
		Thread threadb = new Thread(accumulator, "ThreadB");
		threada.start();
		threadb.start();		
	}
	
	ThreadLocal threadLocal = new ThreadLocal();
	public void run() {
		for(int i=1; i<=10; i++){
			if(threadLocal.get()==null){
				threadLocal.set(new Integer(0));
			}
			int x = ((Integer)threadLocal.get()).intValue();
			x = x +1;
			threadLocal.set(new Integer(x));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " 和=" + ((Integer)threadLocal.get()).intValue());
		}
		
	}

}
class Accumulator implements Runnable{
	int sum = 0;
	public void run() {
		for(int i=1; i<=10; i++){
			sum = sum + i;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " sum=" + sum);
		}
		
	}
}
class Accumulator1 implements Runnable{
	
	public void run() {
		int sum = 0;
		for(int i=1; i<=10; i++){
			sum = sum + i;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " sum=" + sum);
		}
		
	}
}