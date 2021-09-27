package com.moulik.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 	The concurrent API supplies a feature called an executor that initiates and controls the execution of threads.
 * 
 * 	At the core of an executor is the Executor interface. It defines the following method: void execute(Runnable thread)
 * 	The thread specified by thread is executed. Thus, execute( ) starts the specified thread.
 * 	
 * 	The ExecutorService interface extends Executor by adding methods that help manage and control the execution of threads. ( shutdown( ) )
 * 
 *  A thread pool provides a set of threads that is used to execute various tasks.
 *  Instead of each task using its own thread, the threads in the pool are used. This reduces the overhead associated with creating many separate threads. 
 *  Although you can use ThreadPoolExecutor and ScheduledThreadPoolExecutor directly, most often you will want to obtain an executor by calling one of the static
 *  factory methods defined by the Executors utility class. Here are some examples: 
 *  	static ExecutorService newCachedThreadPool( ) : creates a thread pool that adds threads as needed but reuses threads if possible
 *  	static ExecutorService newFixedThreadPool(int numThreads) : creates a thread pool that consists of a specified number of threads
 *  	static ScheduledExecutorService newScheduledThreadPool(int numThreads) : creates a thread pool that supports thread scheduling
 *  
 *  Each returns a reference to an ExecutorService that can be used to manage the pool.
 *
 */
public class ThreadPoolDemo {

	public static void main(String[] args) {

		CountDownLatch cdl1 = new CountDownLatch(5);
		CountDownLatch cdl2 = new CountDownLatch(5);
		CountDownLatch cdl3 = new CountDownLatch(5);
		CountDownLatch cdl4 = new CountDownLatch(5);
		ExecutorService ex = Executors.newFixedThreadPool(2);
		
		System.out.println("Starting");
		
		ex.execute(new MyThread1(cdl1, "A"));
		ex.execute(new MyThread1(cdl2, "B"));
		ex.execute(new MyThread1(cdl3, "C"));
		ex.execute(new MyThread1(cdl4, "D"));
		
		try {
			cdl1.await();
			cdl2.await();
			cdl3.await();
			cdl4.await();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		ex.shutdown();
		System.out.println("Done");
	}

}
class MyThread1 implements Runnable {
	
	String name;
	CountDownLatch cdl;

	public MyThread1(CountDownLatch c, String n) {
		name = n;
		cdl = c;
	}

	@Override
	public void run() {
		for(int i=0 ;i < 5; i++) {
			System.out.println("name:"+i);
			cdl.countDown();
		}
	}
	
}
