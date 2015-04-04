package com.study.javase.thread;

public class ThreadDaemon {

	public static void main(String[] args){
		//testDaemonFalse();
		testDaemonTrue();
	}
	
	public static void testDaemonFalse(){
		Thread parent = new Thread(){
			public void run(){
				System.out.println("Parent starts");
				Thread child = new Thread(){
					public void run(){
						System.out.println("Child starts");
						while(true){
							System.out.println("Child runs");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								
								e.printStackTrace();
							}
						}
					}
				};
				child.setDaemon(false);
				child.start();
				System.out.println("Parent ends");
			}
		};
		parent.start();	

	}
	public static void testDaemonTrue(){
		Thread parent = new Thread(){
			public void run(){
				System.out.println("Parent starts");
				Thread child = new Thread(){
					public void run(){
						System.out.println("Child starts");
						while(true){
							System.out.println("Child runs");
							try {
								Thread.currentThread().sleep(1000);
							} catch (InterruptedException e) {
								
								e.printStackTrace();
							}
						}
					}
				};
				child.setDaemon(true);
				child.start();
				System.out.println("Parent ends");
			}
		};
		parent.start();		
	}
}
