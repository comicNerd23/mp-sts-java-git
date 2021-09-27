package com.moulik.strings;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Basically, string is a sequence of characters but it’s not a primitive type. When we create a string in java, it actually creates an object of type String.
 * String is immutable object which means that it cannot be changed once it is created.
 * String is the only class where operator overloading is supported in java. We can concat two strings using + operator. For example "a"+"b"="ab"
 * Java provides two useful classes for String manipulation – StringBuffer and StringBuilder.
 * 
 * ASCII (American Standard Code For Information Interchange) Table 
 * 
 * 	48-57	0-9			65-90	A-Z			97-122	a-z
 * 
 * Dec  Char                           Dec  Char     Dec  Char     Dec  Char
 * ---------                           ---------     ---------     ----------
 *	0  NUL (null)                      32  SPACE     64  @         96  `
 *  1  SOH (start of heading)          33  !         65  A         97  a
 *  2  STX (start of text)             34  "         66  B         98  b
 *  3  ETX (end of text)               35  #         67  C         99  c
 *  4  EOT (end of transmission)       36  $         68  D        100  d
 *  5  ENQ (enquiry)                   37  %         69  E        101  e
 *  6  ACK (acknowledge)               38  &         70  F        102  f
 *  7  BEL (bell)                      39  '         71  G        103  g
 *  8  BS  (backspace)                 40  (         72  H        104  h
 *  9  TAB (horizontal tab)            41  )         73  I        105  i
 * 10  LF  (NL line feed, new line)    42  *         74  J        106  j
 * 11  VT  (vertical tab)              43  +         75  K        107  k
 * 12  FF  (NP form feed, new page)    44  ,         76  L        108  l
 * 13  CR  (carriage return)           45  -         77  M        109  m
 * 14  SO  (shift out)                 46  .         78  N        110  n
 * 15  SI  (shift in)                  47  /         79  O        111  o
 * 16  DLE (data link escape)          48  0         80  P        112  p
 * 17  DC1 (device control 1)          49  1         81  Q        113  q
 * 18  DC2 (device control 2)          50  2         82  R        114  r
 * 19  DC3 (device control 3)          51  3         83  S        115  s
 * 20  DC4 (device control 4)          52  4         84  T        116  t
 * 21  NAK (negative acknowledge)      53  5         85  U        117  u
 * 22  SYN (synchronous idle)          54  6         86  V        118  v
 * 23  ETB (end of trans. block)       55  7         87  W        119  w
 * 24  CAN (cancel)                    56  8         88  X        120  x
 * 25  EM  (end of medium)             57  9         89  Y        121  y
 * 26  SUB (substitute)                58  :         90  Z        122  z
 * 27  ESC (escape)                    59  ;         91  [        123  {
 * 28  FS  (file separator)            60  <         92  \        124  |
 * 29  GS  (group separator)           61  =         93  ]        125  }
 * 30  RS  (record separator)          62  >         94  ^        126  ~
 * 31  US  (unit separator)            63  ?         95  _        127  DEL
 *
 */
public class StringDemo {

	public static void main(String[] args) {
		
		/*
		 * 1. Different Ways to Create String: Using string literal and Using new keyword
		 */
		String str = "abc"; 
		String str1  =  new String("abc");
		char[] a = {'a', 'b', 'c'};
		String str2  =  new String(a);
		
		
		/*
         * 2. Comparing Strings using equals and equalsIgnoreCase 
         * 
         */
		String s1 = "abc";
		String s2 = "abc";
		String s3 = "def";
		String s4 = "ABC";
		
		System.out.println(s1.equals(s2));//true
		System.out.println(s2.equals(s3));//false
		
		System.out.println(s1.equals(s4));//false;
		System.out.println(s1.equalsIgnoreCase(s4));//true
			
		System.out.println("----------------------------------------------------");
        
        /*
         * 2. Comparing Strings using compareTo() and compareToIgnoreCase()
         * String class implements Comparable interface and hence it compares two strings lexicographically.
         */
		String a1 = "abc";
		String a2 = "abc";
		String a3 = "def";
		String a4 = "ABC";
		
		System.out.println(a1.compareTo(a2));//0
		System.out.println(a2.compareTo(a3));//less than 0
		System.out.println(a1.compareTo(a4));//greater than 0
		System.out.println(a1.compareToIgnoreCase(a4));//0
		
		System.out.println("----------------------------------------------------");
		
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
		 * 	x.	codePointAt(int a): returns the codePoint(Unicode character) at a index of String
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
		
		System.out.println("----------------------------------------------------");
		
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
	}

}
