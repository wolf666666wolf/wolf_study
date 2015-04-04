package com.study.javase.effective;

import java.util.Arrays;
import java.util.List;

public class Item42_varargs {

	// The WRONG way to use varargs to pass one or more arguments!
	static int min(int... args){
		if(args.length == 0){
			throw new IllegalArgumentException("args length is 0");
		}
		int min = args[0];
		for(int i =1; i< args.length; i++){
			if(args[i] < min){
				min = args[i];
			}
		}
		return min;
	}
	// The right way to use varargs to pass one or more arguments
	static int min1(int firstArg, int... remainArgs){
		int min = firstArg;
		for(int i=0; i<remainArgs.length; i++){
			if(remainArgs[i] < min){
				min = remainArgs[i];
			}
		}
		return min;
	}
	
	static void example(){
		List<String> list = Arrays.asList("ZhangSan","LiSi","WangWu");
		System.out.println("###########"+Arrays.toString(list.toArray()));
	}
	
	public static void main(String[] args){
		example();
	}
}
