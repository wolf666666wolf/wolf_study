package com.study.pattern.interpret.eg1;
//字符串上下文信息：保存没有处理的字符串信息
public class Context {

	private String statement;
	private int data;
	
	public Context(String statement){
		this.statement = statement;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}
