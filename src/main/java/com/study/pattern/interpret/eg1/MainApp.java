package com.study.pattern.interpret.eg1;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

	public static void main(String[] args){
		//String roman = "一亿二千三百五十七万六千四百五十二"; //==>123576452
		String roman = "七万六千四百五十二"; //==>123576452
		Context context=new Context(roman);
		List<Expression> tree = new ArrayList<Expression>();
		
		tree.add(new GeExpression());
		tree.add(new ShiExpression());
		tree.add(new BaiExpression());
		tree.add(new QianExpression());
		tree.add(new WanExpression());
		for(Expression exp: tree){
			exp.interpret(context);
		}
		System.out.println(roman+" ==> "+context.getData());
	}
}
