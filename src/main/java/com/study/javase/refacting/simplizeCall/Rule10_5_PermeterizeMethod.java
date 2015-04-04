package com.study.javase.refacting.simplizeCall;

/**
 * 若干函数做了类似的工作，但在函数本体却包含了不同的值
 * 建立单一函数，以参数表达不同的值
 * @author BULL
 *
 */
public class Rule10_5_PermeterizeMethod {
	private double salary;
	public void tenPercentRaise(){
		salary = salary * 1.10; 
	}
	public void fivePercentRaise(){
		salary = salary * 1.05;
	}
	
	
	//after refacting
	public void raise(double factor){
		salary = salary * (1 + factor);
	}
	
}
