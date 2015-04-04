package com.study.javase.thread.pattern.producer;

public final class PCData {
	private final int intData;
	public PCData(int intData){
		this.intData = intData;
	}
	public int getData(){
		return this.intData;
	}
	@Override
	public String toString(){
		return "data:"+this.intData;
	}
}
