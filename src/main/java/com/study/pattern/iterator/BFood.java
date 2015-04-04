package com.study.pattern.iterator;

public class BFood {

	private String name;
	private double price;
	private boolean isVaggltable;
	public BFood(String name, double price, boolean isVaggltable) {
		super();
		this.name = name;
		this.price = price;
		this.isVaggltable = isVaggltable;
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
	public boolean isVaggltable() {
		return isVaggltable;
	}
	public void setVaggltable(boolean isVaggltable) {
		this.isVaggltable = isVaggltable;
	}
	@Override
	public String toString() {
		return "BFood [name=" + name + ", price=" + price + ", isVaggltable="
				+ isVaggltable + "]";
	}
	
	
}
