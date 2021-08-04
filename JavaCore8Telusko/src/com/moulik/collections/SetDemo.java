package com.moulik.collections;

import java.util.HashSet;
import java.util.Set;

//Set is a collection which does not allow duplicate elements
public class SetDemo {

	public static void main(String[] args) {

		Set<Integer> newSet = new HashSet<>();
		newSet.add(6);
		newSet.add(9);
		newSet.add(11);
		
		newSet.stream()
		.forEach(x->System.out.println(x));
	}

}
