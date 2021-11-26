package com.moulik.jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * Reflection uses java.lang.Class objects. To access this object, we have 3 ways:
 * 1. objectRef.getClass()
 * 2. Class.forName(String className)
 * 3. Class Literals
 * 
 * 1. Using Object References
 * 	*	Class clazz = "foo".getClass();  Returns java.lang.String
 * 	*	Set set = new HashSet();
 * 		Class clazz = set.getClass();	Returns java.util.hashset
 * 
 * 2. Using Class.forName()
 * 	* Argument is fully qualified class name
 *  * Doesn't work with primitives
 *  * Examples:
 *  	Class.forName("java.lang.String");			String
 *  	Class.forName("[D")							Array Of Primitive Double ([ represents 1 array, [[ represents 2 array)
 *		Class.forName("[Ljava.lang.String;")		1-D array of String
 *		Class.forName("[[Ljava.lang.String;")		2-D array of String
 *
 * 3. Using class literals
 *  * Append .class to type name
 *  * Works with classes, interfaces, arrays, and primitives
 *  * Examples:
 *  	String.class
 *  	boolean.class
 *  	int[][][].class
 *  	void.class
 *  
 *  Class.forName() VS Class Literals
 *  										forName()							Literals
 *  
 *  	Compile-time check					No									Yes. Compiles if needed#Check
 *  	(if the class exists on disk)		ClassNotFoundException				NoClassDefFoundError
 *  
 *  	Initialization						Yes									When static fields/methods (non-
 *  																			compile-time constant) is accessed
 *  
 *  	Primitives							No									Yes
 *  
 *  #Check: The compiler will check if the .class file is present here. If not present, it will use the .java file to 
 *  compile and create a .class file. However, if at run-time, it is somehow not able to find that .class file, then it
 *  throws a NoClassDefFoundError.
 *  
 *  TYPE field for Boxed Primitives (Wrapper classes) and Void
 *  * Boxed Primitives have TYPE field
 *  		Class clazz = Boolean.TYPE;		boolean.class
 *  * Void.TYPE 						void.class
 *  * .class is preferred over .TYPE
 *  
 *  Note: Accessing methods using Reflection is a bit slower than the regular way of accessing methods.
 *  
 *  As we discussed in the class, we can create Class objects corresponding to array of some element type using 
 *  Class.forName approach. In the class, the second example was related to an array of primitive double. Below is a 
 *  list of all notations for all types of the elements that can go in an array. Except for boolean & long, for the rest
 *  of the primitives, their initial character is used in CAPS.
 *		Element Type 				Notation
 *		boolean						Z
 *		byte 						B
 *		char						C
 *		class or interface 			Lclassname;
 *		double 						D
 *		float						F
 *		int							I
 *		long 						J
 *		short						S
 */
public class AccessingClassObject6 {

	public static void main(String[] args) {
		Class clazz = "foo".getClass();
		System.out.println(clazz);
		
		Set<Integer> set = new HashSet<>();
		Class clazz2 = set.getClass();
		System.out.println(clazz2);
	}

}
