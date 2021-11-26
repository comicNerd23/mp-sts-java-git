package com.moulik.jvm;

/**
 * 	Reflection is a feature in the Java programming language. It allows an executing Java program to examine or 
 *	"introspect" upon itself, and manipulate internal properties of the program. For example, it's possible for a Java 
 * 	class to obtain the names of all its members and display them.
 * 
 *  Reflection allows to do two things:
 *  1. Introspect known/unknown code: Find all the meta-information using only the object ref or class name or interface
 *  name at run-time directly.
 *  2. Affect runtime behavior due to introspection: Since we know the class meta-information at runtime, we can load that
 *  class, create an instance of that class and even invoke some methods of that instance.
 *  
 *  Reflection Use-Cases:
 *  1. Class browsers in IDE (to show methods on that class)
 *  2. Processing Annotations e.g ORM frameworks, JUnit: (Annotations are nothing but metadata added to the source code)
 *  3. Dynamic Proxies (we can have some classes added as dynamic proxies wrapped around any general classes)
 *  
 *  Reflection uses Class class and java.lang.reflect package
 *
 */
public class Reflection6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
