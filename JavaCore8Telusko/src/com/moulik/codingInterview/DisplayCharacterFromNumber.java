package com.moulik.codingInterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem Statement – Ritik wants a magic board, which displays a character for
 * a corresponding number for his science project. Help him to develop such an
 * application. For example when the digits 65,66,67,68 are entered, the
 * alphabet ABCD are to be displayed. [Assume the number of inputs should be
 * always 4 ]
 * 
 * Sample Input 1:
 * 
 * Enter the digits: 
 * 65 
 * 66 
 * 67 
 * 68 
 * 
 * Sample Output 1:
 * 
 * 65-A 
 * 66-B 
 * 67-C 
 * 68-D
 * 
 * Sample Input 2:
 * 
 * Enter the digits: 
 * 115 
 * 116 
 * 101 
 * 112 
 * 
 * Sample Output 2:
 * 
 * 115-s 
 * 116-t 
 * 101-e 
 * 112-p
 *
 */
public class DisplayCharacterFromNumber {

	public static void main(String[] args) {

		try(Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Enter the digits");
			Map<Integer, Character> map = new HashMap<>();
			for(int i=0; i<4; i++) {
				int m = sc.nextInt();
				map.put(m, (char) m);
			}
			map.entrySet().stream().forEach(m -> System.out.println(m.getKey()+"-"+m.getValue()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
