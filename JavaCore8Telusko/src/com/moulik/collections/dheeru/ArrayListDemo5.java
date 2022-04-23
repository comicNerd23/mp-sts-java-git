package com.moulik.collections.dheeru;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Basic Operations:
 * 	We can add duplicates and null values
 * 	remove() is called based on Method Binding at compile time. collection.remove(Object o) vs list.remove(int index).
 * 	remove(index) will be called since we are calling list instance not collection instance. If index >= list.length, 
 *  then it will throw Exception(IndexOutOfBoundsException)
 * 	set(int index, int elem) will set the elem at that index and return the previous element at that index
 * 
 * Bulk Operations:
 * 	addAll(Collection c)	adds all elements of collection c in the underlying arraylist(collection)
 * 	removeAll(Collection c)	removes all elements of collection c from the underlying arraylist(collection)
 *	retainAll(Collection c)	retains all elements of collection c from the underlying arraylist; rest are removed
 *
 * Search Operations:
 * 	contains()
 * 	indexOf()
 * 	lastIndexOf()
 * 
 * Range-View Operations:
 * 	subList(int start, int endExclusive) the list returned is backed by original list
 * 
 * So, if you do non-structural changes (like set(index, elem)) to the list, those will be reflected in the sublist 
 * and vice-versa.
 * However, if do structural change (like add(index, elem) or remove(index)) to the list (not the sublist), 
 * you will get an ConcurrentModificationException. add(index, elem) to the sublist will work fine.
 * 
 * Iteration using for (or enhanced for) loop:
 * 	While iterating through the elements of the list, if we try to remove an element, we will get a CME.
 * 
 * 
 * 
 */
public class ArrayListDemo5 {
	
	private static void arrayListDemo() {
		
		//Basic Operations
		
		//Collection<Integer> list1 = new ArrayList<>(); has remove(Object o)
		List<Integer> list1 = new ArrayList<>();	// has remove(int index)
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(3);
		list1.add(null);
		System.out.println("list1: " + list1);
		
		list1.remove(3);
		System.out.println("list1: " + list1);
		list1.remove(3);
		System.out.println("list1: " + list1);
		
		list1.add(0, 10);
		System.out.println("list1: " + list1);
		list1.set(0, 9);
		System.out.println("list1: " + list1);
				
		// Bulk Operations
		System.out.println("Bulk Operations");
		Collection<Integer> list2 = new ArrayList<>();
		list2.add(9);
		list2.add(3);
		
		list1.removeAll(list2);
		System.out.println("list1: " + list1);
		
		list2.add(1);
		
		list1.retainAll(list2);
		System.out.println("list1: " + list1);
		
		list1.addAll(list2);
		System.out.println("list1: " + list1);
		
		System.out.println("list1.set(2, 2): " + list1.set(2, 2));
		
		
		// Search
		System.out.println("Search Operations");
		System.out.println("list1.contains(1): " + list1.contains(1));
		System.out.println("list1.indexOf(1): " + list1.indexOf(1));
		System.out.println("list1.lastIndexOf(1): " + list1.lastIndexOf(1));		
		System.out.println("list1: " + list1);
		
		
		// Range-view: subList (new list is backed by original)
		System.out.println("Range-view Operations");
		List<Integer> list3 = list1.subList(2, 3);
		list3.set(0, 6);
		System.out.println("list1: " + list1);
		list3.add(0, 7);
		System.out.println("list1: " + list1);
		list1.set(2, 8);
		System.out.println("list3: " + list3);
		//list1.add(0, 8);
		//System.out.println("list3: " + list3);
		System.out.println("list1: " + list1);
		System.out.println("list1.get(4): " + list1.get(4));
		
		list1.remove(5); //Added just to test how remove method works: remove(Object) or remove(index).
		for (int element : list1) {
			System.out.println("element: " + element);
			
			// Generates ConcurrentModificationException
			if (element == 9) {
				list1.remove(Integer.valueOf(element)); // valueOf is used due to its caching
			}
		}
		
	}
	
	public static void main(String[] args) {
		arrayListDemo();		
	}

}
