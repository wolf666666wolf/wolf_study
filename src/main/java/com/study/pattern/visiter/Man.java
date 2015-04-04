package com.study.pattern.visiter;

public class Man implements Person{

	@Override
	public void accept(Visitor visitor) {
		visitor.getManConsulation();
	}

}
