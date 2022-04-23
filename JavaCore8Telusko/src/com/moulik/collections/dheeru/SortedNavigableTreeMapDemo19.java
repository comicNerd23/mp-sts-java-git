package com.moulik.collections.dheeru;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * SortedMap
 * 1. MapCapabilities + data sorted by keys
 * 2. Natural Ordering or Comparator ~ by keys
 * 
 * 	public interface SortedSet<K,V> extends Map<K,V> {
 * 		
 * 		//Range-View
 * 		SortedMap<K,V> headMap(K fromKey)
 *  	SortedMap<K,V> tailMap(K toKey)
 *  	SortedMap<K,V> subMap(K fromKey, K toKey)
 * 		
 * 		//Endpoints
 * 		K firstKey();
 * 		K lastKey();
 * 		
 * 		//Comparator Access
 * 		Comparator<? super E> comparator();
 * 
 * 		//CollectionView Operations:
 * 		Set<K> keySet();
 * 		Collection<V> values();
 * 		Set<Map.Entry<K,V>> entrySet();
 * 
 * 		Similar to SortedMap, the Set/Collection returned by collection view operations are backed by the original map.
 * 		But it is only possible to remove entries, not add them (throws UnsupportedOperationException).
 * 	}
 * 
 * 	public interface NavigableMap<K,V> extends SortedMap<K,V> {
 * 	
 * 		//Closest Matches
 * 		L lowerKey/higherKey/floorKey/ceilingKey(Key k)
 * 		Map.Entry<K,V> lowerEntry/higherEntry/floorEntry/ceilingEntry(K key)
 * 
 * 		NavigableSet<K> descendingKeySet();
 * 		NavigableMap<K,V> descendingMap();
 * 
 * 		//Endpoints
 * 		Map.Entry<K,V> pollFirstEntry();
 * 		Map.Entry<K,V> pollLastEntry();
 * 
 * 		//Range-view Operations
 * 		NavigableMap<K,V> headMap(K toKey, boolean inclusive);
 * 		NavigableMap<K,V> tailMap(K fromKey, boolean inclusive);
 * 		NavigableMap<K,V> subMap(K fromKey, boolean lowIncluded, K toKey, boolean highIncluded);
 * 	}
 */
public class SortedNavigableTreeMapDemo19 {
	private static void treeMapDemo() {
		System.out.println("\n\nInside treeMapDemo ...");
		TreeMap<String, Integer> map1 = new TreeMap<>();
		map1.put("John", 25);
		map1.put("Raj", 29);
		map1.put("Anita", 23);
		
		System.out.println(map1);	
		
		System.out.println("Iterating using entrySet ...");
		Set<Map.Entry<String, Integer>> mappings = map1.entrySet();
		for (Map.Entry<String, Integer> mapping : mappings) {
			System.out.println("Name: " + mapping.getKey() + ", Age: " + mapping.getValue());
			if (mapping.getKey().equals("John"))
				mapping.setValue(26);	
		}
		System.out.println(map1);
		map1.floorEntry("Raj").setValue(22);
	}
		
	public static void main(String[] args) {
		// hashMapDemo();	
		// immutableKeysDemo();		
		// lruCacheTest();	
		treeMapDemo();
	}
}