package com.moulik.jvm;

/**
 * We know that as objects are created by using the new keyword, JVM determines the amount of heap memory needed for 
 * storing that object and allocates it. But as more and more objects are created, eventually we will run out of memory
 * and get errors like OutOfMemoryError. Hence, there should be a way to release memory when objects are no longer
 * required. This is automatically taken care in Java by the Garbage Collector. It mostly works on heap memory.
 * 
 * Explicit Memory Management
 * 	In C and C++, we have to explicitly allocate and free memory. If done right, it can make efficient applications. But,
 * on the other hand, if done incorrectly, it can cause program crashes. That means, memory is corrupted in some way.
 * 
 * Memory Corruption Errors
 * 	1. Memory Leak: when unused object are never freed.
 * 	2. Dangling Reference: reference to deallocated location
 * 
 * One way to avoid such memory corruption errors is to restrict programmers from manipulating memory. Java achieves this
 * through Automatic Memory Management. It does this using a GC.
 * GC reclaims memory occupied by dead object. This ensures there are no memory leaks. 
 * never reclaim referenced objects.
 * 
 * Abandoned Object:
 * Not referencing an object by any ref-variable qualifies that object as an abandoned object, making it eligible for GC.
 * An object can become abandoned in following ways:
 * 1. Going out of scope: When a method finishes execution, the object inside it becomes out-of-scope
 * 		void go() {
 * 			Book b = new Book();
 * 		}
 * 2. Assigning new object
 * 		Book b = new Book();
 * 		b = new Book();
 * 3. Assigning null
 * 		Book b = new Book();
 * 		b = null;
 * 
 * Note that even an java.lang.Class object will be eligible for GC if there are no references pointing to it.
 * 
 * GC Specifics:
 * 	1. Built-in or add-on
 * 	2. runs in background (as a low-priority thread, so it is always alive)
 * 	3. No guarantee when GC runs. (It usually runs when there is shortage of memory, but the exact timing is unpredictable)
 * 	We can give a hint to JVM to run GC by System.gc() or Runtime.getRuntime().gc(). JVM may ignore the signal though.
 * 	4. Each run of GC is called GC cycle and is pretty task-intensive and heavy and Can cause pauses (stop-the-world) in 
 * 	application
 * 
 * 
 *
 */
public class GarbageCollectionIntroduction10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
