package com.study.pattern.interpret.eg1;

public class QianExpression extends Expression{

	@Override
	public String getPostFix() {
		return "千";
	}

	@Override
	public int getMulitiplier() {
		return 1000;
	}

}
