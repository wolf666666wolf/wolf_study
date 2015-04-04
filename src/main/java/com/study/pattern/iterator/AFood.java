package com.study.pattern.iterator;

public class AFood {

	private String name;
	private double price;
	
	public AFood(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "AFood [name=" + name + ", price=" + price + "]";
	}
	
}
