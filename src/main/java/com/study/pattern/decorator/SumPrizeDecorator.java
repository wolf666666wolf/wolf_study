package com.study.pattern.decorator;

import java.util.Date;

public class SumPrizeDecorator extends Decorator{

	public SumPrizeDecorator(Component component) {
		super(component);
	}
    
	@Override
	public double calcPrize(String user, Date begin, Date end){
		double d = super.calcPrize(user, begin, end);
		double p = 100000 * 0.3;
		System.out.println(user+" 累计奖金："+ p);
		return d+p;
	}
}
