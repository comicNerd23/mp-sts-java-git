package com.moulik.basic;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Arrays are a data-structure which are used to hold a collection of elements. The elements are placed in sequential 
 * memory blocks and are indexed so as to be accessed easily.
 * 
 * A primitive array (one without any type associated to it) can be easily created in Java similar to C/C++. However, it 
 * is useful to use Arrays class in place of your primitive array because there are different operations that you can do.
 * Be aware the performance suffers a little with Arrays compared to primitive array.
 * 
 * When you try to access an element beyond the length of the array, you will get an ArrayIndexOutOfBoundsException(R).
 *
 */
public class ArrayDemo {

	public static void main(String[] args) {

		//Standard way to define and initialize an array in Java
		int[] nums = new int[4];
		System.out.println(nums[3]); //Default value of int (0) is printed
		
		nums[0]= 1;
		nums[1]= 1;
		nums[2]= 1;
		nums[3]= 1;
		System.out.println(nums[3]); //After setting the values in array, 1 is printed
		
		int[] nums1 = {1,1,1,1};	//Another way of declaring and initializing arrays
		System.out.println(nums1[3]); //Same 1 is printed
		
		//A 2-D array is an array of arrays
		int[][] d = {
				{1,2,3,4},
				{3,4,5},
				{5,2,3,1,6}
		};
		
		for(int i=0; i<d.length; i++) {
			for( int j=0; j<d[i].length; j++) {
				System.out.print(d[i][j]+" ");
			}
			System.out.println();
		}
		
		//Enhanced For Loop
		//Since a 2-D array is an array of arrays
		for(int m[] : d) {
			for(int n : m) {
				System.out.print(n+" ");
			}
			System.out.println();
		}
		
		/*
		 * From Java 8+, you can create stream from arrays and perform all stream operations.
		 */
		String[] names= {"Moulik","Bhuwan","Meenu","Puneet"};
		Arrays.stream(names)
			.forEach(System.out :: println);
		
		
		String[] names2= {"Moulik","Anshul","Arun","Ankit","Nakul"};
		
		String[] names3 = {"Sreyas","Gagan","Ankit","Deepu","Nakul","Siddharth","Moulik"};
		
		/*
		 * Stream.of(names, names2) .flatMap( x -> x).reduce();
		 */
		
	}

}
