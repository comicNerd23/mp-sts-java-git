package com.moulik.collections.dheeru;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * LinkedHashSet
 * 1. It is hashtable and linkedlist implementation of Set interface
 * 2. Preserves insertion order - uses doubly linked list
 * 3. extends HashSet - nearly as fast too
 * 		rapid lookup, insertions and deletions ~ O(1)
 * 4. Permits one null element
 * 5. Internally uses LinkedHashMap
 * 
 * Typical Uses of LinkedHashSet
 * 1. Rapid Lookup, insertion and deletion ~ O(1)
 * 2. Insertion Order is important
 * 3. Better (than ArrayLists) for frequent removeAll() and retainAll() operations.
 * 
 * Although most other operations of LinkedHashSet will be slower than those of HashSet, the iteration of elements in
 * LinkedHashSet is faster than HashSet because:
 * Iteration in LinkedHashSet is dependent on number of elements, due to the usage of doubly-linked list
 * Iteration in HashSet is dependent on the capacity (number of buckets)
 *
 */
public class LinkedHashSetDemo13 {
	
	public static void linkedHashSetDemo() {
		Set<String> hashSet = new HashSet<>();
		hashSet.add("Raj");
		hashSet.add("John");
		hashSet.add("Anita");
		System.out.println("hashSet: " + hashSet);
		
		Set<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("Raj");
		linkedHashSet.add("John");
		linkedHashSet.add("Anita");
		System.out.println("linkedHashSet: " + linkedHashSet);
	}
	
	public static void main(String[] args) {
		// hashSetDemo();
		linkedHashSetDemo();
	}

}
