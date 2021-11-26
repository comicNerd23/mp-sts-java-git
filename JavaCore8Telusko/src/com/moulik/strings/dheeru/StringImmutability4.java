package com.moulik.strings.dheeru;

/**
 * String Immutability
 * Immutable means once an object is created, its value can never be changed.
 * 
 * 	String s1 = new String("abcd");	//Or String s1 = "abcd";
 * 	s1 = new String("1234");	
 * 
 * The second line above will create a new String object and assign s1 to it. The previous "abcd" object in the heap
 * memory will be abandoned and eligible for gc. Even if s1 was in String pool, then again, the "abcd" will lose the
 * reference to s1.
 * 
 * String objects are immutable but String object references are not. So s1 can be assigned multiple times after its 
 * creation.
 * 
 * Why Strings are immutable?
 * 1. String Interning: If string were mutable, then it would not be possible for strings to be shareable in the pool.
 * 2. Concurrency: If multiple threads were accessing the same shared mutable string (object), it can lead to program
 * going into inconsistent state and hence a lot of bugs.
 * 3. Security: There are many networking related classes in Java which take strings as input. Mutable strings could have
 * created serious vulnerabilities. Eg In FileInputStream(String filepath), filepath could be manipulated by a hacker so 
 * as to access other parts of a program which he should not have been allowed to access.
 * 
 *
 */
public class StringImmutability4 {

}
