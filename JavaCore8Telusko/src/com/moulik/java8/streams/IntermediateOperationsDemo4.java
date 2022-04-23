package com.moulik.java8.streams;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Intermediate Operations:
 * Intermediate Operations are mostly lazy, that is, they will not be executed until some terminal operation is invoked.
 * 
 * 1. filter(Predicate ) : used to filter objects from a stream
 * 2. map(Function) mapToInt(ToIntFunction) mapToLong(ToLongFunction) mapToDouble(ToDoubleFunction): used to perform a function on each object of the stream
 * 3. flatMap(Function) flatMapToInt(Function) flatMapToLong(Function) flatMapToDouble(Function): used to perform a function on each object of the stream
 * 		It has the effect of applying a one-to-many transformation to the elements of the stream, and then flattening the resulting elements into a new stream.
 * 4. distinct(): Returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream.
 * 5. sorted() sorted(Comparator): Returns a stream consisting of the elements of this stream, sorted according to natural order (or comparator).
 * 6. peek(Consumer): Returns a stream consisting of the elements of this stream, additionally performing the provided action on each element as elements are 
 * 		consumed from the resulting stream
 * 7. limit(long size): Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length
 * 8. skip(long n): Returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream. If this stream 
 * 		contains fewer than n elements then an empty stream will be returned. It can be become expensive for ordered streams.
 * 9. takeWhile(): 
 * 10.dropWhile():
 *
 */
public class IntermediateOperationsDemo4 {

	public static void main(String[] args) {
		
		List<String> names = List.of("Ava","Aneri","Alberto","Ankit","Suraj","Moulik","Sunil","Sahil");
		List<String> namesWithA = names.stream()
			.filter(e -> e.startsWith("A"))
			.filter(m -> m.endsWith("i"))
			.sorted()
			.peek(x -> System.out.println(x))
			.collect(Collectors.toList());
		System.out.println(namesWithA);
		
		System.out.println("---------------------------------");
		
		names.stream()
		.filter(e -> e.startsWith("A"))
		.sorted()
		.peek(x -> System.out.println(x))
		.forEach(System.out :: println);

	}

}
