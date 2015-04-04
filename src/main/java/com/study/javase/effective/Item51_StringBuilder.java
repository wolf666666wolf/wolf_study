package com.study.javase.effective;
/**
 * Beware the performance of string concatenation
 * @author BULL
 *
 */
public class Item51_StringBuilder {
    
	public String statement() {
		int numItems= 100;
		int LINE_WIDTH = 20;
		StringBuilder b = new StringBuilder(numItems * LINE_WIDTH);
		for (int i = 0; i < numItems; i++)
		b.append("lineForItem");
		return b.toString();
	}
}
