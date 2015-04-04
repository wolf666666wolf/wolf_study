package com.study.javase.thread.pattern.guarededSuspension;

public class Request {

	private String name;
	public Request(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public String toString(){
		return "[Request " + name + "]";
	}
}
