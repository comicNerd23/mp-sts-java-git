package com.moulik.streams;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Intermediate Operations:
 * 
 * 1. filter(Predicate ) : used to filter objects from a stream
 * 2. map(Function) : used to perform a function on each object of the stream
 * 
 *
 */
public class IntermediateOperationsDemo {

	public static void main(String[] args) {
		
		List<String> names = List.of("Ava","Aneri","Alberto","Ankit","Suraj","Moulik","Sunil","Sahil");
		List<String> namesWithA = names.stream()
			.filter(e -> e.startsWith("A"))
			.collect(Collectors.toList());

	}

}
