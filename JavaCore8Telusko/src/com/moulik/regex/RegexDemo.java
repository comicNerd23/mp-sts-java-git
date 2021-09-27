package com.moulik.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 	Regex is a way to search through a string of text in order to do various things such as maybe advanced validation or do find and replace and so on.
 * 	It is a string of characters that describes a character sequence. In Java, this regex is also known as Pattern. It can be used to find matches in other
 * 	character sequences.
 * 
 * 	Pattern and Matcher are the two classes used to work on Regexs. Use Pattern to define a regular expression. Match the pattern against another sequence using
 * 	Matcher.
 * 
 * 	/cat/g
 * 
 * 	A regex in most languages is between two forward slashes (or sometimes double quotes). 
 * 	We also give an option with it using a character like g global, i case-insensitive, m multi-line, s single-line etc.
 * 
 * 	* 	match 0 or more occurrences of the same character
 * 	+ 	match 1 or more occurrences of the same character
 * 	?	match 0 or 1
 *
 */
public class RegexDemo {

	public static void main(String[] args) {
		
		/* Pattern class has no constructors. The compile(String) converts a string into a Pattern. Once you have created a Pattern object, you will use it to 
		 * create a Matcher. This is done by calling the matcher( ) method defined by Pattern.
		 * Matcher matcher = Pattern.matcher(CharSequence str)
		 * Once you have created a Matcher, you will use its methods to perform various pattern matching operations
		 * 	matches( ): returns true only when the input sequence precisely matches the pattern
		 */
		Pattern patternPuneet = Pattern.compile("Puneet");
		Matcher matcherPuneet = patternPuneet.matcher("Puneet");
		System.out.println(matcherPuneet.matches());		//true
		
		System.out.println(patternPuneet.matcher("P*").matches());		//false
		
		boolean b3 = Pattern.matches(".s","as");
		System.out.println("b3:"+b3);
		
		//find(): to determine if the input sequence contains a subsequence that matches the pattern
		Pattern patternJava = Pattern.compile("Java");
		Matcher matcherJavaSe = patternJava.matcher("Java SE");
		System.out.println("Looking for 'Java' in 'Java SE'");
		System.out.println(matcherJavaSe.find());		// true
		
		//find() can be used to find all occurrences of the subsequence
		Pattern pat = Pattern.compile("test");
		Matcher mat = pat.matcher("test 1 2 3 test");
		while (mat.find()) {
			System.out.println("test found at index:"+mat.start());
		}
		
		//Using Wildcards and quantifiers
		Matcher mat2 = Pattern.compile("W*").matcher("W WW WWW");
		while (mat2.find()) {
			System.out.println("W found at index:"+mat.group());
		}

	}

}
