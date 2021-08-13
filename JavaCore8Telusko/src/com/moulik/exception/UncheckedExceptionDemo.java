package com.moulik.exception;

/**
 * Unchecked Exceptions are those that occur at the time of execution. Also called RuntimeExceptions. e.g. ArrayIndexOutOfBoundsException, ArithmeticException
 * These exceptions are not required to be handled by the program but it is a good practice to handle them.
 * 
 * 	ArithmeticException				Arithmetic error, such as divide-by-zero
 * 	ArrayIndexOutOfBoundsException	Array index is out-of-bounds
 *	ArrayStoreException				Assignment to an array element of an incompatible type
 *	ClassCastException				Invalid cast
 *	EnumConstantNotPresentException	An attempt is made to use an undefined enumeration value
 *	IllegalArgumentException		Illegal argument used to invoke a method
 *	IllegalMonitorStateException	Illegal monitor operation, such as waiting on an unlocked thread
 *	IllegalStateException			Environment or application is in incorrect state
 *	IllegalThreadStateException		Requested operation not compatible with current thread state
 *	IndexOutOfBoundsException		Some type of index is out-of-bounds
 *	NegativeArraySizeException		Array created with a negative size
 *	NullPointerException			Invalid use of a null reference
 *	NumberFormatException			Invalid conversion of a string to a numeric format
 *	SecurityException				Attempt to violate security
 *	StringIndexOutOfBounds			Attempt to index outside the bounds of a string
 *	TypeNotPresentException			Type not found
 *	UnsupportedOperationException	An unsupported operation was encountered
 *
 * As you can see below code will give ArrayIndexOutOfBoundsException but the compiler is not complaining since it is a RuntimeException.
 *
 */
public class UncheckedExceptionDemo {

	public static void main(String[] args) {
		 int num[] = {1, 2, 3, 4};
	     System.out.println(num[5]);
	}

}
