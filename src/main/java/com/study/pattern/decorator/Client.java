package com.study.pattern.decorator;

public class Client {

	public static void main(String[] args){
		Component c = new ConcreteComponent();
		
		Decorator d= new MonthPrizeDecorator(c);
		Decorator d1= new SumPrizeDecorator(d);
		double zs = d1.calcPrize("张三", null, null);
		System.out.println("张三 全部工资：" + zs);
		double ls = d1.calcPrize("李四", null, null);
		System.out.println("李四 全部工资：" + ls);
		
		Decorator d2= new GroupPrizeDecorator(d1);
		double ww = d2.calcPrize("王五", null, null);
		System.out.println("王五 全部工资：" + ww);
		
		
	}
}
