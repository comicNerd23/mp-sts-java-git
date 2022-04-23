package com.moulik.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

/**
 * 	List (4-2-2-2-2 = 12)
 * 
 * 
 * 				E					get(int index)
 * 				boolean 			add(E obj), add(int index, E element)
 * 				E					set(int index, E element)
 * 				boolean 			remove(E obj)
 * 				
 * 				int					indexOf(Object o)
 * 				int					lastIndexOf(Object o)
 * 
 * 				ListIterator<E> 	listIterator()
 * 				ListIterator<E> 	listIterator(int index)
 * 	default		Spliterator<E>		spliterator()
 * 
 * 	default		void				sort(Comparator<? super E> comp)
 * 				List<E>				subList(int start, int end)
 * 
 * 	static		List<E>				of(E... elements)
 * 	static		List<E>				copyOf(Collection c)
 *
 *	Arrays VS LinkedList
 *	
 *
 *	ArrayList VS LinkedList
 *	
 *	HashMap vs HashTable
 *	1. Hashtable is synchronised and Hashmap is not. 
 *	2. Hashmap allows null values as key but Hashtable does not.
 *	- The complexity is O(1)
 */
public class ListDemo {

	public static void main(String[] args) {
		
		System.out.println("---------------------------- Ways To Create List --------------------------------------");

		//This way creates a modifiable list (we can add as many elements later as we want)
		List<Integer> values = new ArrayList<>();
		values.add(23);
		values.add(18);
		values.add(44);
		
		//Java 9: This list created is an unmodifiable list
		List<Integer> valuesList = List.of(4,5,6,72,6,254);
		
		//Another way to create an unmodifiable list
		List<Integer> valuesList2 = Arrays.asList(4,5,6,72,6,254);
		
		
		System.out.println("---------------------------- Sorting List --------------------------------------");
		
		Collections.sort(values);	//sorts the collection in natural ordering
		
		/* This comparator sort based on the units place
		 * Collections.sort(values, new Comparator<Integer>() {
		 * 
		 *	 	@Override 
		 *	 	public int compare(Integer o1, Integer o2) {
		 *	 		if(o1%10 > o2%10) {
		 *	 			return 1; 
		 * 			}
		 * 			else { 
		 *	 			return -1; 
		 * 			} 
		 * 		}
		 * });
		 */
		Collections.sort(values, (i,j)-> i%10>j%10 ? 1 : -1 );
		
		//Collections.reverse(values); //reverses the collection
		//Collections.shuffle(values); //shuffles the collection in random order
		
		values.stream()
			.forEach(x->System.out.println(x));
		
		
		/* List containing Even Numbers */
		List<Integer> evenValues = valuesList.stream()
			.filter( s -> (s%2 == 0))
			.collect(Collectors.toList());
		System.out.println(evenValues);
		
	}

}
