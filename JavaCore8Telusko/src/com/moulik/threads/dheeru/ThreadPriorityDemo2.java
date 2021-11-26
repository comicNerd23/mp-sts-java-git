package com.moulik.threads.dheeru;

/**
 * Thread.currentThread() 	: gives the current thread
 * thread.setName()			: used to set the name of the thread
 * thread.setPriority()		: used to set the priority of the thread
 * thread.start()			: used to start the thread and execute the run method. If a run() is called to run directly,
 * 							then, a new thread is not created.
 * thread.yield()			: used to give a hint to the scheduler that the current thread is willing to yield its current
 * 							use of a processor. The scheduler is free to ignore this hint. It is rarely appropriate to
 * 							use this method.
 * thread.join()			: suspends other threads to wait until this thread completes execution and dies.
 */
public class ThreadPriorityDemo2 {

	public static void main(String[] args) {

		System.out.println("Thread.currentThread():"+Thread.currentThread());
		
		Thread thread1 = new Thread(new EmailCampaign());
		Thread thread2 = new Thread(new DataAggregator());
		
		thread1.setName("EmailCampaign");
		thread2.setName("DataAggregator");
		
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(Thread.MIN_PRIORITY);
		
		thread1.start();
		thread2.start();
		
		/*
		 * try { thread1.join(1); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */

	}

}
class EmailCampaign implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Thread name:"+Thread.currentThread().getName());
			if(i == 5) {
				Thread.currentThread().yield();
			}
		}
		
	}
	
}
class DataAggregator implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println("Thread name:" + Thread.currentThread().getName());
			if (i == 5) {
				Thread.currentThread().yield();
			}
		}

	}
}
