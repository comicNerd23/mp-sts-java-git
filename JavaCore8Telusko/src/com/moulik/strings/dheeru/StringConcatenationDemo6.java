package com.moulik.strings.dheeru;

/**
 * Effective Java says to beware of the performance of string concatenation
 * 
 * Combining strings with + for few strings is fine.
 * With each concatenation:
 * 	Contents of both string are copied
 * 	New StringBuilder is created and appended with both strings
 * 	Return string via toString()
 *
 */
public class StringConcatenationDemo6 {

	public static void main(String[] args) {

	}

}
