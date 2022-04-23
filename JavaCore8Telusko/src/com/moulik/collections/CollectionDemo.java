package com.moulik.collections;

import java.util.ArrayList;
import java.util.Collection;

//collections are in general groups of data
//Collection is an interface which has the declarations of many methods useful for working with DS in collections
//Collections is a class

/**
 * Collection (6-2-5-2-4 = 19)
 * 
 * 				int					size()
 * 				boolean 			isEmpty()
 * 				boolean 			contains(Object element)
 * 				boolean 			add(E obj)
 * 				boolean 			remove(E obj)
 * 				Iterator<E> 		iterator()
 * 
 *				Object[] 			toArray()
 * 				<T>	T[]				toArray(T array[])
 * 
 * 				boolean				containsAll(Collection<?> c)
 * 				boolean				addAll(Collection<? extends E> c)
 * 				boolean				removeAll(Collection<?> c)
 *				boolean				retainAll(Collection<?> c)
 *				void				clear()
 *
 *				boolean				equals(Object o)
 *				int					hashCode()
 *
 *	default		Stream<E>			stream()
 *	default		Stream<E>			parallelStream()
 *	default		boolean				removeIf(Predicate<? super E> predicate)
 *	default		SplitIterator<E> 	splitIterator()
 * 
 * 	Collection Classes
 * 		AbstractCollection		implements most of the Collection Interface
 * 		AbstractSet				extends AbstractCollection; implements most of the Set 
 * 		AbstractList			extends AbstractCollection; implements most of the List
 * 		AbstractSequentialList	extends AbstractCollection; that uses Sequential Access of elements
 * 		AbstractQueue			extends AbstractCollection; implements parts of the Queue
 * 		ArrayDeque				extends AbstractCollection; implements Deque
 * 		HashSet					extends AbstractSet; implements Set
 * 		TreeSet					extends AbstractSet; implements NavigableSet				
 * 		EnumSet					extends AbstractSet; implements Set; for use with Enums
 * 		LinkedHashSet			extends AbstractSet; implements Set; Maintains Insertion Order
 * 		ArrayList				extends AbstractList; implements List; Random Access
 * 		LinkedList				extends AbstractSequentialList; implements List,Deque,Queue
 * 		PriorityQueue			extends AbstractQueue; implements Queue (to support priority based queues)
 *
 */
public class CollectionDemo {

	public static void main(String[] args) {
		
		Collection<Integer> values = new ArrayList<>();
		values.add(23);
		values.add(12);
		values.add(44);
		
		
		//Pre Java-8 way of traversing collections 
		/*
		 * for(int x: values) { System.out.println(x); }
		 */
		
		//A better way to traverse the collections is using aggregate operations
		values.stream()
			.filter(x->x>20)
			.forEach(x->System.out.println(x));
		
		System.out.println("All elements");
		values.spliterator().forEachRemaining(System.out::println);
		

	}

}
