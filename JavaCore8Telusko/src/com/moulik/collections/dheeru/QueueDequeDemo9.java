package com.moulik.collections.dheeru;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Queue is a DS in which elements are saved in a line like structure where elements are added at the back (tail) and 
 * removed from the front (head).
 * 
 * 1. useful when manipulating head and tail
 * 2. tail - add, head - remove/retrieve
 * 3. models FIFO (First In First Out)
 * 4. Can have duplicates
 * 5. Can have nulls, but generally not supported (don't insert nulls even if possible)
 * 6. No indexed access
 * 
 * 				Throws Exception(IllegalState)		Returns special value
 * INSERT		add(e)								offer(e)		~false if not able to insert 
 * REMOVE		remove()							poll(e)			~null if queue is empty
 * INSPECT		element()							peel()			~null if queue is empty
 * 
 * 
 * Deque (pronounced deck) is a sub-interface of Queue which is short for Double-Ended Queue.
 * 1. Extends Queue
 * 2. Models FIFO and LIFO
 * 3. Deque implementation:
 * 		ArrayDeque
 * 		LinkedList
 * 		ConcurrentLinkedDeque
 * 		LinkedBlockingDeque
 * 
 * 	TAIL				----------------------->	HEAD
 * 	add(e)/offer(e)									remove/poll
 * 													element/peek
 * 	addLast(e)/offerLast(e)							addFirst(e)/offerFirst(e)
 * 	removeLast/pollLast								removeFirst/pollFirst
 * 	getLast/peekLast								getFirst/peekFirst
 * 
 * 													Stack (Java designers went with HEAD as top of LIFO)
 * 													push(e)	~ addFirst(e)
 * 													pop		~ removeFirst(e)
 * 
 * 								removeFirstOccurence(Object)
 * 								removeLastOccurence(Object)
 * 
 * 				Queue
 * 
 * 		Deque			BlockingQueue
 * 		
 * 			BlockingDeque
 * 		
 * 
 */
public class QueueDequeDemo9 {
	
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
		
		System.out.println("\nPrinting Stack ...");
		System.out.println(deque.pop()); 
		System.out.println(deque.pop());
		System.out.println(deque.pop());
	}
	
	public static void main(String[] args) {
		dequeTest();
	}

}
