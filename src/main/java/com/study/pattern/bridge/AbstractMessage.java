package com.study.pattern.bridge;

public abstract class AbstractMessage {

	protected MessageImplementor impl;
	public AbstractMessage(MessageImplementor impl){
		this.impl = impl;
	}
	
	public void sendMessage(String message, String toUser){
		impl.send(message, toUser);
	}
}
