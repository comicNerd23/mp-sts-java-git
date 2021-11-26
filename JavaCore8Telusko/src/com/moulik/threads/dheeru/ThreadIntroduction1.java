package com.moulik.threads.dheeru;

import java.util.concurrent.TimeUnit;

/**
 * PreOS - 	Computers ran a single program, Used all scarce system resources, very inefficient
 * OS	 - 	Allowed multiple processes to run concurrently, Process gets its own memory, file handles, etc; Concurrency is 
 * 		   	achieved through multi-tasking (switching CPU from one process to another, does not imply parallelism), 
 * 			fast switching gives illusion of parallelism and Concurrency offers better CPU Utilization
 * 
 * Thread - A thread is a single sequential flow of control within a program. The real excitement surrounding threads is 
 * 			not about a single sequential thread. Rather, it's about the use of multiple threads running at the same time
 * 			and performing different tasks in a single program.
 * 			Threads share the process-wide resources eg memory, but they have their own PC, stack and local variables.
 * 			Light-weight process
 * 
 * Thread Benefits - 
 * 			Exploiting multiple processors
 * 			Allow loosely-coupled designs 
 * 			Better throughput even in single CPU machines (when blocking is involved)
 * 
 * Thread Types - Daemon Threads (Background Threads for tasks such as GC); Non-Daemon Threads (Created within application)
 * 			main thread: created by JVM to run main(), JVM will not terminate if atleast one non-daemon thread is running.
 * 
 * 
 * Consider a construction site where we have different workers. This construction site is the process and the different
 * workers are threads in the process. In Java, threads need "task" to execute just like workers need work. A thread in 
 * Java is java.lang.Thread instance and a task is a java.lang.Runnable instance.
 * 
 * Create a Task: Runnable task = new MyRunnable(); Runnable has exactly one method run()
 * Create a Thread with task: Thread thread = new Thread(task);
 * Start a Thread: thread.start() //Runnable state. Here new call stack with run() is created for thread.
 * 
 * 
 * Thread Scheduler is responsible for switching states for a thread. 
 * 		
 * 		Runnable <--------------------------> Running
 * 
 * 			|<----------- Blocked <----------|
 * 
 * Once the thread is run(), it goes into dead/terminated state. Calling the start() method again will cause it to 
 * throw IllegalThreadStateException.
 * So we have 5 states: NEW, RUNNABLE/READY TO RUN, RUNNING, BLOCKED, DEAD/TERMINATED
 * 
 * Note: We should not rely on Thread Scheduler for our program's correctness because it runs threads in a 
 * non-deterministic manner.
 * 
 * 
 * To put a thread to sleep, we can call the Thread.sleep(long ms). This will put the current thread to sleep.
 * Another way to put current thread to sleep is using TimeUnit.Hours/Minutes/...sleep(units)
 */
public class ThreadIntroduction1 {
	
	public static void main(String[] args) {
		
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.start();
		
		/* thread.start(); //Once the thread has run to completion, it goes into DEAD/TERMINATED state. Calling the 
		 * start() now will give an IllegalThreadStateException
		 */
		System.out.println("Inside main() ");
		
		try {
			//Thread.sleep(3000);
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("Inside run");
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
