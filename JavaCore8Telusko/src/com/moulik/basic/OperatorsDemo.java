package com.moulik.basic;

public class OperatorsDemo {
	
	/*
	 * 
	 * Java Operator Precedence: PUMA-SRE-BLTA											PreTA - RTL other LTR
	 * 
	 * postfix increment and decrement					++ --							left to right
	 * prefix increment and decrement 					++ --							right to left
	 * unary											+ - ~ !							left to right
	 * multiplicative									* / %							left to right
	 * additive											+ -								left to right
	 * shift											<< >> >>>						left to right
	 * relational										< > <= >= instanceof			left to right
	 * equality											== !=							left to right
	 * bitwise AND										&								left to right
	 * bitwise exclusive OR								^								left to right
	 * bitwise inclusive OR								|								left to right
	 * logical AND										&&								left to right
	 * logical OR										||								left to right
	 * ternary											?:								right to left
	 * assignment										= += -= *= /= %= 				right to left
	 * 													&= ^= |= <<= >>= >>>=	
	 * 
	 */
	public static void main(String[] args) {
		
		System.out.println("----------Multiplicative/Additive Operators-----------");
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
		
		System.out.println("----------Assignment Operators-----------");
		//ShortHand
		
		a += b;		// This is equal to a = a + b
		System.out.println(a);	// Output will be 10
		
		a -= b;		// a = a-b
		a *= b;		// a = a*b
		a /= b;		// a = a/b
		a %= b;		// a = a%b
		
		System.out.println("----------Pre/Post Operators-----------");
		//Pre/Post Operators
		int m = 10;
		int n = 0;
		++n;			//This is equal to n = n + 1
		m = ++m;		//m = m+1	PreIncrement: First increment, then assignment
		System.out.println(m);
		
		m = m++;		//m = m		PostIncrement: First assignment, then increment 
		System.out.println(m);	//11
		//m == 11, n == 1
		n = ++m;		//m == 12, n == 12
		n = m++;		//m == 13, n == 12
		System.out.println(m);
		System.out.println(n);
		
		
		System.out.println("----------Bitwise Operators-----------");
		/*
		 * 		12		00001100
		 * 		25		00011001
		 * 		&		00001000	8
		 * 		|		00011101	29	
		 * 		^		00010101	21
		 * 		~		11110011	~12 = -13 = 240		~N = -(N=1)		
		 * 		To find the negation value of 12, find the 1s complement and add 1 to it to get 2s Complement. Negate the 2s complement to get final result.
		 * 		12		11110011	+1		11110100	00001011	13	-13
		 */	
		System.out.println(12 & 25);
		System.out.println(12 | 25);
		System.out.println(12 ^ 25);
		System.out.println(~12);
		
		System.out.println("----------Shift Operators-----------");
		System.out.println( 2 << 2);	//Left shift by 2 places 00000010 -> 00001000
		System.out.println( 8 >> 2);	//Signed Right shift by 2 places 00001000 -> 00000010
		System.out.println( 8 >>> 2);	//Unsigned Right shift by 2 places 00001000 -> 00000010
		System.out.println(-8 >>> 2);	//Unsigned Right shift by 2 places 11111000 -> 10111110
		
		
	}

}
