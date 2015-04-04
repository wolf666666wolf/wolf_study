package com.study.pattern.visiter;

public class Love implements Visitor{

	@Override
	public void getManConsulation() {
		System.out.println("男人恋爱时，凡事不懂也要装懂");
		
	}

	@Override
	public void getWomanConsulation() {
		System.out.println("女人恋爱时，遇到事情懂也装不懂");
		
	}

}
