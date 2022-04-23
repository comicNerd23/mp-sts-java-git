package com.moulik.java8;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Lambda Expression are the way through which we can visualize functional programming in the java object oriented world. 
 * Objects are the base of java programming language and we can never have a function without an Object, that’s why Java 
 * language provide support for using lambda expressions only with functional interfaces.
 * 
 * Since there is only one abstract function in the functional interfaces, there is no confusion in applying the lambda 
 * expression to the method. Lambda Expressions syntax is (argument) -> (body).
 * 
 * Why we need Lambda Expressions?
 * 1. Reduced Lines of Code
 * 2. Sequential and Parallel Execution Support (Using IntStream in the below example)
 * 3. Passing Behaviors into methods
 * 4. Higher Efficiency with Laziness
 *
 */
public class LambdaExpressionDemo3 {
	
	public static void main(String[] args) {
		
	}
	
	//Traditional approach
	private static boolean isPrime(int number) {		
		if(number < 2) return false;
		for(int i=2; i<number; i++){
			if(number % i == 0) return false;
		}
		return true;
	}
	
	/*
	 * Declarative approach: IntStream is a sequence of primitive int-valued elements supporting sequential and parallel
	 * aggregate operations. This is the int primitive specialization of Stream.
	 * noneMatch() method returns whether no elements of this stream match the provided predicate. It may not evaluate the
	 * predicate on all elements if not necessary for determining the result
	 */
	private static boolean isPrime2(int number) {		
		return number > 1
				&& IntStream.range(2, number)
						.noneMatch(index -> number % index == 0);
	}
	
	public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
	    return numbers.parallelStream()
	    		.filter(predicate)
	    		.mapToInt(i -> i)
	    		.sum();
	}

}
