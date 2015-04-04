package com.study.javase.refacting.simplizeCall;
/**
 * 你有一个函数完全取决于参数值而采取不同的行为
 * 针对该参数的可能值而采取不同的行为
 * @author BULL
 *
 */
public class Rule10_6_ReplaceParameterWithExplictMethod {

	private int _height;
	private int _width;
	public void setValue(String name, int value){
		if(name.equals("height")){
			_height = value;
		}
		if(name.equals("width")){
			_height = value;
		}		
	}
	
	//after refacting
	
	public void setHeight(int value){
		_height = value;
	}
	public void setWidth(int value){
		_height = value;
	}
}
