package com.moulik.java8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Whenever we need to traverse through a Collection, we need to create an Iterator whose whole purpose is to iterate 
 * over, and then we have business logic in a loop for each of the elements in the Collection. We might get 
 * ConcurrentModificationException if the iterator is not used properly.
 * 
 * Java 8 has introduced forEach method in java.lang.Iterable interface so that while writing code we focus on business 
 * logic. The forEach method takes java.util.function.Consumer object as an argument, so it helps in having our business
 * logic at a separate location that we can reuse.
 * Iterable.forEach(Consumer consumer)
 * 
 * Similar to forEach on Iterable interface, a new method called forEachRemaining has been introduced to Iterator.
 * Iterator.forEachRemaining(Consumer consumer)
 *
 */
public class ForEachMethodInIterable1 {

	
	public static void main(String[] args) {
		
		List<Integer> rollNos = List.of(101, 102, 103, 104, 105, 106, 107, 108, 109, 110);
		
		List<String> names = Arrays.asList("Moulik","Ankit","Nakul","Anshul","Arun","Sukhmeet","Manas","Mohit","Gurvikram","Kush");
		
		Iterator<Integer> rollNosIt = rollNos.iterator();
		while(rollNosIt.hasNext()) {
			System.out.println(rollNosIt.next());
		}
		
		/*
		 * Here we have separated the logic for iteration from our business logic resulting in higher separation of 
		 * concern and cleaner code.
		 * 
		 */
		Consumer<Integer> print = new Consumer<>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		};
		
		rollNos.forEach(print);
		rollNosIt.forEachRemaining(print);
		
		/*
		 * We can also write the consumer code directly if we don't need to reuse the consumer code as shown below.
		 * It is cleaner to maintain and easier to read.
		 */
		names.forEach(System.out::println);
		
		System.out.println("-------------Printing names starting with A----------------");
		
		/*
		 * Print all names which start with 'A'
		 */
		names.stream()
		.filter(name -> name.startsWith("A"))
		.forEach(System.out::println);
	}

}
