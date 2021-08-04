package com.moulik.exception;

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
