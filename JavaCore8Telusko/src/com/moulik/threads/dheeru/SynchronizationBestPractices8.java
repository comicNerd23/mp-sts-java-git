package com.moulik.threads.dheeru;


/**
 * 1. Synchronize everywhere a variable is accessed. Eg in BankAccount example, balance variable should be synchronized
 * 	  in both getBalance() and makeWithdrawal().
 * 2. Guard same shared mutable variable with the same lock. Eg in BankAccount example, synchronized on makeWithdrawal()
 * 	  and deposit() with synchronized block on String object instead of on BankAccount object will not have a 
 * 	  happens-before relationship on two different object and hence will have memory visibility issue.
 * 3. If a method modifies a static field, you must synchronize access to this field even if the method is typically used
 *    only by a single thread.
 * 4. Keep synchronized blocks small. Try to move time consuming activities out of synchronized blocks without affecting
 *    thread safety.
 * 5. Don't over-do. Avoid excessive synchronization.
 *			Costs:  Thread Suspension and resumption.
 *					Lock Acquisition and Release.
 *					Ensuring consistent memory visibility
 *					limits JVM's ability to optimize code execution
 *					Lost opportunities for parallelism in multi-core system.
 *	6. When not sure? Don't synchronize. But document not thread-safe.
 */
public class SynchronizationBestPractices8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
