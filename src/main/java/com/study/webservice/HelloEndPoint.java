package com.study.webservice;

import javax.xml.ws.Endpoint;

public class HelloEndPoint {

	public static void main(String[] args){
		String address="http://localhost:8888/wolf_study/hellows";
		Endpoint.publish(address, new HelloWSImpl());
		System.out.println("发布成功");
	}
}
