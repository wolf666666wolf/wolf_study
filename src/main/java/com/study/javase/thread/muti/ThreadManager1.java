package com.study.javase.thread.muti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadManager1 {
	TheThread1[] runner = null;
	int count;
	public static void main(String[] args){
		
	}
	
	public ThreadManager1(int count){
		this.count = count;
	}
	private void listen() throws IOException{
		runner = new TheThread1[count];
		for(int i=0; i<this.count; i++){
			runner[i] = new TheThread1(i);
			runner[i].start();
		}
		
		//侦听1024端口
		ServerSocket serverSocket = new ServerSocket(1024);
		while(true){
			final Socket socket = serverSocket.accept();
			Thread worker = new Thread(){
				public void run(){
				System.out.println("");
				}
			};
		}
	}
}

class TheThread1 extends Thread{
	int no;
	int comand = 0;
	int status ; //0 空闲, 1 busy
	
	public TheThread1(int i){
		this.no=i;
	}
	public void run(){
		try{
		this.status = 1;
		while(true){
			Thread.sleep(1000);
			if(this.comand ==1){
				synchronized(this){
					System.out.println("["+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "线程" + this.no + "开始等待....");
					this.status = 0;
					this.wait();
				}
			}
		}
		}catch(InterruptedException e){
			System.out.println("["+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "线程" + this.no + "被终止....");
		}
	}
}