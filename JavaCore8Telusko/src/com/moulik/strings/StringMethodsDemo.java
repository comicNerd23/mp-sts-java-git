package com.moulik.strings;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 	String Methods ( = 42)
 * 
 * 	Source: https://www.w3schools.com/java/java_ref_string.asp
 * 
 * 				boolean				contains(CharSequence cs)
 *				int					length()
 *				boolean				isEmpty()
 *				String				intern()
 *
 * 				char				charAt(int index)
 * 				int					codePointAt(int index)
 *				int					codePointBefore(int index)
 *				int					codePointCount(int beginIndex, int endIndex)
 *				int					offsetByCodePoints(int index, int codePointOffset)
 *
 *				String				concat(String str)
 *
 *				
 *				boolean				matches(String regex)
 *				boolean				regionMatches(int toffset, String other, int ooffset, int len)
 *		
 *				int					compareTo(String anotherString)
 *				int					compareToIgnoreCase(String anotherString)
 *
 *				boolean				contentEquals(StringBuffer sb)
 *				boolean				equals(Object obj)
 *				boolean				equalsIgnoreCase(String str)
 *				int					hashCode()
 *				String				toString()
 *	
 *				String				toUpperCase()
 *				String				toLowerCase()
 *
 *	static		String				valueOf()
 *	static		String				copyValueOf(char[] charArray)
 *				char[]				toCharArray()
 *	
 *				int					indexOf()
 *				int					lastIndexOf()
 *
 *	static		String				join(CharSequence cs, CharSequence cs)
 *				String[]			split(String regex)
 *				CharSequence		subSequence(int beginIndex, int endIndex)
 *				String				substring(int beginIndex, int endIndex)
 *
 *				String				replace(char oldChar, new Char)
 *				String				replaceFirst(String regex, String replacement)
 *				String				replaceAll(String regex, String replacement)
 *
 *				boolean				startsWith(String prefix)
 *				boolean				endsWith(String suffix)
 *
 *	static		String				format(String format, Object... args)
 *				String				trim()
 *				String				strip()
 *				String				stripLeading()
 *				String				stripTrailing()
 *				String				stripIndent()
 *
 *				byte[]				getBytes()
 *				void				getChars(int srcBegin, int srcEnd, char dst[], int dstBegin)
 *
 *
 */
public class StringMethodsDemo {

