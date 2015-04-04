package com.study.javase.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class NIOExample {

	public static void copyFile(String resource, String destination) throws IOException{
		FileInputStream fis = new FileInputStream(resource);
		FileOutputStream fos = new FileOutputStream(destination);
		FileChannel readChannel = fis.getChannel();
		FileChannel writeChannel = fos.getChannel();
		int bufferSize = 1024;
		ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
		
		while(true){
			buffer.clear();
			int len = readChannel.read(buffer);
			if(len == -1){
				break;
			}
			
			buffer.flip();
			writeChannel.write(buffer);
		}
//		System.out.println("#############:"+sb.toString());
		readChannel.close();
		writeChannel.close();
		
	}
	public static void readFile(String resource) throws IOException{
		FileInputStream fis = new FileInputStream(resource);
//		FileOutputStream fos = new FileOutputStream(destination);
		FileChannel readChannel = fis.getChannel();
//		FileChannel writeChannel = fos.getChannel();
		int bufferSize = 500;
		ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
		StringBuffer sb = new StringBuffer();
		while(true){
			buffer.clear();
			int len = readChannel.read(buffer);
			if(len == -1){
				break;
			}
			
			buffer.flip();
//			sb.append(new String(buffer.array()));
			System.out.println("#############:"+new String(buffer.array()));
			
//			writeChannel.write(buffer);
		}
		
		readChannel.close();
//		writeChannel.close();
		
	}	
	
	public static void main(String[] args){
		String resource = "E:/workspace/wolf-study/src/main/java/com/study/javase/nio/NIOExample.java";
		String dest = "E:/NIOExample.java";
		try {
			copyFile(resource, dest);
			readFile(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
