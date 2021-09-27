package com.moulik.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 	Java 8 added a new package java.util.Function that has new Functional Interfaces containing some inbuilt methods to perform some actions on streams.
 * 
 * 1. Consumer<T>: used when an object needs to be consumed (taken as input and some operation needs to be performed on it without returning any result)
 * 			void accept(T t);
 * 2. Predicate<T>: used when an object needs to be tested against some condition and returns boolean.
 * 			boolean test(T t);
 * 3. Supplier<T>: used when there is no input but an output is expected.
 * 			T get();
 * 4. Function<T,R>: used when we need to perform some actions and return the result
 * 			R apply(T t);
 *
 */
public class FunctionalInterfacesDemo {

	public static void main(String[] args) {
		
		System.out.println("------------------ Function --------------------------");
		
		Function<String, Integer> f = x -> x.length();	//A method that takes in a String and returns the length of the string.
		int length = f.apply("Happy");
		System.out.println("Length of String:"+length);
		
		System.out.println(
				Stream.of("Hallo Liebe Zuschaer!")
				.map(f)
				.findAny()
				.get() );

		System.out.println("------------------ Consumer --------------------------");
		/*
		 * To create an object from a consumer interface, from Java 8, we don't need to create a separate class and have it implement the Consumer interface
		 * and then override the instance method of the interface. We know its instance method is accept. So we can override it directly as a lambda expression
		 * similar to how we create an anonymous inner class object.
		 */
		
		Consumer<Integer> c = t -> System.out.println("Printing "+t);
		
		//By now we have only created the behavior of the interface. We have not called it. Now we call it below:
		c.accept(10);
		
		/*
		 * forEach(Consumer c) as an argument
		 */
		Stream.of(1,2,3,4)
			.map(t -> t+2)
			.forEach(c);
		
		
		System.out.println("------------------ Predicate --------------------------");
		
		Predicate<Integer> p = t ->  t%2 == 0 ;
		System.out.println(p.test(23));
		
		IntStream.range(1, 10).boxed()	//This will give a Stream of Integers from 1-9
			.filter(p)
			.forEach(t -> System.out.println("Even"+t));
		
		
		System.out.println("------------------ Supplier --------------------------");
		
		Supplier<String> s = () -> "Nothing found!";	//A method that takes nothing and just prints a String "Nothing Found!"
		System.out.println( s.get() );
		
		System.out.println(
			Stream.of("Sahil","Rohit")
			.filter( m -> m.startsWith("M") )
			.findAny()
			.orElseGet(s) );
		
	}

}
