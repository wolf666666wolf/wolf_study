package com.study.javase.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

public class CommunicationByPipeBytes {
	static PipedOutputStream pos = null;
	static PipedInputStream pis = null;
	private static void testCommunication() throws IOException{
		pos = new PipedOutputStream();
		pis = new PipedInputStream(pos);
		Thread thread1 = new Thread(){
			public void run(){
				try {
					pos.write("Hello world!".getBytes());
					pos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		thread1.start();
	
		Thread thread2 = new Thread(){
			public void run(){
				try {
					byte[] bytes = new byte[pis.available()];
					pis.read(bytes, 0, bytes.length);
					System.out.println("read String:" + new String(bytes));
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
		};
		thread2.start();
	}
	
	static PipedWriter pw = null;
	static PipedReader pr = null;
	static BufferedWriter bw = null;
	static BufferedReader br = null;
	public static void testCommuncationByCharacter() throws IOException{
		PipedWriter pw = new PipedWriter();
		PipedReader pr = new PipedReader(pw);
		final BufferedWriter bw = new BufferedWriter(pw);
		final BufferedReader br = new BufferedReader(pr);
		Thread thread1 = new Thread(){
			public void run(){
				String str = "Hello world!!";
				try {
					bw.write(str, 0, str.length());
					bw.newLine();
					bw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};
		thread1.start();
		
		Thread thread2 = new Thread(){
			public void run(){
				try {
					System.out.println("read String:"+br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		thread2.start();
	}
	public static void main(String[] args){
		try {
			testCommunication();
			testCommuncationByCharacter();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