	public static void main(String[] args) {
		
		/*
		 * 3. String methods
		 * 	i.	split(String regex):splits the string using given regex expression and returns array of string.
		 * 	ii.	contains(CharSequence s): checks if string contains specified sequence of character or not.
		 * 	iii.length(): returns the length of string.
		 * 	iv.	replace(): used to replace a specific part of string with other string. There are 4 variants.
		 * 	v.	format(Locale l, String format, Object… args): used to format the string
		 * vi.	substring(): returns a part of the string based on specified indexes
		 * vii.	concat(): to join two strings. similar to using '+' with strings
		 * viii.intern(): When the intern method is invoked, if the pool already contains a string equal to this String object as determined by the equals(Object)
		 * 				method, then the string from the pool is returned. Otherwise, this String object is added to the pool and a reference to this String 
		 * 				object is returned.
		 * 	ix.	charAt(int a): returns the character at a index of String
		 * 	x.	codePointAt(int a): returns the codePoint(Unicode of the character) at a index of String
		 * 	xi.	join(regex, list): joins all the elements of the list (or array) with regex (like space, / etc) between them
		 * 
		 * 	Java 9 methods:
		 * 	xii.codePoints(): return IntStream object on which we can perform some operations.
		 * xiii.chars(): return IntStream object on which we can perform some operations.
		 * 
		 * 	Java 11 methods:
		 * 	xiv.isBlank(): returns true if the string is empty or contains only white space codepoints, otherwise false.
		 * 	xv. lines() – returns a stream of lines extracted from this string, separated by line terminators.
		 * 	xvi.strip(), stripLeading(), stripTrailing() – for stripping leading and trailing white spaces from the string.
		 * 	xvii.repeat() – returns a string whose value is the concatenation of this string repeated given number of times
		 * 
		 */
		
		String m = "a/b/c/d";
		String[] m1 = m.split("/");
		System.out.println("split string using only regex:");
		for (String string : m1) {
			System.out.println(string);
		}
		System.out.println("split string using regex with limit:");
		String[] m2 = m.split("/", 2);
		for (String string : m2) {
			System.out.println(string);
		}

		System.out.println("----------------------------------------------------");
		
		String y = "Hello World!";
		System.out.println(y.contains("W"));//true
		System.out.println(y.contains("X"));//false
		
		System.out.println("----------------------------------------------------");
		
		String z = "Hello World";
		z = z.replace('l', 'm');
		System.out.println("After Replacing l with m :");
		System.out.println(z);
		
		//replaceAll(String regex, String replacement)
		String z1 = "Hello journaldev, Hello pankaj";
		z1 = z1.replaceAll("Hello", "Hi");
		System.out.println("After Replacing :");
		System.out.println(z1);
		
		//replaceFirst(String regex, String replacement) 
		String z2 = "Hello guys, Hello world";
		z2 = z2.replaceFirst("Hello", "Hi");
		System.out.println("After Replacing :");
		System.out.println(z2);
		
		System.out.println("----------------------------------------------------");
		
		String message = "This is journaldev.com";
		System.out.println(String.format("This is %s", message)); // %s is used to append the string
		System.out.println(String.format(Locale.US, "%f", 3.14)); // using locale as Locale.US

		
		message = message.substring(8,18);
		System.out.println(message);
		
		System.out.println("----------------------------------------------------");
		
		String p = "abc";
		String q = "abc";
		String r = "def";
		
		//same reference
		if (p==q) {
			System.out.println("Both string refer to the same object");
		}
		
		//different reference
		if (p==r) {
			System.out.println("Both strings refer to the same object");
		}else {
			System.out.println("Both strings refer to the different object");
		}
		
		System.out.println("--------------------intern()--------------------------------");
		
		String x1 = "pankaj";
		String x2 = "pankaj";
		String x3 = new String("pankaj");
		
		System.out.println(x1==x2);//true
		System.out.println(x2==x3);//false
		
		String x4 = x3.intern();
		System.out.println(x1==x4);//true
		
		System.out.println("----------------------------------------------------");
		
		List<String> words = Arrays.asList(new String[]{"Hello", "World", "2019"});
		String msg = String.join(" ", words);
		System.out.println(msg);
		
		System.out.println("----------------------------------------------------");
		
		String newString = "abc";

		newString.codePoints().forEach(x -> System.out.println(x));

		newString.chars().forEach(x -> System.out.println(x));
		
		System.out.println("----------------------------------------------------");
		
		// isBlank()
		String string = "abc";
		System.out.println(string.isBlank());
		string = "";
		System.out.println(string.isBlank());

		// lines()
		String string1 = "Hi\nHello\rHowdy";
		System.out.println(string1);
		List lines = string1.lines().collect(Collectors.toList());
		System.out.println(lines);

		// strip(), stripLeading(), stripTrailing()
		String string2 = "  Java,  \tPython\t ";
		System.out.println("#" + string2 + "#");
		System.out.println("#" + string2.strip() + "#");
		System.out.println("#" + string2.stripLeading() + "#");
		System.out.println("#" + string2.stripTrailing() + "#");

		// repeat()
		String string3 = "Hello\n";
		System.out.println(string3.repeat(3));
		string3 = "Co";
		System.out.println(string3.repeat(2));

		System.out.println("----------------------------------------------------");
		
		String string4 = "hello";
		IntStream charss = string4.chars();
		charss.mapToObj(Character::toChars).forEach(System.out :: println);
		
		char[] newChars = new char[string4.length()];
		for(int i = 0; i<string4.length(); i++) {
			char c = string4.charAt(i);
			if(i==0) {
				newChars[i]= Character.toUpperCase(string4.charAt(i));
			} else {
				newChars[i] = string4.charAt(i);
			}
		}
		System.out.println(String.valueOf(newChars));
		
		System.out.println("------------------------String.copyValueOf----------------------------");
		
		char[] moulik = {'M','o','u','l','i','k'};
		String name = String.copyValueOf(moulik);
		
	}
	
}
