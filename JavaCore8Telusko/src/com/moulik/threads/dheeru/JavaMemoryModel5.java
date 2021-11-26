package com.moulik.threads.dheeru;

/**
 * Java Memory Model is a part of Java Specification and is related to Multi-threading. 
 * 
 * Most of the modern computer systems use a model of "Multiprocessor with Shared Memory".
 * 	
 * Consider the Bank Account example where we John's thread runs on processor A and runs the makeWithdrawal() to 
 * completion and flushes the balance to cache and memory.
 * On Processor B, Anita's thread calls getBalance() and reads old balance from local cache. 
 * 
 * Memory Visibility Issue:
 * The visibility of writes to shared variables can be problematic because the value of a shared variable may be cached;
 * writing its value to main memory may be delayed. Consequently, another thread may read a stale value of the variable.
 * 
 * https://wiki.sei.cmu.edu/confluence/display/java/Concurrency%2C+Visibility%2C+and+Memory
 * 
 * So, Out-of-Order actions and Multi-Processor with shared memory setup can lead to lack of "Thread Communication"
 * which can lead to performance issues. 
 * 
 * Threads typically do their own stuff. 
 * Thread Communication on every write can be expensive. 
 * Thread Communication - needed only for shared mutable data. 
 * If there is shared mutable data, Then it is program's responsibility not JVM's.
 * 
 * 
 * makeWithDrawal() happens before the getBalance() and hence the two methods are shared by happens-before relationship.
 * For this relationship, we need to make sure of following rules: 
 * 1. Program Order
 * 2. Lock has got to be the same lock.
 * 3. Volatile Variable
 * 4. start()
 * 5. join()
 * 6. interrupt()
 * 7. Object.finalize()
 * 8. Transitivity
 * 
 * Thread Communication means different threads have a consistent view of the shared state.
 *
 */
public class JavaMemoryModel5 {

	public static void main(String[] args) {

	}

}
