package com.study.javase.thread;

public class TestOnExit {
	public TestOnExit(){
		doShutDownWork();
	}
	private void doShutDownWork(){
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				System.out.println("Exit was invock");
			}
		});
	}
	
	public static void main(String[] args) throws InterruptedException{
		TestOnExit testor = new TestOnExit();
		long beginTime = System.currentTimeMillis();
		for(int i=0; i<10; i++){
			System.out.println("sleep "+i+" second");
			Thread.sleep(1000);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Used "+(endTime-beginTime)/1000 +" sendonds to finished");		
	}
}
