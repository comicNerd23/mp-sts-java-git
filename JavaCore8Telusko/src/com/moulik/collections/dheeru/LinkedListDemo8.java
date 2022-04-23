package com.moulik.collections.dheeru;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList is a fundamental data structure in which elements are stored in nodes. Each node has an element and a 
 * pointer to the next element. It is good for adding and removing elements quickly but searching can be expensive.
 * 
 * Java uses doubly linked list internally. Linked List are popular with Java interviewers.
 * 
 * 	class Node {
 * 		int data;
 * 		Node next;
 * 	}
 * 	class LinkedList {
 * 		Node head = new Node();
 * 		void add(int data) {
 * 			Node newNode = new Node(data);
 * 			newNode.next = head.next();
 * 			head.next = newNode();
 * 		}
 * 	}
 * 
 * A doubly linked list is one in which there are two pointers next and prev to point to next and previous element of a
 * node respectively. A doubly LL in which we have HEAD pointing to first and last nodes is useful to make an 
 * implementation of deque.
 * 
 * 	1. Create new node
 * 	2. Set outgoing links
 * 		newNode.next = head;
 * 		newNode.prev = head.prev;
 * 	3. Set incoming links
 * 		newNode.next.prev = newNode;
 * 		newNode.prev.next = newNode;
 * 
 * Typical use-cases
 * 	frequent add/remove elements during iterations
 * 		Consequently, it is also better for removeAll() and retainAll() because both of these methods remove elements
 * 		during iteration.
 * O(n)
 * 	get(i)				
 * 	add(i,e)
 * 	remove(i)
 * 	indexOf(Object)
 * 	lastIndexOf(Object)
 * 
 * get(i), add(i,e), remove(i) have n/2 complexity because they can either traverse from beg or from end whichever is 
 * closer.
 * 
 * So, in actuality, a Doubly LL is an implementation of List and Deque interfaces.
 * 	LIFO and FIFO operation in O(1)
 * However, ArrayDeque should be preferred because it is optimized for faster manipulations of first and last elements.
 * 	allows duplicates and nulls.
 * 
 * For DEMO just replace ArrayList with LinkedList in previous demo.
 * 	
 *
 */
public class LinkedListDemo8 {
	
private static void linkedListDemo() {
		
		//Basic Operations
		
		//Collection<Integer> list1 = new LinkedList<>(); has remove(Object o)
		List<Integer> list1 = new LinkedList<>();	// has remove(int index)
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(3);
		list1.add(null);
		System.out.println("list1: " + list1);
		
		list1.remove(3);
		System.out.println("list1: " + list1);
		list1.remove(3);
		System.out.println("list1: " + list1);
		
		list1.add(0, 10);
		System.out.println("list1: " + list1);
		list1.set(0, 9);
		System.out.println("list1: " + list1);
				
		// Bulk Operations
		System.out.println("Bulk Operations");
		Collection<Integer> list2 = new LinkedList<>();
		list2.add(9);
		list2.add(3);
		
		list1.removeAll(list2);
		System.out.println("list1: " + list1);
		
		list2.add(1);
		
		list1.retainAll(list2);
		System.out.println("list1: " + list1);
		
		list1.addAll(list2);
		System.out.println("list1: " + list1);
		
		System.out.println("list1.set(2, 2): " + list1.set(2, 2));
		
		
		// Search
		System.out.println("Search Operations");
		System.out.println("list1.contains(1): " + list1.contains(1));
		System.out.println("list1.indexOf(1): " + list1.indexOf(1));
		System.out.println("list1.lastIndexOf(1): " + list1.lastIndexOf(1));		
		System.out.println("list1: " + list1);
		
		
		// Range-view: subList (new list is backed by original)
		System.out.println("Range-view Operations");
		List<Integer> list3 = list1.subList(2, 3);
		list3.set(0, 6);
		System.out.println("list1: " + list1);
		list3.add(0, 7);
		System.out.println("list1: " + list1);
		list1.set(2, 8);
		System.out.println("list3: " + list3);
		//list1.add(0, 8);
		//System.out.println("list3: " + list3);
		System.out.println("list1: " + list1);
		System.out.println("list1.get(4): " + list1.get(4));
		
		//list1.remove(5); //Added just to test how remove method works: remove(Object) or remove(index).
		for (int element : list1) {
			System.out.println("element: " + element);
			
			// Generates ConcurrentModificationException
			if (element == 9) {
				list1.remove(Integer.valueOf(element)); // valueOf is used due to its caching
			}
		}
		
	}
	
	public static void main(String[] args) {
		linkedListDemo();		
	}

}
