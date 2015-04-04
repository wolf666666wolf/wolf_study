package com.study.javase.effective;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * there is no reason ever to return null from an array- or
collection-valued method instead of returning an empty array or collection.
 * @author Alex
 *
 */
public class Item43_ReturnNotNull {
	private final List<Cheese> cheesesInStock =new ArrayList<Cheese>();
	private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];
	public Item43_ReturnNotNull(){
		cheesesInStock.add(new Cheese());
		cheesesInStock.add(new Cheese());
		cheesesInStock.add(new Cheese());
	}
	// The right way to return a copy of a collection
	public List<Cheese> getCheeseList() {
		if (cheesesInStock.isEmpty())
			return Collections.emptyList(); // Always returns same list
		else{
			System.out.println("OldCheeseList:" + (cheesesInStock==new ArrayList<Cheese>(cheesesInStock)));
			return new ArrayList<Cheese>(cheesesInStock);
		}
	}
	
	

	// The right way to return an array from a collection
	public Cheese[] getCheeses() {
		return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
	}	
	
	public void testToArray(){
		List<String> testList = new ArrayList<String>();
		System.out.println("Test equal1:" + (testList.toArray() == testList.toArray()));
		System.out.println("Test equal2:" + (testList.toArray(EMPTY_CHEESE_ARRAY) == testList.toArray(EMPTY_CHEESE_ARRAY)));
	}
	public static void main(String[] args){
		Item43_ReturnNotNull item = new Item43_ReturnNotNull();
		System.out.println("newCheeseList:"+item.getCheeseList().hashCode());
		
		System.out.println("newCheeseArray:"+item.getCheeses().length);
		item.testToArray();
	}
}
class Cheese{}