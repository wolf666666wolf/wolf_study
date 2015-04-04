package com.study.pattern.interpret.eg1;

public class WanExpression extends Expression{

	@Override
	public String getPostFix() {
		return "万";
	}

	@Override
	public int getMulitiplier() {
		return 10000;
	}

}
