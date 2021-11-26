package com.moulik.threads.dheeru;

/**
 * Explicit Locks are a way to write your own locks. This class was introduced in Java 5. Because intrinsic locks cannot 
 * be interrupted, we have to use explicit locks.
 * 
 * import java.util.concurrent.locks.*;
 * 
 * 	Lock lock = new ReentrantLock();
 * 	...
 * 	lock.lock();		//to acquire a lock
 * 	try() {
 * 		//Critical Stuff
 * 	} finally {
 * 		lock.unlock();	//To release the lock. If an unlock is not done in finally, then the lock will never be released 
 * 						//in case of an exception, and that can be dangerous as there might be other threads waiting for
 * 						//the lock to be released.
 * 
 * 	}
 * 
 *  public interface Lock {
 *  
 *  	void lock();
 *  	void lockInterruptibly() throws InterruptedException;
 *  	boolean tryLock();
 *  	boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
 *  	void unlock();
 *  	Condition newCondition();	//replacement of wait(), notify(). Instead has methods like await() and signal()
 *  
 *  }
 *  
 *  Memory Visibility must be same as with intrinsic locks. This is the java spec.
 *  
 *  Fairness:
 *  	ReentrantLock()
 *  	ReentrantLock(boolean fair)		//fair = true means FIFO. false (default) means cut the queue (for performance)
 *  
 *  Reentrant OR Intrinsic? Which locks to use?
 *  Use intrinsic because:
 *  	1. familiar and compact
 *  	2. automatically release locks
 *  	3. performance : almost as good as Reentrant
 *  Use reentrant because:
 *  	1. of additional features like thread interruption when waiting for a lock.
 *  
 *  Reentrant Lock also hold mutual exclusion lock (similar to intrinsic). That is, only one thread can hold a lock at a 
 *  time. But, this is a conservative locking strategy. At one time, a shared variable can be accessed by multiple readers
 *  or a single writer, but not both. To mitigate this, use ReentrantReadWriteLock instead of ReentrantLock
 *
 */
public class ExplicitLocksDemo12 {

	public static void main(String[] args) {

	}

}
