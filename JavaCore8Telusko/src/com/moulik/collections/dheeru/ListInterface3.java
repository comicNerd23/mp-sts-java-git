package com.moulik.collections.dheeru;

/**
 * List Interface:
 * 1. Useful when sequence/positioning matters
 * 2. Models resizeable linear array with indexed access
 * 3. Zero-based
 * 
 * Positional Methods:
 * 		
 *   			E					get(int index)
 * 				boolean 			add(E obj), add(int index, E element)				//Optional
 * 				E					set(int index, E element)							//Optional
 * 				boolean 			remove(E obj)										//Optional
 * 				boolean				addAll(int index, Collection<? extends E> col)		//Optional
 * 
 * Search Methods:
 * 				int					indexOf(Object o)								//first occurrence, not found -1
 * 				int 				lastIndexOf(Object o)							//last occurrence, not found -1
 * 
 * Iteration Methods:
 * 				ListIterator<E> 	listIterator()
 * 				ListIterator<E> 	listIterator(int index)
 * 
 * Range-View:
 *				List<E>				subList(int start, int end)
 *				~returned list is backed by original list
 *
 */
public class ListInterface3 {

}
