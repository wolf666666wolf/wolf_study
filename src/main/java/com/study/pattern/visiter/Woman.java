package com.study.pattern.visiter;

public class Woman implements Person{

	@Override
	public void accept(Visitor visitor)  {
		visitor.getWomanConsulation();		
	}

}
