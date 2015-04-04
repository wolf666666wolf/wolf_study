package com.study.pattern.bridge;

public class MessageEmail implements MessageImplementor{

	public void send(String message, String toUser) {
		System.out.println("使用电子邮件的方式，发送消息'"+message+"'给"+toUser); 
	}

	
}
