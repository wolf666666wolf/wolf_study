package com.study.pattern.bridge;

public class Client {

	public static void main(String[] args){
		MessageImplementor message = new MessageSMS();
		MessageImplementor msgEmail = new MessageEmail();
		AbstractMessage common = new CommonMessage(message);
		AbstractMessage urgency = new UrgencyMessage(message);
		common.sendMessage("Hello World", "ZhangSan");
		urgency.sendMessage("Hello World", "ZhangSan");
		
		AbstractMessage urgencyEmail = new UrgencyMessage(msgEmail);
		urgencyEmail.sendMessage("Hello World", "ZhangSan");
	}
}
