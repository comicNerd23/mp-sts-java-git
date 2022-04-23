package com.moulik.codingInterview;

import java.util.ArrayList;
import java.util.List;

public class BarclaysCoding2 {
	
	public void display() {
		List<String> list= new ArrayList<>();
		list.add("Alice");
		list.add("Smith");
		list.add("Jones");
		
		for(String str: list) {
			str = str+"50";
		}
		System.out.println(list);
		list.stream()
		.map(x -> x+"50")
		.forEach(System.out :: println);
	}

	public static void main(String[] args) {
		BarclaysCoding2 obj = new BarclaysCoding2();
		obj.display();

	}

}
