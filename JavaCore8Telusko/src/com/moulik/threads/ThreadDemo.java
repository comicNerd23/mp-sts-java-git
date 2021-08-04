package com.moulik.threads;

//Thread is a unit of a process.
//Multi-Threads are used:
//1. To use complete power of multi-core CPU
//2. AsyncTask in Android
//3. Web Applications: When a request is sent from client to server, a servlet will create a thread. So multiple requests create multiple threads.
//4. Game development

//In every java code, a main thread runs
//There are 2 ways to create threads: Extending Thread and Implementing Runnable
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
//This thread multiplies each element of the array by 2
class MyThread extends Thread {

	public void run() {
		for(int i=0; i<ThreadDemo.arr.length; i++) {
			System.out.println("run1:"+ThreadDemo.arr[i]);
			ThreadDemo.arr[i] = ThreadDemo.arr[i]+10;
			System.out.println("run2:"+ThreadDemo.arr[i]);
		}
	}
}
