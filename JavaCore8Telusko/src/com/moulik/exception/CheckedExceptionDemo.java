package com.moulik.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Finally block is mostly used to close the resources because otherwise there can be memory leak
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
