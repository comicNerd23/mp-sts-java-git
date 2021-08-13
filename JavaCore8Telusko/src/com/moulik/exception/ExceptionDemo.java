package com.moulik.exception;


/**
 * An exception can occur for many different reasons. Following are some scenarios where an exception occurs. 
 * 1. A user has entered an invalid data. 
 * 2. A file that needs to be opened cannot be found.
 * 3. A network connection has been lost in the middle of communications or the JVM has run out of memory.
 * 
 * Some of these exceptions are caused by user error, others by programmer error, and others by physical resources that have failed in some manner.
 * 
 * In Java, it is possible to define two categories of Exceptions and Errors.
 * 1. JVM Exceptions: exceptions/errors that are exclusively or logically thrown by the JVM. 
 * Examples: NullPointerException, ArrayIndexOutOfBoundsException, ClassCastException
 * 2. Programmatic Exceptions: thrown explicitly by the application or the API programmers. Examples: IllegalArgumentException, IllegalStateException.
 * 
 *	Advantages of Exceptions:
 *	1: Separating Error-Handling Code from "Regular" Code
 *	2: Propagating Errors Up the Call Stack
 *	3: Grouping and Differentiating Error Types
 * 
 * Exception catch blocks should be in the order of increasing scope, that is, Exception at the end. Otherwise, you will get a compile time error.
 * Another way of handling exceptions is to have methods throw Exception that can be handled in the calling method
 * A try block only needs either a catch block or finally block, not both.
 *
 */
public class ExceptionDemo {

	public static void main(String[] args) {

		try {
			
			int[] arr = new int[5];
			arr[6] = 8;
			int i = 9;
			int j = 0;
			int result = i / j;
			System.out.println("result:" + result);
			
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException aExcep) {
			System.err.println(aExcep.getMessage());
		} catch(Exception e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println("Closing Program");
		}
	}

}
