package com.study.pattern.iterator;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator{

	private T[] arr;
	private int index = -1;
	public ArrayIterator(T[] arr){
		this.arr = arr;
	}
	public boolean hasNext() {
		index ++;
		if(index > arr.length-1)
			return false;
		return arr[index] != null;
	}

	public T next() {
		return arr[index];
	}

	public void remove() {
		throw new UnsupportedOperationException();
		
	}

}
