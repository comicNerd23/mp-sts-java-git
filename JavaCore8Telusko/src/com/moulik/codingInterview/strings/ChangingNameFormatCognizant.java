package com.moulik.codingInterview.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This program provides a way to take a Java class name and change it to C++ class name and vice-versa.
 * 		C++				-> 		Java
 * 	Car_method_variable -> CarMethodVariable
 *
 */
public class ChangingNameFormatCognizant {

	public static void main(String[] args) {
		
		String cPlusPLusName = "my_first_class";
		String javaName = "myFirstClass";
		
		String x = cToJava(cPlusPLusName);
		System.out.println(x);
		
		String y = javaToC(javaName);
		System.out.println(y);

	}

	private static String javaToC(String javaName) {
		char[] arr = javaName.toCharArray();
		List<Integer> indexes = new ArrayList<>();
		for(int i=0; i< arr.length; i++) {
			if(String.valueOf(arr[i]).equals(String.valueOf(arr[i]).toUpperCase())) {
				indexes.add(i);
			}
		}
		System.out.println("Indexes:"+indexes);
		String[] arrStr = new String[indexes.size()+1];
		//for(int j=0; j<indexes.size(); j++) {
		int size = indexes.size();
		int f = 0;
		while(size > 0) {
			int beginIndex = 0;
			int endIndex = indexes.get(f);
			arrStr[f] = javaName.substring(beginIndex, endIndex);
			if(true) {
				beginIndex = indexes.get(f);
				endIndex = indexes.get(f++);
			}
			size--;
		}
		
		return String.join("_", arrStr);
	}

	private static String cToJava(String cPlusPLusName) {
		String[] x = cPlusPLusName.split("_");
		String[] y = new String[x.length];
		
		for(int i=0; i<x.length; i++) {
			
			String m = String.valueOf(x[i].charAt(0));
			if(i!=0) {
				m = m.toUpperCase();
			}
			String n = x[i].substring(1);
			y[i] = m.concat(n);
		}
		return String.join("", y);
	}

}
