package com.moulik.codingInterview;

import java.util.Set;
import java.util.TreeSet;

public class BarclaysCoding4 {

	public static void main(String[] args) {

		Set<Name> names = new TreeSet<Name>();
		names.add(Name.Alice);
		names.add(Name.Smith);
		names.add(Name.Bob);
		names.add(Name.Smith);
		
		for(Name d : names) {
			System.out.println(d);
		}
	}

}
enum Name {
	Alice, Smith, Bob, Jones
}