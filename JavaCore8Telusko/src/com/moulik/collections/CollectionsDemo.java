package com.moulik.collections;

import java.util.ArrayList;
import java.util.Collection;

//collections are in general groups of data
//Collection is an interface which has the declarations of many methods useful for working with DS in collections
//Collections is a class
public class CollectionsDemo {

	public static void main(String[] args) {
		
		Collection<Integer> values = new ArrayList<>();
		values.add(23);
		values.add(12);
		values.add(44);
		
		
		//Pre Java-8 way of traversing collections 
		/*
		 * for(int x: values) { System.out.println(x); }
		 */
		
		//A better way to traverse the collections is using aggregate operations
		values.stream()
			.filter(x->x>20)
			.forEach(x->System.out.println(x));
		

	}

}
