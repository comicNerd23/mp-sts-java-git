package com.moulik.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * This class show different ways to create Stream objects.
 *
 */
public class CreatingStreamsDemo {

	public static void main(String[] args) {
		
		//1. Empty Stream
		Stream<Object> emptyStream = Stream.empty();

		//2. From Arrays.stream(array) or from Stream.of(array)
		String[] names = {"Rahul","Anshul","Arun","Ankit","Moulik"};
		
		Stream.of(names)
			.filter(s -> s.startsWith("A"))
			.forEach(System.out :: println);
		
		System.out.println("---------------------");
		
		Arrays.stream(names)
			.filter(s -> s.startsWith("A"))
			.forEach(System.out :: println);
		
		System.out.println("---------------------");
		
		//3. From anonymous int[], double[] or long[] or Object[]
		IntStream stream = Arrays.stream(new int[] { 3, 15, 32, 21});
		stream.forEach(System.out :: println);
		
		System.out.println("---------------------");
		
		//4. Using  Stream.builder()
		Stream<Object> builder = 
				Stream.builder()
				.add(names)
				.build();
		builder.forEach(System.out :: println);

		System.out.println("---------------------");
	}

}
