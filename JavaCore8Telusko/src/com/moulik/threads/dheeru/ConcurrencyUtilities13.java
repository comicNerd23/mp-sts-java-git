package com.moulik.threads.dheeru;

/**
 * Earlier we achieved Thread Cooperation through wait() and notify() but there was a low-level handshaking going on.
 * One thing which was not specified earlier for synchronized blocks is the code can be context-switched arbitrarily by
 * the TS, ie, One synchronized class/block of code can be moved from Running to Runnable state and other can be moved 
 * to Running state.
 * 
 * Effective Java recommends using Concurrency Utilities (introduced in Java 5) in place of wait() and notify().
 * They allow simpler and implicit Thread Cooperation without any low-level handshaking.
 * 			Executor framework (ExecutorService, Callable, Future)
 * 			Synchronizers (eg CountDownLatch)
 * 			Concurrent Collections (eg BlockingQueue)
 *
 */
public class ConcurrencyUtilities13 {

	public static void main(String[] args) {

	}

}
