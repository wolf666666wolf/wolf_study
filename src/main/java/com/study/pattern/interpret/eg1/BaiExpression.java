package com.study.pattern.interpret.eg1;

public class BaiExpression extends Expression{

	@Override
	public String getPostFix() {
		return "百";
	}

	@Override
	public int getMulitiplier() {
		return 100;
	}

}
