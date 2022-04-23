package com.moulik.collections.dheeru;

/**
 * Sorting is a property to arrange a collection of elements in an order.
 * Strings are usually sorted in an alphabetical order. Even user-defined objects can be sorted.
 * 
 * SortedSet: (extends Set)
 *	//Range-view
 *	SortedSet<E> subSet(E fromElement, E toElement)
 *	SortedSet<E> headSet(E toElement)
 *	SortedSet<E> tailSet(E fromElement)
 *	
 *	//Endpoints
 *	E first()
 *	E last()
 *
 *	//Comparator Access
 *	Comparator<? super E> comparator(); //null is returned for natural ordering
 *
 *	default Spliterator<E> spliterator();
 *
 * The returned set from the range view methods is backed by the original set. Changes in the returned set will be 
 * reflected in the original set and vice-versa. Note, the returned set will throw an IllegalArgumentException if we
 * try to insert an element into that set and that element is outside the range of the returned set. 
 * 
 * NavigableSet: (extends SortedSet)
 *  
 *  //1. Closest Matches
 *  E floor(E)			greatest element <= E
 *  E ceiling(E)		least element >= E
 *  E higher(E)			least element > E
 *  E lower(E)			greatest element < E
 *  
 *  //2. Endpoints
 *  E pollFirst() and E pollLast()
 *  
 *  //3. Iterators
 *  Iterator<E> iterator and descendingIterator()
 *  
 *  NavigableSet<E> descendingSet()
 *  
 *  //4. Range-View
 *  NavigableSet<E> headSet(E toElement, boolean inclusive)
 *  NavigableSet<E> tailSet(E fromElement, boolean inclusive)
 *  NavigableSet<E> subSet(E fromElement, boolean lowIncluded, E toElement, boolean highIncluded)
 *
 */
public class SortedSetNavigableSetDemo14 {

}
