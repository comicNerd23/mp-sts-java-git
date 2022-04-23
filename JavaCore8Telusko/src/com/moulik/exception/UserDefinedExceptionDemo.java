package com.moulik.exception;

/**
 *	To create a user-defined exception, we just need to extend the Exception class. This will create a checked exception. 
 *	e.g MyException is checked exception.
 *	If you want to create an unchecked exception, you need to extend RuntimeException class.  
 *	
 *	You should write your own exception classes if you answer yes to any of the following questions; otherwise, you can 
 *	probably use someone else's.
 *	* Do you need an exception type that isn't represented by those in the Java platform?
 *	* Would it help users if they could differentiate your exceptions from those thrown by classes written by other 
 *	vendors?
 *	* Does your code throw more than one related exception?
 *	* If you use someone else's exceptions, will users have access to those exceptions? A similar question is, should your
 *	package be independent and self-contained?
 *
 *	Generally speaking, do not throw a RuntimeException or create a subclass of RuntimeException simply because you don't 
 *	want to be bothered with specifying the exceptions your methods can throw.
 *
 *	Here's the bottom line guideline: If a client can reasonably be expected to recover from an exception, make it a 
 *	checked exception. If a client cannot do anything to recover from the exception, make it an unchecked exception.
 *
 *
 */
public class UserDefinedExceptionDemo {

	public static void main(String[] args) {

		int i = 9;
		int j = 10;
		
		try {
			if (i / j == 0) {
				throw new MyException("Throwing user defined Exception");
			}
		} catch(MyException myExcep) {
			System.out.println("MyException caught");
		}
	}

}
