package com.moulik.codingInterview.strings;

public class UncompressingStringsHcl {

	public static void main(String[] args) {
		
		String input = "aaabbcdccarrrr";
		String output = compress(input);
		System.out.println(output);

	}
	
	private static String compress(String input) {
		//if(input.contains) throw new IllegalArgumentException();
		char[] arr = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		int temp = 1;
		for (int i = 0; i < input.length()-1; i++) {
			char x = arr[i];
			if(arr[i] == arr[i+1]) {
				temp++;
			} else {
				if(temp > 1) {
					sb.append(x).append(temp);
				} else {
					sb.append(x);
				}
				temp = 1;
			}
		}
		System.out.println("Adding last");
		if(temp > 1) {
			sb.append(arr[arr.length - 1]).append(temp);
		} else {
			sb.append(arr[arr.length - 1]);
		}
		
		return sb.toString();
	}

}
