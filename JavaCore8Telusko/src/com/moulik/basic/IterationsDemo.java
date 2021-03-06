package com.moulik.basic;

public class IterationsDemo {
	//while, do-while, for, for-each
	public static void main(String[] args) {

		//while loop: When we don't know the ending point of the loop
		int x = 9;
		while(x==9) { //This should be boolean
			System.out.println("While Loop");
			x++;
		}
		
		//do-while loop: When we don't know the ending point of the loop
		//but we want the statements to execute once
		int m = 0;
		do {
			System.out.println("Do while loop");
			m++;
		} while(m<10);
		
		//For loop: When we know the starting and ending point of the loop
		for(int i = 0; i<10; i++) {
			System.out.println("For Loop");
		}
		
		
		// Nested Loop
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 4; i++) {
				System.out.print("* ");
			}
			System.out.println("");
		}

		//For each loop: used with Arrays and Collections
		//In ArrayDemo
		
	}

}
