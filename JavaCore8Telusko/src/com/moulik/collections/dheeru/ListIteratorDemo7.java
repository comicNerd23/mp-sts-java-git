package com.moulik.collections.dheeru;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

/**
 * ListIterator<E> extends Iterator<E> is an iterator which is used to traverse the elements of a list bidirectionally.
 * 
 * 	void add(E e)
 * 	void set(E e)
 *  void remove()
 *  								---- bidirectional access methods ----
 *  boolean hasNext()
 *  boolean hasPrevious()
 *  E next()
 *  E previous()
 *  int nextIndex()
 *  int previousIndex()
 *  
 * ListIterator can be used with an software installation where we have next and back buttons.
 *  
 * Cursor Position
 * 	
 * 		|	0	|	1	|	2	|									|	n-1	|
 * 		
 * 		^		^		^		^									^		^
 * 		|		|		|		|									|		|
 * 
 * With listIterator, there is no concept of current elements as the position of cursor is between two elements.
 *
 */
public class ListIteratorDemo7 {
	
	static void listIteratorDemo() {
		  System.out.println("\n\nInside listIteratorDemo ...");
	      List<String> list = new ArrayList<>();
	      list.add("a");
	      list.add("b");
	      list.add("c");
		  	  
	      System.out.println("\nDisplaying current elements ... ");
	      for (ListIterator<String> iterator = list.listIterator(); iterator.hasNext();) {
	          System.out.println("iterator.nextIndex: " + iterator.nextIndex() + ", iterator.next: " + iterator.next());	  
	      }
	      
	      System.out.println("\nDemonstrating add, remove, and set operations ... ");
	      for (ListIterator iterator = list.listIterator(); iterator.hasNext();) {
	          System.out.println("iterator.nextIndex: " + iterator.nextIndex() + ", iterator.next: " + iterator.next());
			  if (iterator.nextIndex() == 1) {
				  System.out.println("*** Adding test at index 1");
				  iterator.add("test");
				  System.out.println("iterator.nextIndex: " + iterator.nextIndex() + ", iterator.next: " + iterator.next());
				  
				  System.out.println("Removing test that was added at index 1");
				  iterator.previous(); // "b"
				  iterator.previous(); // "test"				  
				  iterator.remove();   // remove "test"
				  
				  // Uncommenting below line gives an IllegalStateException as 
				  // set should be preceded by next/previous/set
				  //iterator.set("test");
				  System.out.println("iterator.nextIndex: " + iterator.nextIndex() + ", iterator.next: " + iterator.next());
				  System.out.println("Setting element at index 1 as test");
				  iterator.set("test");
				  System.out.println("Setting element at index 1 as test1 to show that two set operations can be invoked sequentially");
				  iterator.set("test1");
			 }  	  
	      }	 
	      
	      System.out.println("\nDisplaying current elements ... ");
	      for (ListIterator iterator = list.listIterator(); iterator.hasNext();) {
	          System.out.println("iterator.nextIndex: " + iterator.nextIndex() + ", iterator.next: " + iterator.next());	  
	      }
	  }
	
	public static void main(String[] args) {
		// List<Integer> list1 = arrayListDemo();
		// iteratorDemo(list1);
		listIteratorDemo();
	}
}
