package com.moulik.codingInterview.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FindingAnagram {

	public static void main(String[] args) {
		//	0	1	2	3
		//	a	b	a	b
		//	a	b	c	a
		String a = "abcd";
		String b = "dabc";
		
		System.out.println(isAnagram(a,b));
	}
	
	public static boolean isAnagram(String a, String b) {

		/*
		 * boolean found = false; if (a.length() == b.length()) { char[] aArray =
		 * a.toCharArray(); char[] bArray = b.toCharArray(); boolean[] visited = new
		 * boolean[b.length()];
		 * 
		 * for (int m = 0; m < 3; m++) { found = false; System.out.println("a:"+m); for
		 * (int n = 0; n < 3; n++) { //System.out.println("b:"+n);
		 * //System.out.println("visited["+n+"]:"+visited[n]); if (aArray[m] ==
		 * bArray[n] && !visited[n]) { visited[n] = true; found = true; break; } }
		 * if(!found) { System.out.println("here"); break; } }
		 * 
		 * } if(found) { return true; } else { return false; }
		 */
		
		
		/*
		 * Here we have solved this using Java.util.Map. We are assuming that all the letters of the strings are characters.
		 */
		if(!(Pattern.matches("[a-zA-Z]", a) || Pattern.matches("[a-zA-Z]", b))) {
			return false;
		}
		if(a.length() != b.length()) {
			return false;
		}
		Map<Integer,Integer> charFreqMap1 = new HashMap<>();
		for(char c: a.toCharArray()) {
			if(charFreqMap1.containsKey(c)) {
				charFreqMap1.put((int)c, charFreqMap1.get(c)+1);
			} else {
				charFreqMap1.put((int)c, 1);
			}
		}
		Map<Integer,Integer> charFreqMap2 = new HashMap<>();
		for(char d: b.toCharArray()) {
			if(charFreqMap2.containsKey(d)) {
				charFreqMap2.put((int)d, charFreqMap2.get(d)+1);
			} else {
				charFreqMap2.put((int)d, 1);
			}
		}
		if(charFreqMap1.keySet().size() != charFreqMap2.keySet().size()) {
			return false;
		} else {
			for(Integer key : charFreqMap1.keySet()) {
				if(!charFreqMap2.containsKey(key)) {
					return false;
				} else {
					if( charFreqMap1.get(key) == charFreqMap2.get(key) ) {
						return true;
					}
				}
			}
		}
		
		return false;

	}

}
