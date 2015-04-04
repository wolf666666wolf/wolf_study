package com.study.javase.enums;
/**
 * enum with constructor function
 * @author Administrator
 *
 */
public enum SharpShooterEnum3 implements Perform{
	LOCKED("锁定目标"){
	  public void getDesc(){
	    System.out.println(LOCKED.name());
	  }
	},
	AIM("瞄准目标"){
      public void getDesc(){
        System.out.println(AIM.name());
      }	  
	},
	SHOOT("射击"){
      public void getDesc(){
        System.out.println(SHOOT.name());
      }	  
	};
	private String desc;
	private SharpShooterEnum3(String desc){
		this.desc = desc;
	}
	public abstract void getDesc();
	
	public static void main(String[] args){
	  SharpShooterEnum3.SHOOT.getDesc();
	}
}

interface Perform{
  public void getDesc();
}