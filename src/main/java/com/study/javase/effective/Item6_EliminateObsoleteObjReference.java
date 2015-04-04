package com.study.javase.effective;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 1.Nulling out object references should be the exception rather than the norm
 * 2.Another common source of memory leaks is caches
 * 3.A third common source of memory leaks is listeners and other callbacks
 * @author BULL
 *
 */
public class Item6_EliminateObsoleteObjReference {

	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	public Item6_EliminateObsoleteObjReference() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}
	public Object pop1() {  //bad method
		if (size == 0)
		throw new EmptyStackException();
		return elements[--size];
	}
	public Object pop() {   //good method
		if (size == 0)
		throw new EmptyStackException();
		Object result = elements[--size];
		elements[size] = null; // Eliminate obsolete reference
		return result;
		}	
	/**
	* Ensure space for at least one more element, roughly
	* doubling the capacity each time the array needs to grow.
	*/
	private void ensureCapacity() {
		if (elements.length == size)
		elements = Arrays.copyOf(elements, 2 * size + 1);
	}
}
