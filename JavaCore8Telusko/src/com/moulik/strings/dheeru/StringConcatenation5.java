package com.moulik.strings.dheeru;

/**
 * + operator
 *  String s = "hello" + "world!";					~ hello world!
 *  String s = "hello" + "world!" + "125";			~ hello world!125
 *  String s = "hello" + "world!" + 125;			~ hello world!125
 *  String s = "hello" + "world!" + 125 + 25.5; 	~ hello world!12525.5
 *  String s = 125 + 25.5 + "hello" + "world!";		~ 150.5hello world!
 *  
 * StringBuilder and StringBuffer are two classes which are mutable. So they allow various operations for modifying.
 *  
 *  StringBuilder sb = new StringBuilder();
 *  sb.append("hello");
 *  sb.append(" world!");
 *  String s = sb.append("Good").append("morning").toString();
 *  
 * Other methods: length, delete, insert, replace, reverse. 
 * 
 * StringBuilder is not synchronized. StringBuffer is synchronized (slow). API compatible with StringBuilder.
 *
 */
public class StringConcatenation5 {

	public static void main(String[] args) {
		String s = "Hello world!";
		System.out.println("s:"+s);
		
		StringBuilder sb = new StringBuilder(s);
		sb.append(" Good");
		sb.append(" morning.");
		System.out.println("sb:"+sb.toString());
		System.out.println("sb.length:"+sb.length());
		
		sb.delete(1, 5);
		System.out.println("sb:"+sb.toString());
		System.out.println("sb.length:"+sb.length());
		
		sb.insert(1, "ey");
		System.out.println("sb:"+sb.toString());
		System.out.println("sb.length:"+sb.length());
		
		
		StringBuilder sb1 = new StringBuilder("madam");
		System.out.println("reversed madam:"+sb1.reverse());
		
	}
}
