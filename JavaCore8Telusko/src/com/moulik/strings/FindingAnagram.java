package com.moulik.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FindingAnagram {

	public static void main(String[] args) {
		//	0	1	2	3
		//	a	b	a	b
		//	a	b	c	a
		String a = "silencs";
		String b = "listens";
		
		System.out.println(isAnagram(a,b));
	}
	
	public static boolean isAnagram(String a, String b) {

		boolean found = false;
		if (a.length() == b.length()) {
			char[] aArray = a.toCharArray();
			char[] bArray = b.toCharArray();
			boolean[] visited = new boolean[b.length()];
			
			for (int m = 0; m < 3; m++) {
				found = false;
				System.out.println("a:"+m);
				for (int n = 0; n < 3; n++) {
					System.out.println("b:"+n);
					System.out.println("visited["+n+"]:"+visited[n]);
					if (aArray[m] == bArray[n] && !visited[n]) {
						visited[n] = true;
						found = true;
						break;
					}
				}
				if(!found) {
					System.out.println("here");
					break;
				}
			}
			
		}
		if(found) {
			return true;
		} else {
			return false;
		}

	}

}
