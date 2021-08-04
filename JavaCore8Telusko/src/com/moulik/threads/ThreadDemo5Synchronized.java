package com.moulik.threads;

//Synchronized keyword is used to make a method thread-safe. It makes a thread wait while that method is being accessed by another thread.
public class ThreadDemo5Synchronized {

	public static void main(String[] args) throws InterruptedException {

		Counter c = new Counter();
		
		//Thread calls increment method 1000 times
		Thread t1 = new Thread(() -> {
			for(int i=0; i<1000; i++) {
				c.increment();
			}
		});
		//Thread calls increment method 1000 times
		Thread t2 = new Thread(() -> {
			for(int i=0; i<1000; i++) {
				c.increment();
			}
		});
		//Started both threads
		t1.start();
		t2.start();
		//Joined both threads so that they finish the execution before the main thread
		t1.join();
		t2.join();
		
		System.out.println(c.count); //Count will be 2000 only if we have the method synchronized
	}

}
class Counter {
	
	int count;
	
	public synchronized void increment() {
		count++;
	}
}