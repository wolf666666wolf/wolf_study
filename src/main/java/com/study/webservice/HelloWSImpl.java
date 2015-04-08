package com.study.webservice;

import javax.jws.WebService;

@WebService
public class HelloWSImpl implements HelloWS{

	@Override
	public String sayHello(String name) {
		System.out.println("###########");
		return "Hello "+name;
	}

}
