package com.moulik.threads.dheeru;

import java.util.concurrent.TimeUnit;

/**
 * Java 5 Concurrency Utilities provides ways to handle two issues: Thread Cooperation and Thread Interruption.
 * 
 * Thread Interruption
 * So far, we have only looked at threads that terminate when they run to completion. But we may have scenarios where we
 * have to manually stop the threads. Eg for Slow Downloads, cancel operation, application shutdown.
 * 
 * Java doesn't allow forcibly stopping a thread. thread.stop() allows for forcibly stopping but it has been deprecated
 * since Java 5 along with suspend() and resume() because it does not allow the program to gracefully finish the thread.
 * Instead, Java provides Interruption which is a cooperative mechanism for requesting a thread to stop what it is doing.
 * 
 * Forcing a thread to stop can leave any shared objects in an inconsistent state. Instead a cooperative way would allow
 * the target thread to perform any cleanup operation before termination.
 * 
 * Every thread has a boolean interrupted status
 * interrupt(): sets interrupted status to true
 * 
 * Blocking methods like sleep() and wait() can clear interrupted status and also can throw InterruptedException
 * 
 * Note: There is no guarantee how quick a thread will be interrupted. But in practice, it happens quite fast.
 * 
 * If our program does not using blocking mechanisms, then we can use following methods to check the interrupted status
 * and terminate the program.
 * 
 * 	public void run() {
 * 		while( !Thread.currentThread().isInterrupted() ) {	//returns true if interrupted status is set to true.
 * 			...
 * 		}
 * 
 * 		OR
 * 		
 * 		while( !Thread.currentThread().interrupted() ) {	//returns true if interrupted status is set to true.
 * 															//clears interrupted status and return previous value.
 * 			...
 * 		}
 * 	}
 * 
 * interrupted() is the only method that can be used to reset the interrupted status.
 * InterruptedException is thrown when a thread is waiting, sleeping, or otherwise occupied, and the thread is 
 * interrupted, either before or during the activity
 * 
 * Threads blocked because of IO Streams are uninterruptible. WorkAround: to close the stream which throws exception and
 * we can catch that exception to then interrupt the thread.
 * Similarly, synchronized locks are uninterruptible. Workaround: use Explicit Locks instead.
 * NIO streams are interruptible. 
 *
 */
public class ThreadInterruptionDemo11 {

	public static void main(String[] args) {
		System.out.println("Main Thread started");
		Task1 task = new Task1();	//Check First program in ThreadIntroduction1
		Thread thread = new Thread(task);
		thread.start();
		
		System.out.println("Inside main() ");
		
		try {
			TimeUnit.SECONDS.sleep(3);
			
			thread.interrupt();	// we are calling to interrupt the thread (which is in blocked state for 9 seconds
								// due to sleep(9)) from the main thread after 3 seconds.
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
class Task1 implements Runnable {

	@Override
	public void run() {
		System.out.println("Inside run");
		
		try {
			TimeUnit.SECONDS.sleep(9);
		} catch (InterruptedException e) {
			System.out.println("Interrupted!!");
		}
		
		go();
	}

	private void go() {
		System.out.println("Inside go");
		more();
	}

	private void more() {
		System.out.println("Inside more");
		
	}
	
}
