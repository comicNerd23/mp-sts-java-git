package com.moulik.strings;

import java.util.ArrayList;

/**
 * 1. What is a string in Java? What is so unique about String?
 * Ans: String is a Java datatype but not primitive data type. It is an class through which we can create string objects which are immutable. Strings are actually
 * 		created in a place in Java Heap Memory called Spring Pool. It is only possible because string are immutable. It employs Flyweight Design Pattern. 
 * 		String Pool helps in saving a lot of space for Java Runtime although it takes more time to create the string.
 * 
 * 2. How many Strings are getting Created in the String Pool? eg String str = new String("cat");
 * Ans: In the above statement, either 1 or 2 string will be created. If there is already a string literal “Cat” in the pool, then only one string “str” will be 
 * 		created in the pool. If there is no string literal “Cat” in the pool, then it will be first created in the pool and then in the heap space, so a total of
 * 		2 string objects will be created.
 *
 * 3. How do we then manipulate Strings if they are immutable?
 * Ans: We use classes like StringBuilder or StringBuffer. Both are mutable but StringBuilder is faster but StringBuffer is synchronized.
 * 
 * 4. What is the way to create String in Java 8?
 * Ans: Java recommends to use String x = "Cat" instead of using new String("Cat")
 * 
 * 5. What are common String methods?
 * Ans: equals() and equalsIgnoreCase() are most common. They are used to compare two strings since String class implements Comparable interface.
 * 		Other methods are :
 * 			1. split(regex): which returns a String[] of strings seperated by "_" or "/" or any other regex
 * 			2. contains(CharSequence cs): which checks if cs is present in the string.
 * 			3. length(): which returns the length of the string
 * 			4. replace(CharSequence old, CharSequence new): replaces all occurences of old with new.
 * 			5. format(Locale l, String format, Object… args): to format the string
 * 			6. subString(a, b): used to find substring from a (inclusive) to b (exclusive) 
 * 			7. concat(): to join two strings. similar to using '+' with strings
 * 			8. intern(): When the intern method is invoked, if the pool already contains a string equal to this String object as determined by the equals(Object)
 * 					method, then the string from the pool is returned. Otherwise, this String object is added to the pool and a reference to this String 
 * 					object is returned.
 * 			9. charAt(int a): returns the character at a index of String
 * 			10. codePointAt(int a): returns the codePoint(Unicode character) at a index of String
 * 			11. join(regex, list): joins all the elements of the list (or array) with regex (like space, / etc) between them
 * 
 * 6. Are Strings thread-safe?
 * Ans: Yes, since Strings are immutable, hence they are thread-safe.
 * 
 * 7. Why String is popular HashMap key in Java?
 * Ans: Since String is immutable, its hashcode is cached at the time of creation and it doesn’t need to be calculated again. This makes it a great candidate 
 * 		for the key in a Map and it’s processing is fast than other HashMap key objects. This is why String is mostly used Object as HashMap keys.
 * 
 */
public class StringInterviewQuestions {

	public static void main(String[] args) {
		
		String a = String.valueOf("Cat");
		var abc = new ArrayList<Integer>(); //From Java 10, we can use var keyword for local defined variables without denoting any types
	}

}
