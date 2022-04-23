package com.moulik.java8.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java 8 added a new package java.util.Function that has new Functional Interfaces containing some inbuilt methods to 
 * perform some actions on streams.
 * 
 * 1. Consumer<T>: used when an object of type T needs to be consumed, that is, taken as input and some operation needs to
 *  be performed on it without returning any result)
 * 			void accept(T t);
 * 2. Predicate<T>: used when an object of type T needs to be tested against some condition and returns boolean.
 * 			boolean test(T t);
 * 3. Supplier<T>: used when there is no input but an output of type T is expected.
 * 			T get();
 * 4. Function<T,R>: used when we need to perform some action on an object of type T and return the result of type R
 * 			R apply(T t);		default <V> Function<T,V> andThen(Function<? super R,? extends V> after)
 * 								default	<V> Function<V,R> compose(Function<? super V,? extends T> before)
 * 		UnaryOperator<T>: when both the argument and result have the same type
 * 
 * 5. BiFunction<T,U,R>: used when we need to perform some actions using two arguments and return the result
 * 					R apply(T t, U u);
 * 		BinaryOperator<T>: when the two operands and result are of same type T
 * 
 * 6. BiConsumer<T>: used when an object needs to be consumed (taken as input and some operation needs to be performed on
 *  it without returning any result)
 *					void accept(T t, U u);
 * 7. BiPredicate<T>: used when a condition with two arguments needs to be tested and returns boolean.
 * 					boolean test(T t, U u);
 * 
 * Functional Interfaces in Java 8 Stream
 * 									
 * 							Input							Output
 * 		Consumer			Any Type T						Void
 * 		Predicate			Any Type T						Boolean
 * 		Supplier			Void							Any Type R
 * 		Function			Any Type T						Any Type R
 * 
 * 		BiConsumer			Any Type T, U					Void
 * 		BiPredicate			Any Type T, U					Boolean
 * 		BiFunction			Any Type T, U					Any Type R
 * 		
 * 
 */
public class FunctionalInterfacesDemo2 {

	public static void main(String[] args) {
		
		System.out.println("------------------ Function --------------------------");
		Function<String, String> trim = x -> x.trim();
		
		//A method that takes in a String and returns the length of the string.
		Function<String, Integer> f = x -> x.length(); 
		
		int length = f.apply("Happy");
		System.out.println("Length of String:"+length);
		
		//We can pass function behavior to another map() but before that we are calling default method 'andThen()'
		System.out.println(
				Stream.of("Hallo Liebe Zuschaer!")
				.map(trim.andThen(f))
				.findAny()
				.get() );

		System.out.println("------------------ Consumer --------------------------");
		/*
		 * To create an object from a consumer interface, from Java 8, we don't need to create a separate class and have 
		 * it implement the Consumer interface and then override the instance method of the interface. We know its 
		 * instance method is accept. So we can override it directly as a lambda expression similar to how we create an
		 * anonymous inner class object.
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
		
		System.out.println("--------------------------- BiFunction ----------------------------------------");
		
		//A BiFunction that takes in two lists and transforms them into one list and removes the duplicates and returns 
		//that list
		//BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunc = 
		BinaryOperator<List<Integer>> biOp = 
				(l1,l2) -> 
					Stream.of(l1, l2)
					.flatMap(List :: stream)
					.distinct()
					.collect(Collectors.toList());
					
		List<Integer> list1 = List.of(1,5,7,8,9,2);
		List<Integer> list2 = List.of(2,3,6,7);
		
		List<Integer> duplicates = biOp.apply(list1, list2);
		System.out.println("Duplicates:"+duplicates);
		
		Map<String, Integer> salaryMap = new HashMap<>();
		salaryMap.put("Moulik", 10000);
		salaryMap.put("Bhuwan", 20000);
		salaryMap.put("Puneet", 5000);
		
		//Increase salary of each person by 1000
		//replaceAll(k,v): perform some operation of BiFunction on v but it takes in two arguments k and v
		BiFunction<String, Integer, Integer> x = (k,v) -> v+1000;
		salaryMap.replaceAll(x);
		
		System.out.println(salaryMap);
		
		
		System.out.println("--------------------------- BiConsumer ----------------------------------------");
		
		BiConsumer<String, Integer> printEmpSalary = (k,v) -> System.out.println("K:"+k+" V:"+v);
		printEmpSalary.accept("Puneet", 5000);
		
		salaryMap.forEach( printEmpSalary );
		
		//Stream.of(list1, list2).collect( ()-> null, (list1,list2) -> System.out.println("X:"+list1+" Y:"+list2), list2);
		
		System.out.println("--------------------------- BiPredicate ----------------------------------------");
		
		BiPredicate<String, String> biPred = (t,k) ->  t.equals(k);
		
		System.out.println(biPred.and((t,k) ->  t.length() == k.length()).test("madam","madam"));
		
		
		System.out.println("--------------------------- Optional ----------------------------------------");
		
		
		
	}

}
