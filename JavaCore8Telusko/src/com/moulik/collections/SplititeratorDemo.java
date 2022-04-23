package com.moulik.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
 * java.util.SplitIterator
 * 	For supporting parallel execution in Java 8 Stream API, Spliterator interface is used. Spliterator trySplit method 
 * 	returns a new Spliterator that manages a subset of the elements of the original Spliterator.
 * 	It is similar to Iterators in the sense that it cycles through a sequence of elements. However, the techniques
 * 	required to use it differ.
 *	It provides support for parallel iteration of portions of the sequence
 *	Even without using parallel executions you would want to use it because it provides a streamlined approach 
 *	that combines the hasNext() and next() into one method
 *
 *
 *				int						characteristics
 *	default		boolean					hasCharacteristics(int val)
 *	
 *				long					estimateSize()
 *				long					getExactSizeIfKnown()
 *
 *	default		Comparator<? super T>	getComparator()
 *
 *				boolean					tryAdvance(Consumer<? super T> action)
 *				SplitIterator<T>		trySplit()
 *	default		void					forEachRemaining(Consumer<? super T> action)
 */
public class SplititeratorDemo {

	public static void main(String[] args) {
		
		System.out.println("--- spliterator.tryAdvance() ---");
		
		List<Double> vals = List.of(1.0, 2.0, 3.0, 4.0, 5.0);
		
		Spliterator<Double> splitr = vals.spliterator();
		
		while( splitr.tryAdvance( System.out :: println) );
		
		List<Double> sqrts = new ArrayList<>();
		
		while ( splitr.tryAdvance( n -> sqrts.add(Math.sqrt(n)) ) );
		
		System.out.println("--- Printing using forEachRemaining --- ");
		sqrts.spliterator().forEachRemaining( System.out :: println );
		
		splitr.forEachRemaining( System.out :: println );
		
		
		System.out.println("--- spliterator.trySplit() ---");
		
	}

}
