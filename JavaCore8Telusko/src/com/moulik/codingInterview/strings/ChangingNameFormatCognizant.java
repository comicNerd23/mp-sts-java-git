package com.moulik.codingInterview.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This program provides a way to take a Java class name and change it to C++ class name and vice-versa.
 * 		C++				-> 		Java
 * 	Car_method_variable -> CarMethodVariable
 *
 */
public class ChangingNameFormatCognizant {

	public static void main(String[] args) {
		
		String cPlusPlusName = "my_first_class";
		String javaName = "myFirstClass";
		
		String x = cToJava(cPlusPlusName);
		System.out.println(x);
		
		String y = javaToC(javaName);
		System.out.println(y);

	}

	private static String javaToC(String javaName) {
		
		//javaName.
		
		int start = 0;
		int end = javaName.length()-1;
		
		int x=0;
		char[] arr = javaName.toCharArray();
		
		List<String> strings = new ArrayList<String>();
		while(x<=end) {
			if(String.valueOf(arr[x]).equals(String.valueOf(arr[x]).toUpperCase())) {
				strings.add(javaName.substring(start,x));
				start = x;
			} else if(x==end) {
				strings.add(javaName.substring(start,x+1));
			}
			x++;
		}
		List<String> strs = strings.stream().map(a -> a.toLowerCase()).collect(Collectors.toList());
		return String.join("_", strs);
	}

	private static String cToJava(String cPlusPlusName) {
		String[] x = cPlusPlusName.split("_");
		//String[] y = new String[x.length];
		
		for(int i=0; i<x.length; i++) {
			
			String m = String.valueOf(x[i].charAt(0));
			if(i!=0) {
				m = m.toUpperCase();
			}
			String n = x[i].substring(1);
			x[i] = m.concat(n);
		}
		return String.join("", x);
	}

}
