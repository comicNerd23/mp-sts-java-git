package com.moulik.strings;



/**
 * Generally, String is a sequence of characters. But in Java, string is an object that represents a sequence of 
 * characters.
 * String is immutable object which means that it cannot be changed once it is created.
 * String is the only class where operator overloading is supported in java. We can concat two strings using + operator. 
 * For example "a"+"b"="ab"
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
		String str3 = String.valueOf("Harry");
		
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
		
		String p1 = "slippery";
		p1 = "parallel";
		System.out.println(p1);
		
		Thread t1 = new Thread(() -> System.out.println("run thread1"));
		//t1.start();
		t1.run();
		
		
	}

}
