package com.moulik.collections.dheeru;

/**
 * ArrayList is a resizable array implementation of a List interface
 * 	Default capacity is 10, increases by 50%
 * 	ArrayList(int initialCapacity) constructor creates an Arraylist with this initial capacity.
 * 	ensureCapacity(int) maintains the minimum capacity for the arrayList
 * 	allows duplicates and null
 * 	
 * Simple Iteration of elements
 * fast random access ~ O(1)
 * appending elements or deleting last element ~ O(1)
 * 
 * 	add(index, element)
 * 		following elements are shifted right by one position
 * 		O(n)
 * 	remove(index)
 * 		following elements are shifted left by one position
 * 		O(n)
 * 	contains()
 * 		O(n)		Uses equals()
 * 	indexOf()
 * 		O(n)		Uses equals()
 * 
 * If there are frequent search, then go with Set implementation (HashSet searching ~ O(1))
 * 
 * 	removeAll(collection)
 * 		collection.contains() on every element
 * 				if element is present -> remove it
 * 		Can be worse than O(n2)
 * 				O(n) ~ traversing current list
 * 				O(n) ~ contains() call (if collection is list impl)
 * 				O(n) ~ element shift on remove()
 * 	retainAll(collection) ~ has identical performance issues
 * 
 * O(1)
 * 		size()
 * 		isEmpty()
 * 		set() and get()
 * 		iterator() and listIterator()
 * 		
 * 
 *
 */
public class ArrayList4 {

}
