package com.moulik.collections.dheeru;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * The returned set from the range view methods is backed by the original set. Changes in the returned set will be 
 * reflected in the original set and vice-versa. Note, the returned set will throw an IllegalArgumentException if we
 * try to insert an element into that set and that element is outside the range of the returned set.
 * 
 *
 */
public class MoreTreeSetDemo16 {
	
	private static void treeSetDemo2() {
		NavigableSet<Integer> set = new TreeSet<>();
		set.add(5);
		set.add(23);
		set.add(74);
		set.add(89);
		
		System.out.println("lower: " + set.lower(74));
		System.out.println("floor: " + set.floor(74));
		System.out.println("ceiling: " + set.ceiling(74));
		System.out.println("higher: " + set.higher(74));
		
		System.out.println("first: " + set.first());
		System.out.println("last: " + set.last());
		
		System.out.println("set: " + set);
		
		NavigableSet<Integer> descendingSet = set.descendingSet();
		System.out.println("descendingSet: " + descendingSet);
		
		NavigableSet<Integer> headSet = set.headSet(74, true);
		System.out.println("headSet: " + headSet);
		
		headSet.add(6);
		System.out.println("headSet: " + headSet);
		System.out.println("set: " + set);
		headSet.add(4);
		//headSet.add(75); // throws IllegalArgumentException
		System.out.println("set: " + set);
		
		SortedSet<Integer> subSet = set.subSet(5, 74);
		//subSet.add(2); // throws IllegalArgumentException
		//subSet.add(75); // throws IllegalArgumentException
		
		// Adding element in backed set (original set) and 
		// see it getting reflected in subSet
		set.add(25);
		System.out.println("subSet: " + subSet);
	}
	
	public static void main(String[] args) {
		// hashSetDemo();
		// linkedHashSetDemo
		// treeSetDemo();
		treeSetDemo2();
	}

}