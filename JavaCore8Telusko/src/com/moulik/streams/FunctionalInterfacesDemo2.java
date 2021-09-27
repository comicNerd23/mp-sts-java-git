package com.moulik.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 5. BiFunction<T,U,R>: used when we need to perform some actions using two arguments and return the result
 * 					R apply(T t, U u);
 * 
 * 6. BiConsumer<>: used when an object needs to be consumed (taken as input and some operation needs to be performed on it without returning any result)
 *					void accept(T t, U u);
 *
 * 7. BiPredicate<T>: used when a condition with two arguments needs to be tested and returns boolean.
 * 					boolean test(T t, U u);
 */					
public class FunctionalInterfacesDemo2 {

	public static void main(String[] args) {

		System.out.println("--------------------------- BiFunction ----------------------------------------");
		
		//A BiFunction that takes in two lists and transforms them into one list and removes the duplicates and returns that list
		BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunc = 
				(l1,l2) -> 
					Stream.of(l1, l2)
					.flatMap(List :: stream)
					.distinct()
					.collect(Collectors.toList());
					
		List<Integer> list1 = List.of(1,5,7,8,9,2);
		List<Integer> list2 = List.of(2,3,6,7);
		
		List<Integer> duplicates = biFunc.apply(list1, list2);
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
		
		
	}

}
