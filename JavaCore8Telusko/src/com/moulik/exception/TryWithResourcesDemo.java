package com.moulik.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//You can declare the memory risky resources in the try parameters. As you can see it gives a cleaner code.
public class TryWithResourcesDemo {

	public static void main(String[] args) {

		int n;
		System.out.println("Enter a number");
		
		/*
		 * When we define the variables here, we don't need to close them in finally. We can actually remove both catch and finally block now but it is 
		 * recommended to have the exceptions give proper message in the catch block
		 * 
		 */
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			System.out.println("Number is "+n);
		} catch (NumberFormatException | IOException e) {
			System.out.println("Exception found for:"+e.getMessage());
		} finally {
			System.out.println("Closing Program in finally");
		}
	
	}

}
