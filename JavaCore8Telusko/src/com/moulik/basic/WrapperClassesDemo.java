package com.moulik.basic;

//Java provides Wrapper classes for accessing all primitive datatype variables
public class WrapperClassesDemo {

	public static void main(String[] args) {
		
		int i = 5;
		Integer ii = new Integer(5);	//This is called Boxing. Now deprecated from Java 9
		Integer iii = Integer.valueOf(5); //Better space-time complexity than constructor
		
		Integer j = 9;	//This is called AutoBoxing because JVM automatically creates a Integer object
		
		String s = "123";
		int si = Integer.parseInt(s);	//Method for getting int value from String
		System.out.println(si);
		
	}

}
