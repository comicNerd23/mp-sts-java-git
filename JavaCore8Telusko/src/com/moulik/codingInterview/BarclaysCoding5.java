package com.moulik.codingInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Numbers with 4,5 are special numbers. For example: 4,5,44,45,45454 etc
 * Find the minimum no of special strings whose sum is equal to the given number.
 * Input 	-> Output
 * 5		-> 1 		since 5 is a special number.
 * 49 		-> 2 		since 49 = 45 + 4
 *
 */
public class BarclaysCoding5 {
	
	

	public static void main(String[] args) {
		String x = "45";
		
		boolean p = Pattern.matches("[45]+", "55");
		System.out.println(p);
		

	}

}
