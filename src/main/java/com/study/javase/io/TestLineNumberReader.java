package com.study.javase.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class TestLineNumberReader {

	public static void readLines(LineNumberReader lnr) throws IOException{
		String line = null;
		int count = 0;
		while((line = lnr.readLine()) != null){
			System.out.println(lnr.getLineNumber() +"\t"+ line);
			if(lnr.getLineNumber() == 5){
				lnr.mark(1024);
			}
		}
	}
	public static void testReader(){
		try {
			LineNumberReader lnr = new LineNumberReader(new FileReader("E:/workspace/wolf-study/src/main/java/com/study/javase/io/TestLineNumberReader.java"));
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>lnr");
			readLines(lnr);
			lnr.reset();
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>after reset");
			readLines(lnr);
			
			lnr.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public static void testWriter(){
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("F:/1.txt")));
			pw.println("Hello world");
			pw.println("How are you");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		testWriter();
		testReader();
	}
}

