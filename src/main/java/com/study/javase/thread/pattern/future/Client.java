package com.study.javase.thread.pattern.future;

public class Client {
	public Data request(final String queryStr){
		final FutureData future = new FutureData();
		new Thread(){
			public void run(){
				RealData realdata = new RealData(queryStr);
				future.setRealData(realdata);
			}
		}.start();
		return future;
	}
	
	public static void main(String[] args){
		Client client = new Client();
		Data data = client.request("hello world");
		System.out.println("request finished");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("data:"+data.getResult());
	}
}
