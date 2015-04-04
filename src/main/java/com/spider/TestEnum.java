package com.spider;

import java.util.List;

import com.study.javase.enu.Color;

public class TestEnum {

	public static void main(String[] args){
//		List<String> list = null;
//		for(String str: list){
//			System.out.println("aaaaaaaa");
//		}
		String abc = "AUD09_07_RetVerifyForm|AUD09_07_TaxCalculatedForEachHeir";
		String[] froms = abc.split("\\|");
		System.out.println("Len:"+froms.length);
		for(String a: froms){
			System.out.println(a);
		}
	}
}

interface Hello{
	void say(String name);
}
class HelloA implements Hello{
	@Override
	public void say(String name) {
		System.out.println("hello"+name);
		
	}
	
	public static void say(Color c){
		
	}
	
	
}