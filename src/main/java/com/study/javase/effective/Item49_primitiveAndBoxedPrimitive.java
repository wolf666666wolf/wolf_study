package com.study.javase.effective;

import java.util.Comparator;

/**
 * 
 * @author BULL
 *
 */
public class Item49_primitiveAndBoxedPrimitive {

	public void wrongTest1(){
		Comparator<Integer> naturalOrder = new Comparator<Integer>() {
			public int compare(Integer first, Integer second) {
				return first < second ? -1 : (first == second ? 0 : 1);
			}
		};
	}
	public void rightTest1(){
		Comparator<Integer> naturalOrder = new Comparator<Integer>() {
			public int compare(Integer first, Integer second) {
				int f = first; // Auto-unboxing
				int s = second; // Auto-unboxing
				return f < s ? -1 : (f == s ? 0 : 1); // No unboxing
			}
		};		
	}
}
