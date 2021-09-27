package com.moulik.codingInterview;

public class BarklaysCoding {
	
	public static void main(String[] args) {
		
		//check( (h,l) -> h.append(l).isEmpty(), 5); does not compile
	}
	
	private static void check(Climb climb, int height) {
		if(climb.isTooHigh(height, 10)) 
			System.out.println("Yoo high");
		else
			System.out.println("OK");
	}

}
interface Climb {
	boolean isTooHigh(int height, int limit);
}
