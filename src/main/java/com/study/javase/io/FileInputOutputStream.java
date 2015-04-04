package com.study.javase.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileInputOutputStream {

	public static byte[] readFile(File file)throws Exception{
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>readFile");
		FileInputStream fis = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buff = new byte[1024];
		try{
			fis = new FileInputStream(file);
			int bytesRead = 0;
			while(-1 != (bytesRead=fis.read(buff, 0, buff.length))){
				baos.write(buff, 0, bytesRead);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			fis.close();
			//baos.close();
			buff = null;
		}
		return baos.toByteArray();
	}
	
	public static byte[] readFileEffect(File file)throws Exception{
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>readFileEffect");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buff= new byte[1024];
		try{
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			int bytesRead = 0;
			while(-1 != (bytesRead = bis.read(buff, 0, buff.length))){
				baos.write(buff, 0, bytesRead);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			fis.close();
			bis.close();
			buff = null;
		}
		return baos.toByteArray();
	}
	public static void copyFile(File file)throws Exception{
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>copyFile");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		byte[] buff = new byte[1024];
		
		try{
			fis = new FileInputStream(file);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>copyFile:"+file.getName() + ".bak");
			fos = new FileOutputStream(file.getName() + ".bak");	
			int bytesRead = 0;
			while(-1 != (bytesRead = fis.read(buff, 0, buff.length))){
				fos.write(buff, 0, bytesRead);
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			fis.close();
			buff = null;
			fos.close();
		}
	}
	public static void copyFileEffect(File file)throws Exception{
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>copyFileEffect");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		byte[] buff = new byte[1024];
		
		try{
			fis = new FileInputStream(file);
			fos = new FileOutputStream(file.getName() + ".bak");	
			bos = new BufferedOutputStream(fos);
			int bytesRead = 0;
			while(-1 != (bytesRead = fis.read(buff, 0, buff.length))){
				bos.write(buff, 0, bytesRead);
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			fis.close();
			buff = null;
			bos.close();
			fos.close();
		}
	}	
	
	public static void main(String[] args){
		String fileName = "E:/workspace/wolf-study/src/main/java/com/study/javase/io/FileInputOutputStream.java";
		File file = new File(fileName);
		byte[] bytes = null;
		
		try {
			bytes = readFile(file);
			System.out.println(new String(bytes));
			
			bytes = readFileEffect(file);
			System.out.println(new String(bytes));	
			
			copyFile(file);
			
			copyFileEffect(file);
					
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
