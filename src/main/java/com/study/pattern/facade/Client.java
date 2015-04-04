package com.study.pattern.facade;

public class Client {
	private static SecurityFacade securityFacade;
	
	public static void main(String[] args){
		securityFacade.activete();
	}
}
