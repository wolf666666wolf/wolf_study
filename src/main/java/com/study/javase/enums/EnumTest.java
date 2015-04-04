package com.study.javase.enums;

public class EnumTest {

	public static void main(String[] args){
		testAction();
		testAction1();
		testAction2();
	}
	public static void testAction2(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test action2");
		for(SharpShooterEnum2 sse: SharpShooterEnum2.values()){
			System.out.println(sse +":"+ sse.getDesc());
		}
	}	
	public static void testAction1(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test action1");
		for(SharpShooterEnum1 sse: SharpShooterEnum1.values()){
			System.out.println(sse +":"+ sse.getDesc());
		}
	}
	public static void testAction(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test action");
		doAction(SharpShooterEnum.LOCKED);
		doAction(SharpShooterEnum.AIM);
		doAction(SharpShooterEnum.SHOOT);		
	}
	private static void doAction(SharpShooterEnum action){
		switch(action){
		case LOCKED:
			System.out.println("1: 锁定目标");
			break;
		case AIM:
			System.out.println("2: 瞄准目标");
			break;
		case SHOOT:
			System.out.println("3: 射击");
			break;
		default:
			System.out.println("X: 还无此动作");
		}
	}
}
