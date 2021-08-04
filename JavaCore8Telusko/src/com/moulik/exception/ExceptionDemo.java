package com.moulik.exception;

//Exception catch blocks should be in the order of increasing scope, that is, Exception at the end
//Another way of handling exceptions is to have methods throw Exception that can be handled in the calling method
//A try block only needs either a catch block or finally block
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
