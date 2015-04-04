package com.study.javase.map;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static Map<String, String> TestMap1(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("A", "ZhangSan_1");
		map.put("A", "ZhangSan_2");
		return map;
	}
	public static Map<String, String> TestMap2(){
		Map<String, String> map = new HashMap<String, String>();
		map.put(new String("A"), "ZhangSan_1");
		map.put(new String("A"), "ZhangSan_2");
		return map;
	}
	/**
	 * 现在的key允许重复，只要两个对象的地址不相等即可
	 * @return
	 */
	public static Map<String, String> TestMap3(){
		Map<String, String> map = new IdentityHashMap<String, String>();
		map.put(new String("A"), "ZhangSan_1");
		map.put(new String("A"), "ZhangSan_2");
		map.put("B", "LiSi_1");
		map.put("B", "LiSi_2");		
		return map;
	}	
	public static void print(Map<String, String> map){
		Set<Map.Entry<String, String>> allSet = map.entrySet();
		Iterator<Map.Entry<String, String>> iter = allSet.iterator();
		while(iter.hasNext()){
			Entry me = iter.next();
			System.out.println(me.getKey() +"-->"+me.getValue());
		}
	}
	
	public static void main(String[] args){
		System.out.println("Start test1");
		print(TestMap1());
		System.out.println("Start test2");
		print(TestMap2());
		System.out.println("Start test3");
		print(TestMap3());
		
		
		BigDecimal a = new BigDecimal(1.11);
		BigDecimal b = new BigDecimal(1.12);
		BigDecimal c = new BigDecimal(1.13);
		BigDecimal d = new BigDecimal(10.0100001);
		BigDecimal f = new BigDecimal(10.01);
		System.out.println("############:"+a.add(b).add(c));
		System.out.println("############:"+d.subtract(f));
	}
}
