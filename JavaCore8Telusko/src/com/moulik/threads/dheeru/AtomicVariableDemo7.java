package com.moulik.threads.dheeru;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Atomic Variables provide another way to achieve both mutual exclusion (atomicity) and memory visibility and hence are 
 * a better alternative to volatile variables, without using locks. 
 * 
 * Synchronization can be expensive for a program especially for simple operations like increment, decrement etc. due to
 * thread suspension and resumption. By the way they are implemented, Atomic Variables do not use locks and hence do not 
 * have the overhead of thread suspension and resumption.
 * 
 * Let's see how AtomicVariable methods work:
 * 
 * 	public final long incrementAndGet() {
 * 		for( ;; ) {
 * 			long current = get();
 * 			long next = current + 1;
 * 			if( compareAndSet(current, next)) {		//returns true if the "next" was not incremented by any other thread
 * 													// set by some other thread and swaps the value in next to current
 * 				return next;
 * 			}
 * 		} 
 * 	}
 * 
 * This type of checking continuously if the variable was updated is much more efficient than thread suspension and 
 * resumption. Here there is no blocking of code, in contrast to Synchronization, where threads are blocked. Hence, these
 * are called non-blocking algorithms. 
 * The technique used here is called optimistic locking because here, we are computing the next variable and comparing the
 * current value with the optimistic assumption that no other thread has set the same value. When the optimistic 
 * assumption is true, the shared memory is updated with next value without locking. If the assumption is false, the work
 * is lost but still no locking involved. 
 * 
 * Atomic Variables Classes
 * 	Scalars: AtomicLong, AtomicInteger, AtomicBoolean, Atomic Reference
 * 	Arrays: AtomicLongArray, AtomicIntegerArray, AtomicReferenceArray
 * 	Field Updaters: AtomicLongFieldUpdater, AtomicIntegerFieldUpdater, AtomicReferenceFieldUpdater
 * 	Compound Variables: AtomicMarkableReference, AtomicStampedReference
 * 
 * Compared to Synchronization, Atomic variables are faster. But Atomic variables can only be used in certain scenarios 
 * where there are no shared variables (and hence locks).
 *
 */
public class AtomicVariableDemo7 {

	public static void main(String[] args) {

	}

}
class IdGenerator {
	private AtomicLong id;
	
	public long getId() {
		return id.incrementAndGet();
	}
}
