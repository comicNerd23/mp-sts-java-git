package com.moulik.collections;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 *	Map does not have a stream() method like Collection.stream() but we use below to work on it using streams.
 *	
 *	Stream<Map.Entry<a, b>> entriesStream = entries.stream(); 
 *	Stream<a> keysStream = keySet.stream();
 *	Stream<b> valuesStream = values.stream();
 *
 */
public class MapDemo {

	public static void main(String[] args) {

		//Java 9: Map.of creates an unmodifiable map
		Map<String,String> rollNumbersMap =	
				Map.of("Moulik","1810701","Puneet","1810397","Bhuwan","1810707","Shivam","1810399","Meenu","1810708");
		
		//Prints the map entries
		rollNumbersMap.entrySet().stream()
			.forEach( x -> System.out.println(x));
		
		System.out.println("--------------------------");
		
		//Prints the map entries in a sorted order (ascending)
		rollNumbersMap.entrySet().stream()
			.sorted( (a,b) -> a.getKey().compareTo(b.getKey()) )
			.forEach( x -> System.out.println(x));
		
		System.out.println("--------------------------");
		
		//Prints the map of student-rollNumber based on values greater than 1810700
		rollNumbersMap.entrySet().stream()
			.filter( (a) -> Integer.parseInt(a.getValue()) > 1810700)
			.forEach( x -> System.out.println(x));
		
		System.out.println("--------------------------");
		
		// Get a list of names (keys) whose rollNumbers (values) less than 1810700
		List<String> names = rollNumbersMap.entrySet().stream()
			.filter((a) -> Integer.parseInt(a.getValue()) < 1810700)
			.map(Map.Entry :: getKey )	//same as .map(x -> x.getKey())
			.collect(Collectors.toList());
		System.out.println(names);

		System.out.println("--------------------------");
		
		// Get a list of rollNumbers for students whose name start with M
		List<String> rollNumbers = rollNumbersMap.entrySet().stream()
			.filter((a) -> a.getKey().startsWith("M") )
			.map(Map.Entry :: getValue )	//same as .map(x -> x.getValue())
			.collect(Collectors.toList());
		System.out.println(rollNumbers);

		System.out.println("--------------------------");
	}

}
