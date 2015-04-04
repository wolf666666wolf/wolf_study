package com.study.javase.effective;

/**
 * 1. Use the == operator to check if the argument is a reference to this object.
If so, return true. This is just a performance optimization, but one that is worth
doing if the comparison is potentially expensive.
2. Use the instanceof operator to check if the argument has the correct type.
If not, return false. Typically, the correct type is the class in which the method
occurs. Occasionally, it is some interface implemented by this class. Use an interface
if the class implements an interface that refines the equals contract to
permit comparisons across classes that implement the interface. Collection interfaces
such as Set, List, Map, and Map.Entry have this property.
3. Cast the argument to the correct type. Because this cast was preceded by an
instanceof test, it is guaranteed to succeed.
 * @author BULL
 *
 */
public class Item8_OverridingEquals {

	@Override 
	public boolean equals(Object o) {
		
		if (!(o instanceof Item8_OverridingEquals))
		return false;
		Item8_OverridingEquals mt = (Item8_OverridingEquals) o;
		//	...
		
		
		return true;
	}
}
