package com.study.javase.effective;

/**
 * 
 * 
 *
 */
public class Item12_Comparable implements Comparable<Item12_Comparable>{
	private  short areaCode;
	private  short prefix;
	private  short lineNumber;

	public int compareTo(Item12_Comparable pn) {
		// Compare area codes
		if (areaCode < pn.areaCode)
			return -1;
		if (areaCode > pn.areaCode)
			return 1;

		// Area codes are equal, compare prefixes
		if (prefix < pn.prefix)
			return -1;
		if (prefix > pn.prefix)
			return 1;
		// Area codes and prefixes are equal, compare line numbers
		if (lineNumber < pn.lineNumber)
			return -1;
		if (lineNumber > pn.lineNumber)
			return 1;
		return 0; // All fields are equal
	}
}
