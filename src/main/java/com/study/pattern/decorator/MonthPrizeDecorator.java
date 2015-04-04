package com.study.pattern.decorator;

import java.util.Date;

public class MonthPrizeDecorator extends Decorator{

	public MonthPrizeDecorator(Component component) {
		super(component);
	}
	@Override
	public double calcPrize(String user, Date begin, Date end) {  
		
        double money = component.calcPrize(user, begin, end);
        double price = TempDB.mapMonthSaleMoney.get(user) * 0.3;
        System.out.println(user+" 业务奖金："+price);
        return money + price;
    }   
}
