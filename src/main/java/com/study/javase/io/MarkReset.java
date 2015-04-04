package com.study.javase.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class MarkReset {

	public static void main(String[] args) throws IOException{
		String content = "Hello world!";
//		ByteArrayInputStream bais = new ByteArrayInputStream(content.getBytes());
		
		   FileInputStream in=new FileInputStream("D:/QQDownloads/test1.txt");
		   BufferedInputStream bais=new BufferedInputStream(in);			
		String read1 = inputStream2String(bais);
		System.out.println("####FIRST1:"+read1);
		bais.reset();
		String read2 = inputStream2String(bais);
		System.out.println("####FIRST2:"+read2);
		String read3 = inputStream2String(bais);
		
		System.out.println("####FIRST3:"+read3);	
		
		

		   
	}
	
	public static String inputStream2String(InputStream is) throws IOException{
		   BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		   StringBuffer buffer = new StringBuffer();
		   String line = "";
		   while ((line = in.readLine()) != null){
		     buffer.append(line);
		   }
		   return buffer.toString();
	}	
}
