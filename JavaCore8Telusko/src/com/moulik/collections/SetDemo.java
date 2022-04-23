package com.moulik.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Set is a collection which does not allow duplicate elements

/**
 * 	Set (6-2-5-2-4 = 19)
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
 *	default		Stream<E>			stream()									inherited
 *	default		Stream<E>			parallelStream()							inherited
 *	default		boolean				removeIf(Predicate<? super E> predicate)	inherited
 *	default		SplitIterator<E> 	splitIterator()
 *
 */
public class SetDemo {

	public static void main(String[] args) {

		Set<Integer> newSet = new HashSet<>();
		newSet.add(6);
		newSet.add(9);
		newSet.add(11);
		
		newSet.stream()
		.forEach(x->System.out.println(x));
		
		//ToArray(arr)
		Integer[] arrayFromSet = new Integer[newSet.size()];
		arrayFromSet = newSet.toArray(arrayFromSet);
		
		System.out.println("size:"+arrayFromSet.length);
		
		//ToArray()
        Object[] arr = newSet.toArray();
  
        System.out.println("Elements of ArrayList"
                           + " as Array: "
                           + Arrays.toString(arr));
	}

}
