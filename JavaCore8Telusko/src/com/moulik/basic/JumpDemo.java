package com.moulik.basic;

public class JumpDemo {

	public static void main(String[] args) {

		//continue will skip that current iteration
		for(int i=0; i<10; i++) {
			if(i==7) {
				continue;
			}
			System.out.println("i:"+i);
		}
		//break will skip all after the current iteration
		for(int i=0; i<10; i++) {
			if(i==7) {
				continue;
			}
			System.out.println("i:"+i);
		}
	}

}
