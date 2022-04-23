package com.moulik.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *	Checked Exceptions are those which are checked by the compiler at Compilation-Time. These exceptions cannot simply be 
 *	ignored, the programmer should take care of (handle) these exceptions.
 * 	ClassNotFoundException			Class not found
 *	CloneNotSupportedException		Attempt to clone an object that doesn't implement the Cloneable interface
 *	IllegalAccessException			Access to a class is denied
 *	InstantiationException			Attempt to create an object of an abstract class or interface
 *	InterruptedException			One thread has been interrupted by another thread
 *	NoSuchFieldException			A requested field does not exist
 *	NoSuchMethodException			A requested method doesn't exist
 *	ReflectiveOperationException	Superclass of reflection-related exceptions
 *
 *	Finally block is mostly used to close the resources because otherwise there can be memory leak.
 */
public class CheckedExceptionDemo {

	public static void main(String[] args) throws Exception {
		int n;
		System.out.println("Enter a number");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			n = Integer.parseInt(br.readLine());
			System.out.println("Number is "+n);
		} catch (NumberFormatException | IOException e) {
			System.out.println("Exception found for:"+e.getMessage());
		} finally {
			System.out.println("Closing resources in finally");
			br.close();	//This throws an exception again, so either handle it here or declare it as throws in the method
		}
		
	}

}
