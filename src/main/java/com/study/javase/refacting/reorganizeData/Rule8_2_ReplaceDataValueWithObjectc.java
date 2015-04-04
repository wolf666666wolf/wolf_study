package com.study.javase.refacting.reorganizeData;

public class Rule8_2_ReplaceDataValueWithObjectc {
	
}

class Customer{
	private final String _name;
	public Customer(String name){
		this._name = name;
	}
	private String getName(){
		return this._name;
	}
}