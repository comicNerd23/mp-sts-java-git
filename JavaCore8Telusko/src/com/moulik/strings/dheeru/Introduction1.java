package com.moulik.strings.dheeru;

/**
 * Strings are objects of java.lang.String class. String are a "immutable" "sequence" of "0 or more" "unicode characters". 
 * 
 * Internally String class uses character array to store the text.
 * Java uses UTF-16 for characters.
 * String is sequence of unicode characters.
 * String is immutable
 * 
 * Special Treatment for Strings
 * 	1. String literal
 * 	2. + operators for string concatenation
 * 			String s = "hello" + "world!";		//hello world!
 * 	3. String pool ~ saves memory
 *
 */
public class Introduction1 {

	public static void main(String[] args) {

		String s = new String();			//Empty String
		String s1 = new String("hello");	//Normal String
		
		char[] cArray = {'h','e','l','l','o'};
		String s2 = new String(cArray);		//String from char array
		
		String s3 = "hello!";				//String literal (recommended)
	}

}
