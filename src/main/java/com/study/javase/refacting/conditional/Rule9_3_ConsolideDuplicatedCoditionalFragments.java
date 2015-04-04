package com.study.javase.refacting.conditional;
/**
 * 在条件表达式内存在相同的代码，吧相同代码挪到条件表达式之外
 * @author BULL
 *
 */
public class Rule9_3_ConsolideDuplicatedCoditionalFragments {
	private double price;
	private double total;
	public void badMethod(){
		if(total>20){
			price = price * 0.98;
			send();
		}else{
			price = price * 0.99;
			send();
		}
	}
	
	public void goodMethod(){
		if(total>20){
			price = price * 0.98;
		}else{
			price = price * 0.99;
		}
		send();		
	}
	private void send(){
		
	}
}
