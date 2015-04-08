package com.study.webservice;

import java.util.List;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWebService;
import cn.com.webxml.WeatherWebServiceSoap;

public class WeatherClient {

	public static void main(String[] args){
		
		WeatherWebService service = new WeatherWebService();
		WeatherWebServiceSoap soap=service.getWeatherWebServiceSoap();
		ArrayOfString weather = soap.getWeatherbyCityName("北京");
		List<String> list= weather.getString();
		
		for(String str: list){
			System.out.println("###########:"+str);
		}
		System.out.println("###########"+list);
	}
}
