package com.moulik.collections.dheeru;

import java.util.Collection;
import java.util.List;

/**
 * Collection Interface
 * 1. Collection of objects
 * 2. Polymorphically provides maximum generality
 * 3. Some allow duplicates (ArrayList) while other do not (HashSet).
 * 4. Some are ordered (TreeSet) while others are not (HashSet).
 * 5. AbstractCollection is the direct subclass.
 * 
 * This interface extends Iterable
 * 
 * Basic Operations:
 * 		 		int					size()
 * 				boolean 			isEmpty()
 * 				boolean 			contains(Object element)
 * 				boolean 			add(E obj)			//Optional
 * 				boolean 			remove(E obj)		//Optional
 * 				Iterator<E> 		iterator()
 *
 * Optional operation means there is no implementation defined here in the Collection interface and if you try to call
 * these methods, you will get UnsupportedOperationException.
 * 
 * Bulk Operations:
 * 				boolean				containsAll(Collection<?> c)
 * 				boolean				addAll(Collection<? extends E> c)	//Optional
 * 				boolean				removeAll(Collection<?> c)			//Optional
 *				boolean				retainAll(Collection<?> c)			//Optional
 *				void				clear()
 *
 * Array Operations: (act as bridge methods between collections and arrays)
 * 			 	Object[] 			toArray()
 * 				<T>	T[]				toArray(T array[])
 * 				//e.g String[] a = c.toArray(new String[0]);
 */
public class CollectionInterface2 {
	
	public static void main(String[] args) {
		Collection<Integer> numbers = List.of(1 ,3, 5, 7);
		numbers.add(9);
		System.out.println(numbers);
	}

}
