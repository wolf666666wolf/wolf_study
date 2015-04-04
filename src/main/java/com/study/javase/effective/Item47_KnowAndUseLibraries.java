package com.study.javase.effective;

import java.util.Random;

/**
 * By using a standard library,
you take advantage of the knowledge of the experts who wrote it and the
experience of those who used it before you.
 * @author BULL
 *
 */
public class Item47_KnowAndUseLibraries {
	
	public static void badMethod(){
		Random rnd = new Random();
		int n=20;
		for(int i=1;i<10;i++){
			int result  = Math.abs(rnd.nextInt()) % 5;
			System.out.println("badMethod result:"+result);
		}
		
		
	}
	public static void goodMethod(){
		Random rnd = new Random();
		int n=20;
		for(int i=1;i<10;i++){
			System.out.println("goodMethod result:"+rnd.nextInt(5));
		}		
	}
	public static void main(String[] args){
		goodMethod();
		badMethod();
	}
}
