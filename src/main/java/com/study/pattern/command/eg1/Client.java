package com.study.pattern.command.eg1;
/**
 * 将一个请求封装为一个对象，从而可以用不同的请求对客户参数化，对请求排队并记录请求日志，并且可以撤销请求
 * 
 * @author BULL
 *
 */
public class Client {

	public static void main(String[] args){
		Barbecuer boy = new Barbecuer();

		Waiter waiter = new Waiter();
		waiter.addCommand(new MuttonCommand(boy));
		waiter.addCommand(new MuttonCommand(boy));
		waiter.addCommand(new ChickenWingCommand(boy));
		waiter.commit();
	}
}
