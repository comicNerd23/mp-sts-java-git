package com.moulik.codingInterview;

/**	Also Check: https://www.journaldev.com/2366/core-java-interview-questions-and-answers
 * 1. What is static and where do we use it?
 * Ans: static is a keyword in Java. When we use static with a method, then that method gets associated with the class 
 * itself and not with the objects of that class. We can also create a static block, which is used to initialise static 
 * variables of the class. In comparison to instance variables, which can be initialised in the constructor of the class, 
 * static variables are initialised in the static block.
 * 
 * 2. Can non-static variables be accessed in static methods/static block?
 * Ans: No. They can't. You can try by creating a member variable int i = 0 in a class. In the main method of this class, 
 * try accessing this variable. The compiler will give a compile-time exception. (Check StaticDemo.java)
 * 
 * 3. In what order does the JVM execute the method in a Java program?
 * Ans: First it creates static variables, then it creates static block, then static methods (including main), then other 
 * methods like instance methods.
 * 
 * 4. How to make a class immutable?
 * Ans: a. First make the class as final (so that child classes can’t be created).
 * b. Data members should be made private (So that direct access is not allowed) and final (So that we can’t change the 
 * value of it after object creation). 
 * c. A parameterised constructor should initialise all the members performing a deep copy (So that data members can’t be 
 * modified with object reference)
 * d. Deep copy of objects should be performed in the getter methods (to return a copy, rather than returning the actual 
 * object reference.)
 * e. No setters (To not have the option to change the value of the instance variable)
 * Note that: We don’t need to perform deep copy or cloning of data members of wrapper types and String class as they are
 * already immutable.
 * 
 * 5. What is deep copy and shallow copy?
 * Ans: Creating an exact copy of an existing object in the memory is known as cloning. The clone() method of the class 
 * java.lang.Object accepts an object as a parameter, creates and returns a copy of it (clones). In order to use this 
 * method, you need to make sure that your class implements the Cloneable interface. 
 * Cloning, by default does the shallow copy, that is, all the original fields are copied but if it has objects, then only 
 * the reference variables are copied, not the whole objects. If we copy the objects as well, that is called deep copy. 
 * 
 * 6. Is Java pass by value or pass by referencce?
 * Ans: Java is pass by value. To check if any language is pass by value or pass by reference, we should write the swap 
 * function in that language.
 * 
 * 7. What is the main use of Object class?
 * Ans: The Object class is the parent class of all the classes in java by default. In other words, it is the topmost class
 * of java. The Object class is beneficial if you want to refer any object whose type you don't know. Notice that parent 
 * class reference variable can refer the child class object, known as upcasting.
 * protected Object clone() throws CloneNotSupportedException
      Creates and returns a copy of this object.
public boolean equals(Object obj)
      Indicates whether some other object is "equal to" this one.
protected void finalize() throws Throwable
      Called by the garbage collector on an object when garbage
      collection determines that there are no more references to the object
public final Class getClass()
      Returns the runtime class of an object.
public int hashCode()
      Returns a hash code value for the object.
public String toString()
      Returns a string representation of the object.
The notify, notifyAll, and wait methods of Object all play a part in synchronising the activities of independently running
threads in a program, which is discussed in a later lesson and won't be covered here. There are five of these methods:

public final void notify()
public final void notifyAll()
public final void wait()
public final void wait(long timeout)
public final void wait(long timeout, int nanos)
 * 
 * 8. What is the use of hashcode method?
 *
 */
public class CoreInterviewQuestions {

	{
		System.out.println("instance initializer block");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
		System.out.println("Demo");
		}
	}

}
