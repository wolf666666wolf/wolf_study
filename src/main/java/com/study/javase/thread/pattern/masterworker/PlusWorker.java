package com.study.javase.thread.pattern.masterworker;

public class PlusWorker extends Worker{

	public Object handle(Object input){
		Integer i = (Integer)input;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i*i*i;
	}
}
