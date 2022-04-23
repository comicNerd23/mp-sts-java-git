package com.moulik.collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 	Deque declares the behavior of a double-ended queue
 * 	
 * 				void					addFirst()		to Head; Throws IllegalStateException if Deque is full
 * 				void					addLast()		to Tail; Throws IllegalStateException if Deque is full
 * 				boolean					offerFirst()	to Head; returns false if Deque is full
 * 				boolean					offerLast()		to Tail; returns false if Deque is full
 * 
 * 				E						getFirst()		doesn't remove; Throws NoSuchElementException if Deque is empty
 * 				E						getLast()		doesn't remove; Throws NoSuchElementException if Deque is empty
 * 				E						peekFirst()		doesn't remove; returns null if Deque is empty
 * 				E						peekLast()		doesn't remove; returns null if Deque is empty
 * 
 * 				E						pollFirst()		removes; returns null if Deque is empty
 * 				E						pollLast()		removes; returns null if Deque is empty
 * 				E						removeFirst()	removes; Throws NoSuchElementException if Deque is empty
 * 				E						removeLast()	removes; Throws NoSuchElementException if Deque is empty
 * 				boolean					removeFirstOccurence()	removes; returns false if element not found
 * 				boolean					removeLastOccurence()	removes; returns false if element not found
 * 
 *				void					push(E obj)
 *				E						pop()
 *
 *				Iterator<E>				descendingIterator()
 *
 */
public class DequeDemo {

	public static void main(String[] args) {
		
		Deque<String> deque = new ArrayDeque<>();
		deque.addFirst("Harry");
		deque.addLast("Terry");
		deque.add("Ron");
		deque.offerFirst("Hermione");
		
		deque.forEach(System.out::println);

	}

}
