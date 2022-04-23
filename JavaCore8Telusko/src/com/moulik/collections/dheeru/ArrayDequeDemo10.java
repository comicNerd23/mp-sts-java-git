package com.moulik.collections.dheeru;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ArrayDeque is a resizable array implementation of Deque interface
 * 1. added in Java 6
 * 2. models FIFO and LIFO
 * 3. ArrayDeque() or ArrayDeque(int ) or ArrayDeque(Collection)
 * 4. Unlike LinkedList, ArrayDeque does NOT implement list interface, Does NOT allow nulls
 * 
 * Deque: prefer ArrayDeque over LinkedList
 * ~ JavaDoc says ArrayDeque is faster than LL
 * ~ One article proves ArrayDeque is 3X better than LL for long queues, because LL has node allocation overhead and 
 * 	 GC Cost
 * 
 * Can we use ArrayList as a FIFO Queue?
 * 		by using add and remove(0)
 * 1. Performance
 * 		remove(0) ~ shifts elements O(n)
 * 		gets bad with large number of elements
 * 		For 1000 elements, LL is 20x faster
 * 		ArrayDeque ~ is implemented using Circular Array ~ No element shifts ~ O(1) for adding/removing at both ends
 * 2. Intention
 * 		
 * Method complexities
 * 1. Most run in amortized constant time
 * 2. O(n)
 * 		remove(Object)
 * 		removeFirstOccurence()
 * 		removeLastOccurence()
 * 		contains
 *
 */
public class ArrayDequeDemo10 {
	
	private static void dequeTest() {
		System.out.println("\nInside dequeTest ...");
		
		// Queue - FIFO
		Deque<String> deque = new ArrayDeque<>();
		deque.add("walden");
		deque.add("harry potter");
		deque.add("head first java");
		
		System.out.println("\nPrinting Queue ...");
		System.out.println(deque.remove()); // removeFirst
		System.out.println(deque.remove());
		System.out.println(deque.remove());
		
		// Stack - LIFO
		deque.push("walden");
		deque.push("harry potter");
		deque.push("head first java");
		//deque.push(null);
		
		System.out.println("\nPrinting Stack ...");
		System.out.println(deque.pop()); 
		System.out.println(deque.pop());
		System.out.println(deque.pop());
	}
	
	public static void main(String[] args) {
		dequeTest();
	}

}
