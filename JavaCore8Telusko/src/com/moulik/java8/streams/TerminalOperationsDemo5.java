package com.moulik.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Terminal Operations:
 * 
 * 1. forEach(Consumer) forEachOrdered(Consumer): Performs an action for each element of this stream (in the encounter order of the stream if the stream has a
 * 		defined encounter order)
 * 2. toArray() toArray(IntFunction<A> generator): Returns an array containing the elements of this stream (using the provided generator function)
 * 3. T reduce(T, BinaryOperator<T>) Optional<T> reduce(BinaryOperator<T>), U reduce(U, BiFunction, BinaryOperator): 
 * 		Performs a reduction on the elements of this stream, using the provided  identity value and an associative accumulation function, and returns the reduced 
 * 		value. Performs a reduction on the elements of this stream, using an associative accumulation function, and returns an Optional describing the reduced 
 * 		value, if any. Performs a reduction on the elements of this stream, using the provided identity, accumulation and combining functions.
 * 4. collect(Supplier, BiConsumer, BiConsumer) collect(Collector): Performs a mutable reduction operation on the elements of this stream (using a collector).
 * 5. min(Comparator): Returns the minimum element of this stream according to the provided Comparator
 * 6. max(Comparator): Returns the maximum element of this stream according to the provided Comparator
 * 7. count(): Returns the count of elements in this stream
 * 8. anyMatch(Predicate): Returns whether any elements of this stream match the provided predicate
 * 9. allMatch(Predicate): Returns all elements of this stream that match the provided predicate
 * 10. noneMatch(Predicate): Returns elements of this stream that do not match the provided predicate
 * 11. findFirst(): Returns an Optional describing the first element of this stream, or an empty Optional if the stream is empty.
 * 12. findAny(): Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.
 *
 */
public class TerminalOperationsDemo5 {

	public static void main(String[] args) {

		List<String> names = List.of("Ava","Aneri","Alberto","Ankit","Suraj","Moulik","Sunil","Sahil");
		List<String> namesWithA = names.stream()
			.filter(e -> e.startsWith("A"))
			.sorted()
			//.peek(x -> System.out.println(x))
			.collect(Collectors.toList());
		System.out.println("-----------------");
		names.stream()
				.filter(e -> e.startsWith("A"))
				.sorted()
				.peek(x -> System.out.println(x))
				.forEach(System.out :: println);
		
		
		System.out.println("---------- collect() -----------");
		Stream<Integer> intStream = Stream.of(1,2,3,4);
		List<Integer> intList = intStream.collect(Collectors.toList());
		System.out.println(intList); //prints [1, 2, 3, 4]

		intStream = Stream.of(1,2,3,4); //stream is closed, so we need to create it again
		Map<Integer,Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i+10));
		System.out.println(intMap); //prints {1=11, 2=12, 3=13, 4=14}
		
		System.out.println("---------- toArray() -----------");
		Stream<Integer> intStream1 = Stream.of(1,2,3,4);
		Integer[] intArray = intStream1.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArray)); //prints [1, 2, 3, 4]
		
	}

}
