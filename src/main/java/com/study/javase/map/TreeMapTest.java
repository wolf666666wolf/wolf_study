package com.study.javase.map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;



public class TreeMapTest {

	public static void main(String[] arg){
		Map map = new TreeMap();
		Student s1 = new Student("Billy", 70);
		Student s2 = new Student("David", 85);
		Student s3 = new Student("Kite", 92);
		Student s4 = new Student("Cissy", 68);
		
		map.put(s1, new StudentDetail(s1));
		map.put(s2, new StudentDetail(s2));
		map.put(s3, new StudentDetail(s3));
		map.put(s4, new StudentDetail(s4));
		
		Map map1 = ((TreeMap)map).subMap(s4, s2);
		printMap(map1);
//		name:Cissy score:68->Cissy 's detial info
//		name:Billy score:70->Billy 's detial info
		
		map1 = ((TreeMap)map).headMap(s1);
		printMap(map1);	
//		name:Cissy score:68->Cissy 's detial info
		
		map1 =((TreeMap)map).tailMap(s1);
		printMap(map1);
//		name:Billy score:70->Billy 's detial info
//		name:David score:85->David 's detial info
//		name:Kite score:92->Kite 's detial info		
	}
	public static void printMap(Map map){
		for(Iterator iterator =map.keySet().iterator(); iterator.hasNext();){
			Student key = (Student)iterator.next();
			System.out.println(key + "->" +map.get(key));
		}
	}
}
