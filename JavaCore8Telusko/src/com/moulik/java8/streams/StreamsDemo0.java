package com.moulik.java8.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Streams bring functional programming to Java 8.
 * Advantages:
 * 	1. Will make you a more efficient Java Programmer, reduces the code length
 * 	2. Make heavy use of lambda expressions
 * 	3. ParallelStreams make it very easy to use multi-thread operations
 * 
 * A Stream pipeline consists of a source, followed by 0 or more intermediate operations and a terminal operation.
 * 
 * Stream Source: Collections, Lists, Sets, ints, longs, doubles, arrays, lines of a file
 * Stream operations are either intermediate or terminal.
 * Intermediate operations such as filter, map or sort return a stream so we can chain multiple intermediate operations.
 * Terminal operations such as forEach, collect or reduce are either void or return a non-stream result.
 * 
 * Stream sources can be created in following ways:
 * 1. IntStream.range(a,b) or DoubleStream.range(a,b) or LongStream.range(a,b)
 * 2. Stream.of(T ...) or IntStream.of(Integer ...) and so on, where T ... can be a variable array including normal array
 * 3. collection.stream() eg list.stream() or map.stream or set.stream()
 * 4. Arrays.stream(array) ------- not Collections.stream()
 * 
 * For intermediate operations, order matters. Filter first, then sort or map to decrease the number of datasets. For very large operations, use ParallelStreams
 * to enable multiple threads. (total 8)
 * 
 * Examples: anyMatch()		distinct()		filter()		findFirst()		flatMap()		map()		skip()		sorted()
 * 
 * Only one Terminal Operation is allowed. (total 7)
 * 1. forEach: applies the same function to each element.
 * 2. collect: saves the elements into a collection.
 * 3. other below options reduce the stream to single summary element.
 *			count()		max()		min()		reduce()		summaryStatistics()
 *
 *Limitations Of Streams :
 * 1. Once a Stream is consumed, it can’t be used later on. As you can see in above examples that every time I created a 
 * stream.
 * 2. Lambda expressions (as well as anonymous classes) in Java can only access to the final (or effectively final) 
 * variables of the enclosing scope.
 * 3. There are a lot of methods in Stream API and so the most confusing part is the overloaded methods. It makes the 
 * learning curve time taking. So  first time it takes some time to learn about how it works.
 * 4. Stateless lambda expressions: If you are using parallel stream and lambda expressions are stateful, it can be 
 * result in random responses. Let’s see this  with a simple program.
 *
 */
public class StreamsDemo0 {

	
	public static void main(String[] args) throws IOException {

		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.stream();
		
		int[] arr = {2,3,4};
		Arrays.stream(arr,0,1);
		
		System.out.println("Example 1: IntStream.range(a,b)");	//Creates a range of stream objects from a to b at the interval of 1.
		IntStream
			.range(1, 10)
			.forEach(System.out::print);
		
		System.out.println();
		System.out.println("Example 2: skip(int n)");	//Skips the first n elements in the stream 
		
		IntStream
		.range(1, 10)
		.skip(5)
		.forEach(System.out::print);		//same as .forEach(x -> System.out.print(x))
		
		System.out.println();
		System.out.println("Example 3: sum()");		//Sums the stream objects. T-Op
		
		System.out.println(
				IntStream
					.range(1, 5)
					.sum()
				);
		
		System.out.println("Example 4: Stream.of(), sorted() and findFirst()");
		
		Stream.of("Ava","Aneri","Alberto")
			.sorted()
			.findFirst()
			.ifPresent(System.out::println);
		
		System.out.println("Example 5: Stream from Array, sort(), filter() and print()");
		
		String[] names = {"Ava","Aneri","Alberto","Ankit","Suraj","Moulik","Sunil","Sahil"};
		Stream.of(names)			//same as Arrays.stream(names)
			.filter(s-> s.startsWith("S"))
			.sorted()
			.forEach(System.out::println);
		
		System.out.println("Example 6: Average of squares of an int array");
		Arrays.stream(new int[] {4,6,2,1})
			.map( s -> s*s )
			.average()
			.ifPresent(System.out::println);

		
		System.out.println("Example 7: Stream from List, filter and print");
		List<String> people = Arrays.asList(names);
		people.stream()
			.map(String :: toLowerCase)
			.filter(s -> s.startsWith("S"))
			.forEach(System.out::print);
		
		System.out.println("Example 8: Stream from List, filter and print");
		if (Files.exists(Paths.get("bands2.txt"))) {
			Stream<String> bands = Files.lines(Paths.get("bands2.txt"));
			bands.sorted().filter(x -> x.length() > 13).forEach(System.out::println);
			bands.close();
		}
		System.out.println("Example 9: Stream rows from text file and save to List");
		if (Files.exists(Paths.get("bands2.txt"))) {
			List<String> bands2 = 
					Files.lines(Paths.get("bands.txt"))
					.filter(s -> s.startsWith("jit"))
					.collect(Collectors.toList());
			bands2.forEach(System.out :: println);
		}
		System.out.println("Example 10: Stream rows from csv file, parse data from rows");
		
		System.out.println("Example 11: Stream rows from csv file, parse data from rows");
		
		System.out.println("Example 12: Stream rows from csv file, store fields in HashMap");
		
		System.out.println("Example 13: Reduction - sum");
		double sum = 
				Stream.of(0.5, 7.3, 4.2)
					.reduce(0.0, (Double a, Double b) -> a + b);
		System.out.println("sum:"+sum);
					
		
		System.out.println("Example 14: Reduction - summary statistics (Only works on Integers)");
		IntSummaryStatistics summary = IntStream.of(5, 6, 9)
			.summaryStatistics();
		System.out.println("summary:"+summary);
	}

}
