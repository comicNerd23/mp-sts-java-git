package com.moulik.collections;

import java.util.Arrays;

/**	123-131
 * Arrays is a class in Java which provides many utility methods for working with arrays.
 * These methods help bridge the gap between Collections and Arrays
 *
 *	1. Sorting (1)
 * 		void	sort(T[] array)		parallelSort(T[] array)
 *
 *	2. Convenience List/Stream from Array (2)
 *		List<T> 	asList(T... array)
 *		Stream<T>	stream(T[] array)
 *
 *	3. RoutineDataManipulation (3)
 *		T[]		copyOf(T[] originalArray, int newLength) 				copyOfRange(T[] originalArray, int from, int toExclusive)
 *	 	void	fill(T[] array, T elem)
 *		void	setAll(T[] array, IntFunction<? extends T> generator)	parallelSetAll(T[] array, IntFunction<? extends T> generator)
 *		
 *	4. Searching (1)
 *		int 	binarySearch(T[] array, T elem)
 *
 *	5. Object methods (3)
 *	 	boolean equals(T[] array1, T[] array2)					deepEquals(T[] array1, T[] array2)
 *		String 	toString(T[] array)								deepToString(T[] array)
 *		int 	hashCode(T[] array)								deepHashCode(T[] array)
 *
 *	6. Comparing lexicographically	(1)
 *		int		compare(T[] array1, T[] array2)					compareUnsigned(T[] array1, T[] array2)
 *
 *	7. Iterating
 *		SplitIterator<T> splitIterator(T[] array)
 *	
 *		
 */
public class ArraysDemo {

	public static void main(String[] args) {

		String[] names = {"Rahul","Anshul","Arun","Ankit","Moulik","Nakul"};
		int x = Arrays.binarySearch(names, 2, 5, "Moulik");
		System.out.println(x);
	}

}
