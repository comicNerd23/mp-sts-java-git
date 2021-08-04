package com.moulik.basic;

public class OperatorsDemo {
	
	/*
	 * Arithmetic +,-,*,/,%
	 * Bitwise	<< >>
	 * Relational
	 * Logical	
	 * 
	 */
	public static void main(String[] args) {
		
		int a = 6;
		int b = 4;
		System.out.println(a+b);	//10
		System.out.println(a-b);	//2
		System.out.println(a*b);	//24
		System.out.println(a/b);	//1, because divide operation only saves the quotient
		System.out.println(a%b);	//2, this is mod operation which saves the remainder
		
		System.out.println((double)a/b);	//1.5, because it casts a(6) to a(6.0) 
											//then, divides 6.0/4 and then returns a 
											// double value of 1.5, not int value
		
		
		//ShortHand
		
		a += b;		// This is equal to a = a + b
		System.out.println(a);	// Output will be 10
		
		a -= b;		// a = a-b
		a *= b;		// a = a*b
		a /= b;		// a = a/b
		a %= b;		// a = a%b
		
		System.out.println("************************************************");
		//Pre/Post Operators
		int m = 10;
		int n = 0;
		++n;			//This is equal to n = n + 1
		m = ++m;		//m = m+1	PreIncrement: First increment, then assignment
		System.out.println(m);	//11
		
		m = m++;		//m = m		PostIncrement: First assignment, then increment 
		System.out.println(m);	//11
		//m == 11, n == 1
		n = ++m;		//m == 12, n == 12
		n = m++;		//m == 13, n == 12
		System.out.println(m);
		System.out.println(n);
		
	}

}
