package com.study.pattern.iterator;

import java.util.Iterator;

public class Test {

	public static void main(String[] args){
		Test test = new Test();
		AMenu amenu = new AMenu();
		BMenu bmenu = new BMenu();
		
		test.printMenu(amenu, bmenu);
	}
	
	private void printMenu(Menu...menus){
		for(Menu menu: menus){
			Iterator it = menu.createIterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
		}
	}
}
