package com.moulik.codingInterview;

import java.util.Arrays;
import java.util.List;

public class BarclaysCoding3 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1,2,3);
		//numbers.stream().map(BarclaysCoding3::divideByZero).forEach(System.out :: println);
		
		"hackerearth".chars().distinct().peek(ch -> System.out.print(ch)).sorted();
		
	}
	
	public static int divideByZero(int n) {
		return n/0;
	}

}
