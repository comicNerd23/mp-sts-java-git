package com.moulik.basic;

/**	Also Check: https://www.journaldev.com/2366/core-java-interview-questions-and-answers
 * 1. What is static and where do we use it?
 * Ans: static is a keyword in Java. When we use static with a method, then that method gets associated with the class itself and not with the objects of that
 * 		class. We can also create a static block, which is used to initialize static variables of the class. In comparison to instance variables, which can be 
 * 		initialized in the constructor of the class, static variables are initialized in the static block.
 * 
 * 2. Can non-static variables be accessed in static methods/static block?
 * Ans: No. They can't. You can try by creating a member variable int i = 0 in a class. In the main method of this class, try accessing this variable. The
 * 		compiler will give a compile-time exception. (Check StaticDemo.java)
 * 
 * 3. In what order does the JVM executes the method in a Java program?
 * Ans: First it creates static variables, then it creates static block, then static methods (including main), then other methods like instance methods.
 * 
 * 4. How to make a class immutable?
 * Ans: First make the class as final (so that child classes can’t be created).
 * 		Data members should be made private (So that direct access is not allowed) and final (So that we can’t change the value of it after object creation). 
 * 		A parameterized constructor should initialize all the members performing a deep copy (So that data members can’t be modified with object reference)
 * 		Deep copy of objects should be performed in the getter methods (to return a copy, rather than returning the actual object reference.)
 * 		No setters (To not have the option to change the value of the instance variable)
 * 		Note that: We don’t need to perform deep copy or cloning of data members of wrapper types and String class as they are already immutable.
 * 
 * 5. What is deep copy and shallow copy?
 * Ans: Creating an exact copy of an existing object in the memory is known as cloning. The clone() method of the class java.lang.Object accepts an object as a 
 * 		parameter, creates and returns a copy of it (clones). In order to use this method, you need to make sure that your class implements the Cloneable 
 * 		interface. 
 * 		Cloning, by default does the shallow copy, that is, all the original fields are copied but if it has objects, then only the reference variables are
 * 		copied, not the whole objects. If we copy the objects as well, that is called deep copy. 
 * 
 * 6. Is Java pass by value or pass by referencce?
 * Ans: Java is pass by value. 
 *
 */
public class CoreInterviewQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
