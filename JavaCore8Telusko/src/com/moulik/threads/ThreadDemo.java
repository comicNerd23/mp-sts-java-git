package com.moulik.threads;


/**
 * There are 2 ways of multitasking:
 * Process-based: that allows you to run two or more programs simultaneously. Here a program is the smallest piece of code that is dispatched by the scheduler.
 * Thread-based: that allows you run two or more threads simultaneously. Here a thread is the smallest piece of dispatchable code.
 * 
 * Multitasking threads require less overhead than multitasking processes. Processes are heavyweight tasks that require their own separate address spaces. 
 * Interprocess communication is expensive and limited. Context switching from one process to another is also costly. Threads, on the other hand, are lighter 
 * weight. They share the same address space and cooperatively share the same heavyweight process. Interthread communication is inexpensive, and context 
 * switching from one thread to the next is lower in cost. 
 * Multithreading enables you to write efficient programs that make maximum use of the processing power available in the system. 
 * 
 * Thread is a unit of a process.
 * Multi-Threads are used:
 * 1. To use complete power of multi-core CPU
 * 2. AsyncTask in Android
 * 3. Web Applications: When a request is sent from client to server, a servlet will create a thread. So multiple requests create multiple threads.
 * 4. Game development
 *
 * Threads exist in various states:
 * running, ready to run (as soon as it gets CPU Time), suspended (temporarily halts its activity), 
 * resumed(from its suspended state), blocked(when waiting for a resource), terminated (which halts its execution completely)
 * 
 * In every java code, a main thread runs
 * There are 2 ways to create threads: Extending Thread and Implementing Runnable
 * 
 */
public class ThreadDemo {

	static int[] arr = {1,2,3,4,5};
	public static void main(String[] args) {

		
		MyThread thread1 = new MyThread();
		thread1.start();
		System.out.println("****************");
		for(int a: arr) {
			System.out.println("main:"+a);
		}
		System.out.println("***************************");
	}

}

/* This thread multiplies each element of the array by 2 */
class MyThread extends Thread {

	public void run() {
		for(int i=0; i<ThreadDemo.arr.length; i++) {
			System.out.println("run1:"+ThreadDemo.arr[i]);
			ThreadDemo.arr[i] = ThreadDemo.arr[i]*2;
			System.out.println("run2:"+ThreadDemo.arr[i]);
		}
	}
}
