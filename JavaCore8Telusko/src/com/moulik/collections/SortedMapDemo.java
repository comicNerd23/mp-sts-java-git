package com.moulik.collections;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * SortedMap ( 3-3 = 6)
 * 
 * 		Comparator<? super k> 		comparator
 * 		K							firstKey()
 * 		K							lastKey()
 * 
 * 		SortedMap<K,V>				headMap(K end)
 *		SortedMap<K,V>				tailMap(K start)
 *		SortedMap<K,V>				subMap(K start, K end)
 */
public class SortedMapDemo {

	public static void main(String[] args) {
		
		SortedMap<Integer, String> rollNoStudent = new TreeMap<>();
		rollNoStudent.put(701, "Moulik");
		rollNoStudent.put(707, "Bhuwan");
		rollNoStudent.put(397, "Puneet");
		rollNoStudent.put(399, "Shivam");
		
		System.out.println("First Key:"+rollNoStudent.firstKey());
		System.out.println("Last Key:"+rollNoStudent.lastKey());
		
		System.out.println("HeadMap from Key 701:"+rollNoStudent.headMap(701));
		System.out.println("TailMap from Key 701:"+rollNoStudent.tailMap(701));
		
		Comparator<? super Integer> x = rollNoStudent.comparator();
	}

}
