package com.study.javase.effective;

import java.math.BigDecimal;
/**
 * Avoid float and double if exact answers are required
 * @author BULL
 *
 */
public class Item48_doubleAndfloat {

	public static void buyCandyWithdouble(){
		System.out.println("##############BUY DOUBLE###############");
		double funds = 1.00;
		int itemsBought = 0;
		for (double price = .10; funds >= price;) {
			funds -= price;
			itemsBought++;
		}
		System.out.println(itemsBought + " items bought.");
		System.out.println("Change: $" + funds);		
	}
	public static void buyCandyWithBigDecimal(){
		System.out.println("##############BUY BIGDECIMAL###############");
		final BigDecimal TEN_CENTS = new BigDecimal(".10");
		int itemsBought = 0;
		BigDecimal funds = new BigDecimal("1.00");
		for (BigDecimal price = TEN_CENTS; funds.compareTo(price)>=0; ) {
			funds = funds.subtract(price);
			itemsBought++;
		}
		System.out.println(itemsBought + " items bought.");
		System.out.println("Change: $" + funds);		
	}
	public static void buyCandyWithlong(){
		System.out.println("##############BUY LONG###############");
		final long TEN_CENTS = 10;
		int itemsBought = 0;
		long funds = 100;
		for (long price = TEN_CENTS; funds>=price; ) {
			funds = funds-price;
			itemsBought++;
		}
		System.out.println(itemsBought + " items bought.");
		System.out.println("Change: Cent" + funds);		
	}	
	public static void testdouble(){
        System.out.println(0.05+0.01);
        System.out.println(1.0-0.42);
        System.out.println(4.015*100);
        System.out.println(123.3/100);
        
        System.out.println("Integer.MIN_VALUE:"+Integer.MIN_VALUE);
        System.out.println("Integer.SIZE:"+Integer.SIZE);
        System.out.println("Integer.MAX_VALUE:"+Integer.MAX_VALUE);
	}
	public static void main(String[] args){
		testdouble();
		buyCandyWithdouble();
		buyCandyWithBigDecimal();
		buyCandyWithlong();
	}
}
