package com.moulik.collections.dheeru;

/**
 * Lists: Sequence/positioning
 * 
 * 	ArrayList 
 * 		fast random access O(1)
 * 		appending elements or deleting last element O(1)
 * 
 * 	LinkedList
 * 		frequent add/remove iteration
 * 
 * Queue: fast head/tail manipulations
 * 
 * 	ArrayDeque
 * 		LIFO and FIFO operations in O(1)
 * 		3X better than Linked List for large queues
 * 
 * Set: Uniqueness and fast lookups
 * 	
 * 	HashSet
 * 		very fast lookup, insertions and deletions ~ O(1)
 * 		Item 9: Always override hashcode() when you override equals()
 * 	
 * 	LinkedHashSet
 * 		insertion order preserved, still very fast ~ O(1)
 * 	
 * 	TreeSet
 * 		sorting, still very fast ~ O(log n)
 * 
 * Map
 * 		HashSet			--------- 	HashMap
 * 			^							^
 * 			|							|
 * 		LinkedHashSet 	--------- 	LinkedHashMap (LRU Cache)
 * 		
 * 		TreeSet		  	--------- 	TreeMap
 * 
 * 
 * Algorithm Classes:
 * 	Arrays
 * 		asList, sort, parallelSort, binarySearch, copyOf, equals
 * 			asList is used to convert an array to a list. To convert an array to a set, we can use:
 * 			1. new HashSet(Arrays.asList(array))
 * 			2. Collections.addAll(set, array)
 * 
 * 	Collections
 * 		addAll, sort, binarySearch, reverse, swap, shuffle, unmodifiableCollection
 * 
 * 	Item 43: Return empty arrays or collections, not null
 *  Item 55: Optimize judiciously
 *  		Write good programs which use good design principles. Good programs will help use to optimize later if needed.
 *
 */
public class Conclusion22 {

}
