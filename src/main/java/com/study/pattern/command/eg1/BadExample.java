package com.study.pattern.command.eg1;

public class BadExample {

	public static void main(String[] args){
		Barbecuer1 bar = new Barbecuer1();
		bar.bakeMutton();
		bar.bakeMutton();
		bar.bakeMutton();
		bar.bakeMutton();
		bar.bakeChickenWing();
		bar.bakeChickenWing();
		bar.bakeMutton();
		bar.bakeChickenWing();
		bar.bakeChickenWing();
	}
}

class Barbecuer1{
	public void bakeMutton(){
		System.out.println("烤羊肉串");
	}
	public void bakeChickenWing(){
		System.out.println("烤鸡翅");
	}
}
