package com.study.javase.enums;

public enum SharpShooterEnum1 {
	LOCKED,
	AIM,
	SHOOT;
	
	public String getDesc(){
		switch(this.ordinal()){
		case 0:
			return "锁定目标";
		case 1:
			return "瞄准目标";
		case 2:
			return "射击";
		default:
			return "没有该枚举值！";		
		}
		
	}
}
