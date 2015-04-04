package com.study.pattern.visiter;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式适合数据结构相对稳定的系统。
 * 他把数据结构和作用于数据结构上的操作解耦，使得操作集合可以相对自由的演化，
 * 优势是增加新的操作很容易
 * 缺点 增加新的数据结构很困难
 * @author BULL
 *
 */
public class ObjectStructure {
	private List<Person> elements = new ArrayList<Person>();
	
	public void attach(Person person){
		elements.add(person);
	}
	public void remove(Person person){
		elements.remove(person);
	}
	public void display(Visitor visitor){
		for(Person person: elements){
			person.accept(visitor);
		}
	}
	public static void main(String[] args){
		
		ObjectStructure os = new ObjectStructure();
		os.attach(new Man());
		os.attach(new Woman());
		
		os.display(new Success());
		os.display(new Failed());
		os.display(new Love());
		
	}
}
