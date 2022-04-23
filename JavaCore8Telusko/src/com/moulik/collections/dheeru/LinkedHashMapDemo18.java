package com.moulik.collections.dheeru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap:
 * 1. It is a hash-table and linked list implementation of Map interface
 * 2. Preserves insertion order ~ Doubly Linked List
 * 3. Extends HashMap - nearly as fast too ~ rapid lookup, insertion and deletions
 * 4. permit null values and one null key
 * 5. not synchronized
 * 6. Iteration(LinkedHashMap) is faster than Iteration(HashMap)
 * 		Iteration(LinkedHashMap) -> no of mappings
 * 		Iteration(HashMap) -> capacity
 * 
 * LinkedHashMap is well used to maintain LRUCache. (LeastRecentlyUsed)
 * A cache is a component that stores important data (recently used/ frequently accessed/most liked-shared etc) so as 
 * to provide quick access to it. memcached is a very popular in-memory caching system that many websites use for 
 * storing data for fast access. It is stored in RAM for fast access.
 * 
 * LRU cache stores elements based on how recently they are used. When we insert an entry it stores it at the "most 
 * recently used" (MRU) end of the cache memory and when the cache is full, the element at the "least recently used" (LRU)
 * end will be removed (evicted). So cache has a fixed size.
 * If a entry is accessed, then it is moved to the MRU end. Keep in mind that it is most recently used, not most 
 * frequently used.
 * 
 * LinkedHashMap can act as a LRU cache by using its constructor and passing true in access order. However, it will be of
 * infinite size. That means, the LRU element will not be removed. However, if we want to create a LinkedHashMap of 
 * some finite size, then we need to write our own class by extending LinkedHashMap.
 * To remove the LRU element manually, we can use removeEldestEntry(Map.Entry<K,V> eldest) which should be overridden
 * in the UserDefinedClass.
 * 
 * 
 *
 */
public class LinkedHashMapDemo18 {
	/*
	 * Demo: 1. See output with and without commenting get() calls 2. See output
	 * when accessOrder=false with get() calls. get calls do not have any influence
	 * 3. Finally, change object type from LRUCache to LinkedHashMap and see output.
	 * All 5 mappings will be printed as removeEldestEntry would return false by
	 * default
	 */
	private static void lruCacheTest() {
		System.out.println("\n\nInside lruCacheTest ...");
		//Map<String, String> lruCache = new LinkedHashMap<>(16, 0.75f, true);
		Map<String, String> lruCache = new LRUCache<>(16, 0.75f, true);
		lruCache.put("a", "A");
		lruCache.put("b", "B");
		lruCache.put("c", "C");
		System.out.println(lruCache);

		lruCache.get("a"); // multiple gets to "a" will not make a difference
		lruCache.get("a");
		lruCache.get("a");
		System.out.println(lruCache);
		lruCache.get("b");
		System.out.println(lruCache);

		lruCache.put("d", "D");
		System.out.println(lruCache);
		lruCache.put("e", "E");
		System.out.println(lruCache);
	}

	public static void main(String[] args) {
		// hashMapDemo();
		// immutableKeysDemo();
		lruCacheTest();
	}
}
class LRUCache<K,V> extends LinkedHashMap<K,V> {
	//private static final long serialVersionUID = 6464155743798737431L;
	private static final int MAX_ENTRIES = 3;
	  
	public LRUCache(int initialCapacity,
	             float loadFactor,
	             boolean accessOrder) {
		 super(initialCapacity, loadFactor, accessOrder);
	}
	  
	// Invoked by put and putAll after inserting a new entry into the map
	public boolean removeEldestEntry(Map.Entry eldest) {
	     return size() > MAX_ENTRIES;
		 // return false; // same as normal linked hash map
	}		  
}
