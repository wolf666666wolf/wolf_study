package com.study.pattern.iterator;

import java.util.Iterator;

public class BMenu implements Menu{

	private static BFood[] bfoodArray = null;
	static{
		bfoodArray = new BFood[]{
			new BFood("1bfood", 100.00, false),
			new BFood("2bfood", 85.00, true),
			new BFood("3bfood", 73.15, true),
		};
	}
	public Iterator createIterator() {
		
		return new ArrayIterator<BFood>(bfoodArray);
	}

}
