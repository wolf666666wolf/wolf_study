package com.study.pattern.interpret.eg1;

public class ShiExpression extends Expression{

	@Override
	public String getPostFix() {
		return "十";
	}

	@Override
	public int getMulitiplier() {
		return 10;
	}

}
