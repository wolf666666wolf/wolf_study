package com.study.javase.map;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
/**
顾名思义LinkedHashMap是比HashMap多了一个链表的结构。与HashMap相比LinkedHashMap维护的是一个具有双重链表的HashMap，LinkedHashMap支持2中排序一种是插入排序，一种是使用排序，最近使用的会移至尾部例如 M1 M2 M3 M4，使用M3后为 M1 M2 M4 M3了，LinkedHashMap输出时其元素是有顺序的，而HashMap输出时是随机的，如果Map映射比较复杂而又要求高效率的话，最好使用LinkedHashMap，但是多线程访问的话可能会造成不同步，所以要用Collections.synchronizedMap来包装一下，从而实现同步。其实现一般为：
    Map<String String> map = Collections.synchronizedMap(new LinkedHashMap(<String String));

HashMap,LinkedHashMap,TreeMap都属于Map

Map 主要用于存储键(key)值(value)对，根据键得到值，因此键不允许键重复,但允许值重复。

HashMap 是一个最常用的Map,它根据键的HashCode 值存储数据,根据键可以直接获取它的值，具有很快的访问速度。HashMap最多只允许一条记录的键为Null;允许多条记录的值为 Null;HashMap不支持线程的同步，即任一时刻可以有多个线程同时写HashMap;可能会导致数据的不一致。如果需要同步，可以用 Collections的synchronizedMap方法使HashMap具有同步的能力。

LinkedHashMap LinkedHashMap也是一个HashMap,但是内部维持了一个双向链表,可以保持顺序

TreeMap 不仅可以保持顺序，而且可以用于排序
 * @author BULL
 *
 */
public class Map1 {

    public static void testHashMap() {
    	System.out.println("testHashMap start++++++++++++++++++++++++++");
        Map<String, String> map = new HashMap<String, String>();
        map.put("a3", "aa");
        map.put("a2", "bb");
        map.put("b1", "cc");
        for (Iterator iterator = map.values().iterator(); iterator.hasNext();) {
            String name = (String) iterator.next();
            System.out.println(name);
        }
    }	
    public static void testLinkedHashMap() {
    	System.out.println("testLinkedHashMap start++++++++++++++++++++++++++");
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("a3", "aa");
        map.put("a2", "bb");
        map.put("b1", "cc");
        for (Iterator iterator = map.values().iterator(); iterator.hasNext();) {
            String name = (String) iterator.next();
            System.out.println(name);
        }
    } 
    public static void testTreeMap() {
    	System.out.println("testTreeMap start++++++++++++++++++++++++++");
        Map<String, String> map = new TreeMap<String, String>(new Comparator<Object>(){
            Collator collator = Collator.getInstance(); 
            public int compare(Object o1, Object o2) {
                CollationKey key1 = collator.getCollationKey(o1.toString());
                CollationKey key2 = collator.getCollationKey(o2.toString());
                return key1.compareTo(key2);
                //return collator.compare(o1, o2);
            }});
        map.put("a3", "aa");
        map.put("a2", "bb");
        map.put("b1", "cc");
        for (Iterator iterator = map.values().iterator(); iterator.hasNext();) {
            String name = (String) iterator.next();
            System.out.println(name);
        }
    }  
    
    public static void main(String[] args){
    	testHashMap();
    	testLinkedHashMap();
    	testTreeMap();
    }
}
