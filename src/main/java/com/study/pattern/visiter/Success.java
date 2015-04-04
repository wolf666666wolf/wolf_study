package com.study.pattern.visiter;

public class Success implements Visitor{

	@Override
	public void getManConsulation() {
		System.out.println("男人成功时，背后多有一个伟大的女人");
		
	}

	@Override
	public void getWomanConsulation() {
		System.out.println("女人成功时，背后多有不成功的男人");
		
	}

}
