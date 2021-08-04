package com.moulik.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {

		List<Integer> values = new ArrayList<>();
		values.add(23);
		values.add(18);
		values.add(44);
		
		Collections.sort(values);	//sorts the collection in natural ordering
		//This comparator sort based on the units place
		/*
		 * Collections.sort(values, new Comparator<Integer>() {
		 * 
		 * @Override public int compare(Integer o1, Integer o2) { if(o1%10 > o2%10) {
		 * return 1; } else { return -1; } } });
		 */
		Collections.sort(values, (i,j)-> i%10>j%10 ? 1 : -1 );
		
		//Collections.reverse(values); //reverses the collection
		//Collections.shuffle(values); //shuffles the collection in random order
		
		values.stream()
			.forEach(x->System.out.println(x));
	}

}
