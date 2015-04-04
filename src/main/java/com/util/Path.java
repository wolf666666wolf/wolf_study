package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Path {
	public static void main(String[] args){
		
		InputStream resourceAsStream1 = com.util.Path.class.getResourceAsStream("abc.txt");
		InputStream resourceAsStream2 = Path.class.getResourceAsStream("/com/util/abc.txt");
		InputStream resourceAsStream3 = ClassLoader.getSystemResourceAsStream("com/util/abc.txt");	
		
		System.out.println("String1:" + convertToString(resourceAsStream1));
		System.out.println("String2:" + convertToString(resourceAsStream2));
		System.out.println("String3:" + convertToString(resourceAsStream3));
		System.out.println("String4:" + Path.class.getResource("")+ "abc.txt");
		
		testPath();
	}

	public static void testPath(){
		System.out.println("Path.class.getClassLoader().getResource(''):"+Path.class.getClassLoader().getResource(""));  
		System.out.println("ClassLoader.getSystemResource(''):"+ClassLoader.getSystemResource(""));  
		System.out.println("Path.class.getResource(''):"+Path.class.getResource("abc.txt"));  
		System.out.println("Path.class.getResource('/'):"+Path.class.getResource("/")); //Class文件所在路径  
		System.out.println("Path.class.getResource('/').getPath():"+Path.class.getResource("/").getPath()); //Class文件所在路径
		System.out.println("new File('/').getAbsolutePath():"+new File("/").getAbsolutePath());  
		System.out.println("System.getProperty('user.dir'):"+System.getProperty("user.dir")); 		
		System.out.println("System.getProperty('file.separator'):"+System.getProperty("file.separator"));
		System.out.println("System.getProperty('file.separator'):"+System.getProperty("file.separator"));
		System.out.println("System.getProperty('file.separator'):"+System.getProperty("file.separator"));
//		file.separator 文件分隔符（在 UNIX 系统中是“/”）
//		path.separator 路径分隔符（在 UNIX 系统中是“:”）
//		line.separator 行分隔符（在 UNIX 系统中是“/n”）
		
		
		System.out.println("path:"+new File(".").getPath());
		System.out.println("absoutepath:"+new File(".").getAbsolutePath());
	}
	public static String convertToString(InputStream is){
		if(is == null) return null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));   
		StringBuilder sb = new StringBuilder();   

		String line = null;   
		try {   
			while ((line = reader.readLine()) != null) {   
				sb.append(line + "\n");   
			}   
		} catch (IOException e) {   
			e.printStackTrace();   
		} finally {   
			try {   
				is.close();   
			} catch (IOException e) {   
				e.printStackTrace();   
			} 
			try {   
				reader.close();   
			} catch (IOException e) {   
				e.printStackTrace();   
			}			
		}   

			return sb.toString();   
	}  
	
}
