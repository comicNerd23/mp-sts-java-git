package com.moulik.exception;

/**
 * 1. What are the common types of Exceptions that you see in Java?
 * Ans: In Java, we broadly see 2 types of Exceptions: Checked and Unchecked.
 * 		1. Checked Exceptions are those which are checked by the compiler at Compilation-Time. These exceptions cannot simply be ignored, the programmer should 
 * 		take care of (handle) these exceptions. e.g. IOException (including FileNotFoundException)
 * 		2. Unchecked Exceptions are those that occur at the time of execution. Also called RuntimeExceptions. e.g. ArrayIndexOutOfBoundsException
 * 
 * 		There is a 3rd category of problems which come under Error class. These are not exceptions at all, but problems that arise beyond the control of the user
 * 		or the programmer. Errors are typically ignored in your code because you can rarely do anything about an error. For example, if a stack overflow occurs,
 * 		an error will arise. They are also ignored at the time of compilation.
 * 		Both Error and Exception are subclasses of Throwable.
 *
 */
public class ExceptionHandlingInterviewQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
