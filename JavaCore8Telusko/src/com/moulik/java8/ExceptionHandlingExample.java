package com.moulik.java8;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {
	
	public static void main(String[] args) {
		
		int[] numbers = {1,2,3,4};
		int key = 2;
		
		process(numbers, key, wrapperLambda((m,n) -> System.out.println(m / n)));
	}

	private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
		for(int i : numbers) {
			consumer.accept(i, key);
		}
	}
	
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (v, k) -> {
			try {
				consumer.accept(v, k);
			} catch(ArithmeticException ae) {
				//ae.printStackTrace();
				System.out.println("Exception caught in wrapper lambda");
			}
		
		};
	}

}
