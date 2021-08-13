package com.moulik.strings;

public class ReverseString {

	public static void main(String[] args) {

		String str= "Moulik";
		
		String reversedStr = reverseString(str);
		System.out.println(reversedStr);
	}

	private static String reverseString(String str) {
		
		String x = "";
		int i;
		for(i = str.length()-1; i >= 0; i--) {
			char l = str.charAt(i);
			x = x+l;
		}
 		
		return x;
	}

}
