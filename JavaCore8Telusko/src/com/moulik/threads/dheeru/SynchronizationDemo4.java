package com.moulik.threads.dheeru;

/**
 * To make a method as a single atomic unit, we can use Java's built-in locking mechanism called Synchronization.
 * The goal of synchronization is to protect critical (shared mutable) data. 
 * 
 * Synchronized block has 2 parts: 
 * 	1. Lock (object reference): (aka Intrinsic lock or Monitor lock)
 * 	2. Code that needs to be guarded by the lock.
 * 
 * 	public void foo() {
 * 		nonCriticalStuff;
 * 		synchronized(lock) {
 * 			criticalStatement1;
 * 			criticalStatement2;
 *		}
 * 		nonCriticalStuff;
 * 	}
 *
 *	Locking Mechanism: Every object has a single lock.
 *	1. A thread acquires a lock automatically when it enters a synchronized block
 *	2. Thread releases the lock when it exits a synchronized block or due to exception
 *	3. Atmost one thread can acquire an object's lock
 *	4. If a lock is unavailable, then thread goes into blocked state. When many threads are in blocked state, TS decides
 *	(non-deterministic) which lucky thread will acquire the lock once it is available.
 *	
 *	Synchronized Method are nothing but a shorthand for synchronized block on the method. Here lock is simply the object
 *	on which the method is invoked. 
 *
 *	1. Locks are per object and not per method. That means, if a thread has entered an object's synchronized method, that
 *	is, it has acquired an object's lock, then it cannot enter any of the object's other synch-methods or blocks.
 *	2. There is no restriction on unsync-methods.
 *	3. Static synch-methods use Class object as the lock. That means, every object has one lock and a class has one lock.
 *
 * 
 * 	Coordinating access to a variable
 * 	1. Synchronize everywhere a variable is used.
 * 	2. Guard same shared mutable variable with the same lock.
 * 			Synchronization = Mutual Exclusion + Reliable Thread Communication
 * 
 * 	So in the previous example class RaceConditionDemo, to make it thread-safe, just make the method synchronized. In this
 * 	case, the lock would be on the object. 
 */
public class SynchronizationDemo4 {

	public static void main(String[] args) {

	}

}
