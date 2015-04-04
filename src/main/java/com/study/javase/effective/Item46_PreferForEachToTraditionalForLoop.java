package com.study.javase.effective;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.study.javase.effective.Item46_PreferForEachToTraditionalForLoop.Rank;
import com.study.javase.effective.Item46_PreferForEachToTraditionalForLoop.Suit;
/**
 * It good to use for each from jdk1.5, but some condition we can't use
 * 1. Filtering—If you need to traverse a collection and remove selected elements,
	then you need to use an explicit iterator so that you can call its remove method.
   2. Transforming—If you need to traverse a list or array and replace some or all
	of the values of its elements, then you need the list iterator or array index in
	order to set the value of an element.
   3. Parallel iteration—If you need to traverse multiple collections in parallel,
	then you need explicit control over the iterator or index variable, so that all iterators
	or index variables can be advanced in lockstep (as demonstrated unintentionally
	in the buggy card and dice examples above).
 * @author BULL
 *
 */
public class Item46_PreferForEachToTraditionalForLoop {
	
	enum Suit { CLUB, DIAMOND, HEART, SPADE };
	enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
		NINE, TEN, JACK, QUEEN, KING };
		
	public static void badMethod(){ 
		System.out.println("badMethod start....");
		Collection<Suit> suits = Arrays.asList(Suit.values());
		Collection<Rank> ranks = Arrays.asList(Rank.values());
		List<Card> deck = new ArrayList<Card>();
		for (Iterator<Suit> i = suits.iterator(); i.hasNext(); )
			for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); )
				deck.add(new Card(i.next(), j.next()));		//will throw exception
	}
	
	public static void goodMehod(){
		System.out.println("goodMethod start....");
		Collection<Suit> suits = Arrays.asList(Suit.values());
		Collection<Rank> ranks = Arrays.asList(Rank.values());
		List<Card> deck = new ArrayList<Card>();
		for(Suit suit: suits)
			for(Rank rank: ranks)
				deck.add(new Card(suit, rank));	
		
	}
	
	public static void main(String[] args){
		goodMehod();
		badMethod();
	}
}
class Card{
	public Card(Suit suit, Rank rank){
		System.out.println("new Card[suit:" + suit.name()+" rank:"+rank.name()+"]");
	}
}