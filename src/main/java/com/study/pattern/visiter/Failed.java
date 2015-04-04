package com.study.pattern.visiter;

public class Failed implements Visitor{

	@Override
	public void getManConsulation() {
		System.out.println("男人失败时，喝闷酒，谁也不用劝");
		
	}

	@Override
	public void getWomanConsulation() {
		System.out.println("女人失败时，眼泪汪汪，谁也劝不动");
	}

}
