package com.study.javase.thread.muti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class ThreadManager {
	TheThread[] runner = null;
	int count;
	boolean busy;
	public static void main(String[] args){
		try {
			new ThreadManager(5).listen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ThreadManager(int count){
		this.count = count;
	}
	private void listen() throws IOException{
		runner = new TheThread[this.count];
		for(int i=0; i<count; i++){
			runner[i] = new TheThread(i);
			runner[i].start();
		}
		
		ServerSocket serverSocket = new ServerSocket(1024);
		Socket socket = serverSocket.accept();
		while(true){
			try{
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String cmd = in.readLine();
				if(cmd == null){
					break;
				}
				if(cmd.startsWith("stop")){
					for(int i=0; i<this.count; i++){
						synchronized(runner[i]){
							Thread.sleep(500);
							runner[i].interrupted();
						}
					}
					System.out.println("线程池已被销毁，程序退出！");
					break;
				}else{
					synchronized(this){
						busy = true;
						for(int i=0; i<count; i++){
							if(runner[i].str == null){
								runner[i].str = cmd;
								busy = false;
								break;
							}
						}
						if(busy){
							System.out.println("服务器正忙，没有线程处理：" + cmd);
						}
					}
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
class TheThread extends Thread{
	int no ;
	public String str = null;
	public TheThread(int i){
		this.no = i;
	}
	public void run(){
		try{
			while(true){
				Thread.sleep(1000);
				if(this.str != null){
					synchronized(this){
						System.out.println("第" + this.no + "线程指令：" + this.str);
						this.str=null;
					}
				}
			}
		}catch(InterruptedException e){
			System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date())+"]" + "线程"+this.no + "被");
		}
	}
}
