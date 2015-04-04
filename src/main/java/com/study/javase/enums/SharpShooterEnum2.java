package com.study.javase.enums;
/**
 * enum with constructor function
 * @author Administrator
 *
 */
public enum SharpShooterEnum2 {
	LOCKED("锁定目标"),
	AIM("瞄准目标"),
	SHOOT("射击");
	private String desc;
	private SharpShooterEnum2(String desc){
		this.desc = desc;
	}
	public String getDesc(){
		return desc;
	}
}
