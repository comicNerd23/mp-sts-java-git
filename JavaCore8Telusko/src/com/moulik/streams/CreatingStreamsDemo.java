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
		@SuppressWarnings(value = { "unused" })
		Stream<Object> emptyStream = Stream.empty();
		
		System.out.println("--------- Stream from array ------------");

		//2. From Arrays.stream(array) or from Stream.of(array)
		String[] names = {"Rahul","Anshul","Arun","Ankit","Moulik"};
		
		Stream.of(names)
			.filter(s -> s.startsWith("A"))
			.forEach(System.out :: println);
		
		System.out.println("---------- Stream from array -------------");
		
		Arrays.stream(names)
			.filter(s -> s.startsWith("A"))
			.forEach(System.out :: println);
		
		System.out.println("--------- Stream from specific number array ------------");
		
		//3. From anonymous int[], double[] or long[] or Object[]
		int[] x = new int[] { 3, 15, 32, 21};
		IntStream stream = Arrays.stream(x);
		stream.forEach(System.out :: println);
		
		System.out.println("--------- Stream of objects from array ------------");
		
		//4. Using  Stream.builder()
		String[] names1 = {"Rahul","Anshul","Arun","Ankit","Moulik"};
		Stream<Object> builder = 
				Stream.builder()
				.add(names1)
				.build();
		builder.map(b -> b.toString()).forEach(System.out :: println);

		System.out.println("---------------------");
	}

}
