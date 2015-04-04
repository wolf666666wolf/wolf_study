package com.study.pattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AMenu implements Menu{

	private static List<AFood> foodlist = new ArrayList<AFood>();
	static{
		foodlist.add(new AFood("1food", 20.00));
		foodlist.add(new AFood("2food", 10.00));
		foodlist.add(new AFood("3food", 15.00));
	}
	
	public Iterator createIterator() {
		
		return foodlist.iterator();
	}
}
