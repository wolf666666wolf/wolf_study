package com.study.javase.effective;

/*
 * 1.Avoid creating unnecessary objects eg.String s = new String("stringette"); // DON'T DO THIS!
 * 2. prefer primitives to boxed primitives, and watch out for unintentional autoboxing.
 */
public class Item5_UnnecessaryObjects {
	// Hideously slow program! Can you spot the object creation?
	public static void main(String[] args) {
		Long sum = 0L;
			for (long i = 0; i < Integer.MAX_VALUE; i++) {
					sum += i;
			}
		System.out.println(sum);
	}
}
