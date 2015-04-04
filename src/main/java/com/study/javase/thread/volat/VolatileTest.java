package com.study.javase.thread.volat;

public class VolatileTest extends Thread{
	private volatile boolean flag = false;
	
	
	public void setFlag(boolean flag){
		this.flag = flag;
	}
	public String toString(){
		return "flag:" + flag;
	}
	
	public static void main(String[]args){
		VolatileTest v1 = new VolatileTest();
		System.out.println(v1.toString());
		v1.setFlag(true);
		System.out.println(v1.toString());
		VolatileTest v2 = new VolatileTest();
		System.out.println(v2.toString());
	}
}
