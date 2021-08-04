package com.moulik.threads;
//As you saw in ThreadDemo2, a lot of code is boilerplate. To reduce this, we can use lambda expressions.
public class ThreadDemo3 {

	public static void main(String[] args) throws Exception {

		Thread t1 = new Thread(() -> {
			for(int i=0; i<5; i++) {
				System.out.println("Hi");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(() -> {
			for(int i=0; i<5; i++) {
				System.out.println("Hello");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		//Here the main thread has spawned two threads. When we start a thread, it starts executing. Only when this thread has to sleep, will the next thread
		//start executing. That's what is happening here in below three lines. 
		//t1 starts and main thread waits in the meantime. t1 sleeps for 1 sec. While t1 is waiting for 1 second, main thread gets control back.
		//main thread executes next line code, that is wait for 500ms. Then it encounters next line, start t2 and main thread waits.
		//t2 starts executing and sleeps for 1 sec. Now, t1 is sleeping till 1 sec is over and t2 is sleeping till 1 sec is over. main thread gets control
		// back and starts executing. If there was still more code in main thread it would be executing now. 
		//Since main thread work is done, control goes back to t1. t1 executes, then waits for 1 sec. Then if t2 is done, it executes and waits for 1 sec.
		//This behaviour continues. That is why, the behavior of threads is random. To bring some uniformity in threads, we use certain operations like join etc.
		t1.start();
		Thread.sleep(500);
		t2.start();
		
	}

}
