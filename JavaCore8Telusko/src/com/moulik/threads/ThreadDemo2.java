package com.moulik.threads;

public class ThreadDemo2 {

	public static void main(String[] args) throws Exception {
		Hi obj1 = new Hi();
		Hello obj2 = new Hello();
		//obj1.start(); This does not work with Runnable interface
		//obj2.start(); You have to create a thread object using the runnable interface
		Thread thread1 = new Thread(obj1);
		Thread thread2 = new Thread(obj2);
		thread1.start();
		Thread.sleep(500);
		thread2.start();
		
		
	}

}
class Hi implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Hi");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
class Hello implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
