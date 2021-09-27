package com.moulik.java8;

public class Test {

	public static void main(String[] args) {
		
		Thread a = new MyThread() {
			public void run() {
				System.out.print(" foo");
			}
		};
		a.start();
	}

}
class MyThread extends Thread {
	MyThread() {
		System.out.print(" MyThread");
	}
	public void run() {
		System.out.print(" bar");
	}
	public void run(String s) {
		System.out.print(" bax");
	}
}
