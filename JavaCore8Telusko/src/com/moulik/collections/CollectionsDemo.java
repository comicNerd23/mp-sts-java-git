package com.moulik.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**	116-122-25
 * Collections is a class in Java which provides many utility methods for dealing with common problems in collections :
 * All methods are static, whose first argument is the collection on which the operation is to be performed.
 * 
 * 1. Sorting (1)
 * 		sort(List<T>)		sort(List<T>, Comparator<? super T>)
 * 
 * 2. Shuffling (1)
 * 		shuffle(List<T>)	shuffle(List<T>, Random)
 * 
 * 3. RoutineDataManipulation (6)
 * 		reverse(List<T>)	reverseOrder()		reverseOrder(Comparator<T>)
 * 		fill(List<? super T> list, T t)
 * 		copy(List<? super T) list1, List<? extends T> list2)
 * 		swap(List<T> list, int index1, int index2)
 * 		addAll(Collection<? super T> c, T... elements)
 * 		replaceAll(List<T> list, T old, T new)
 * 
 * 4. Searching (1)
 * 		binarySearch(List<? extends Comparable<? super T>> list, T value)
 * 		binarySearch(List<? extends T> list, T value, Comparator<? super T> comp)
 * 
 * 5. Composition (2)
 * 		frequency(Collection<?> c, Object obj)
 * 		disjoint(Collection<?> a, Collection<?> b)
 * 
 * 6. Finding Extreme Values (2)
 * 		min(Collection<? extends C> c)		min(Collection<? extends C> c, Comparator<? super T> comp)
 * 		max(Collection<? extends C> c)		max(Collection<? extends C> c, Comparator<? super T> comp)
 * 
 * 7. SubList search (2)
 * 		indexOfSubList(List<?> list, List<?> subList)
 * 		lastIndexOfSubList(List<?> list, List<?> subList)
 * 
 * 8. With other Collections (5)
 * 		Legacy Collections
 * 			Enumeration<T> enumeration(Collection<T> c)
 * 			ArrayList<T> list(Enumeration<T> enum)
 * 		
 * 		Immutable MultiCopy List
 * 			List<T> nCopies(int num, T obj)
 * 		Convenience Set of keys From Map
 * 			Set<E> 	newSetFromMap(Map<E, boolean> n)
 * 		Queue<T> asLifoQueue(Deque<T> c)
 * 
 *
 */
public class CollectionsDemo {

	public static void main(String[] args) {

		Collections col = null;
		
		System.out.println("-------------------------- Sorting ------------------------------------");
		
		List<String> names = Arrays.asList("Harry", "Ron", "Hermione", "Neville", "Ginny", "Luna");
		
		System.out.println("-------------------------- Shuffling ------------------------------------");
		
		System.out.println("-------------------------- Routine Manipulation ------------------------------------");
		
		System.out.println("-------------------------- Searching ------------------------------------");
		
		System.out.println("-------------------------- Composition ------------------------------------");
		
		System.out.println("-------------------------- Finding Extreme Values ------------------------------------");
		
		System.out.println("-------------------------- SubList Search ------------------------------------");
		
		System.out.println("-------------------------- With Other Collections ------------------------------------");
	
		Collections.sort(names, (a,b) -> a.compareTo(b));
		System.err.println(names);
	}

}
