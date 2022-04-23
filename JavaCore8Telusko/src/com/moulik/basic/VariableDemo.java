package com.moulik.basic;

@SuppressWarnings({ "unused" })
public class VariableDemo {

	public static void main(String[] args) {
		
		int _abc = 5; // _,$,alphanumeric symbols are allowed in the variable
		//int 3a = 6; Variable number cannot start with a number.
		
		int num = 50_00_00_000; //1.7< allows _ in the number to represent commas
		//This is actually equal to 500000000
		
		long l = 5000000000000000l; //8 bytes
		int i = 400000;				//4 bytes
		short s = 5;				//2 bytes	-32768 to 32767
		byte b = 5;					//1 byte	-128 to 127
		
		char c = 'B';				//2 bytes
		
		float f = 5.5f;				//4 bytes
		double d = 5.5;				//8 bytes
		
		boolean x = false;			//Non deterministic memory
		c = 67;	//ASCII value for 'B'
		
		
		double d1 = 5; //Implicit Conversion from int to double
		int k = (int)5.5; //Explicit Conversion/Type Casting
		
		/*
		 * Implicit Conversion Table 
		 * 
		 * byte -> short -\
		 * 					--> int -> long -> float -> double
		 * 			char -/
		 * 
		 * byte value can be assigned to short, int, long and so on
		 * char value can be assigned to int, long, float and so on
		 */
	}

}
