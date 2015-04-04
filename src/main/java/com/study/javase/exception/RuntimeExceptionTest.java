package com.study.javase.exception;

public class RuntimeExceptionTest {

	public static void main(String[] args){
		try{
			throw new RuntimeException("hello world");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("aaaaaaaaaaaaa");
		
	}
}
