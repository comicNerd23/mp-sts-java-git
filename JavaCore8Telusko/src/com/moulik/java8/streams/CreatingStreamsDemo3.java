package com.moulik.java8.streams;

import java.util.Arrays;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * This class show different ways to create Stream objects.
 * 1. Empty Stream from Stream.empty()
 * 2. Stream.of(arr) and Arrays.stream(arr)
 * 3. IntStream, LongStream, DoubleStream from Arrays.stream(new int[]),...
 * 4. StreamBuilder : Stream.builder().add(arr).build()
 * 5. InfiniteStreams : Stream.generate(supplier) and Stream.iterate(T seed, UnaryOperator<T> function)
 * 6. StreamSupport : StreamSupport.stream(Spliterator split, boolean parallel)
 * 
 */
public class CreatingStreamsDemo3 {

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
		IntStream stream = Arrays.stream(new int[] { 3, 15, 32, 21 });
		stream.forEach(System.out :: println);
		
		System.out.println("--------- Stream of objects from array ------------");
		
		//4. Using  Stream.builder()
		String[] names1 = {"Rahul","Anshul","Arun","Ankit","Moulik"};
		Stream<Object> builder = 
				Stream.builder()
				.add(names1)
				.add("Mohit")
				.build();
		builder.map(b -> b.toString()).forEach(System.out :: println);

		System.out.println("---------- INFINITE Stream of objects using generate() or iterate() -----------");
		//5. Using  Stream.generate() or iterate() creates infinite streams
		Stream<String> stream1 = Stream.generate(() -> {return "abc";});
		Stream<String> stream2 = Stream.iterate("abc", (i) -> i);
		//stream1.forEach(System.out :: println);
		//stream2.forEach(System.out :: println);
		
		
		Stream<Integer> first10Evens = Stream.iterate(0, i -> i+2);
		first10Evens.limit(10).forEach(System.out :: println);
		
		Stream<Integer> random10number = Stream.generate(() -> {
			return (int) ( 10*Math.random() );
		});
		random10number.limit(5).forEach(System.out :: println);
		
		System.out.println("---------- Stream of objects using StreamSupport.stream() -----------");
		
		Set<String> set = new TreeSet<>(Arrays.asList("three", "one", "two"));
        Stream<String> numbersStream = StreamSupport.stream(set.spliterator(), false);
        numbersStream.forEach(System.out::println);
        
        Stream<String> numbersOrderedStream = StreamSupport.stream(() -> set.spliterator(), Spliterator.ORDERED, false);
        numbersOrderedStream.forEach(System.out::println);
		

	}

}
