package com.moulik.collections.dheeru;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Iterable is an interface which the Collection interface extends. It has 3 methods:
 * 	Iterator<T> iterator() returns Iterator for processing
 * 
 * 	default void forEach(Consumer<? super T> action): Lambda (for Consumer.accept) can be passed 
 * 	default Spliterator<T> spliterator() : splits the collection into partitions for parallel processing
 * 
 * Internally, enhanced-for uses an instance of Iterable to iterate over elements.
 * 
 * Iterator is an interface which is used to traverse the elements and it also allows "element removal" during 
 * iteration.
 * 
 * 	boolean hasNext()
 * 	E next()
 * 	void remove()
 * 	default void forEachRemaining(Consumer<? super E> action)
 * 
 * The main benefit of Iterator is that it can be used to remove the elements during iteration which was not possible
 * using enhanced-for loop.
 * 
 * The main reason why we get a ConcurrentModificationException in an enhanced-for is we are asking JVM to remove the 
 * element while it is running an iterator internally. Here 'modification' is structural modification; adding/removing
 * an element. Replacement is fine (using set()).
 * An iterator which gives a ConcurrentModificationException is called a fail-fast iterator.
 * 
 * If we try to invoke it.remove() without invoking it.next() method, then you will get IllegalStateException().
 *
 */
public class IteratorDemo6 {

	private static List<Integer> arrayListDemo() {
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
		System.out.println("list1.contains(1): " + list1.contains(1));
		System.out.println("list1.indexOf(1): " + list1.indexOf(1));
		System.out.println("list1.lastIndexOf(1): " + list1.lastIndexOf(1));		
		System.out.println("list1: " + list1);
		
		
		// Range-view: subList (new list is backed by original)
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
		
		/*for (int element : list1) {
			System.out.println("element: " + element);
			
			// Generates ConcurrentModificationException
			if (element == 9) {
				list1.remove(Integer.valueOf(element)); // valueOf is used due to its caching
			}
		}*/
		
		return list1;
	}
	
	public static void main(String[] args) {
		List<Integer> list = arrayListDemo();
		
		Iterator<Integer> it = list.iterator();
		
		while(it.hasNext()) {
			if(it.next()==9) {
				it.remove();
			}
		}
		
		System.out.println("list: " + list);
		Iterator<Integer> its = list.iterator();
		for( ;its.hasNext();) {
			if(its.next()==8) {
				its.remove();
			}
		}
		//System.out.println("list: " + list);
		
		list.forEach(System.out::println);
	}

}
