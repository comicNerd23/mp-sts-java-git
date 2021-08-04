package com.moulik.threads;

//Here we learn about the name, priority of the thread, Thread.currentThread(), join(), isAlive()
public class ThreadDemo4JoinIsAlive {

	public static void main(String[] args) throws InterruptedException {


		Thread t1 = new Thread(() -> {
			for(int i=0; i<5; i++) {
				System.out.println("Hi");
				//System.out.println("Priority of this thread1"+Thread.currentThread().getPriority());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Hi Thread");		//Setting the name of the thread 1 using Thread overloaded Constructor
		Thread t2 = new Thread(() -> {
			for(int i=0; i<5; i++) {
				System.out.println("Hello");
				//System.out.println("Priority of this thread2"+Thread.currentThread().getPriority());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Hello Thread");		//Setting the name of the thread 2 using Thread overloaded Constructor

		t1.setPriority(Thread.MIN_PRIORITY);	//To set the priority. Can take values 1(MAX_PRIORITY) to 10(MIN_PRIORITY)
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		Thread.sleep(500);
		t2.start();
		
		//System.out.println("Bye"); If we execute this code now, it will cause the main thread to execute while t1 and t2 are waiting.
		//To mitigate this, we use .join()
		
		// isAlive() lets us know if a thread is alive or not
		if (t1.isAlive()) {
			System.out.println("T1 is alive");
		}
		if (t2.isAlive()) {
			System.out.println("T2 is alive");
		}
		
		t1.join();
		t2.join();
		
		System.out.println("Bye");//Now when we execute this code here, it will join t1 and t2 threads, ie, it will execute those first before main thread.
		
		if(t1.isAlive()) {
			System.out.println("T1 is alive still");
		}
		if(t2.isAlive()) {
			System.out.println("T2 is alive still");
		}
	}

}
