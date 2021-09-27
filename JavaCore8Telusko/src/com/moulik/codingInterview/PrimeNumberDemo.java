package com.moulik.codingInterview;

public class PrimeNumberDemo {

	public static void main(String[] args) {

		boolean x = isPrime(53);
		System.out.println(x);
	}

	private static boolean isPrime(int i) {
		if( i < 0) {
			throw new IllegalArgumentException("Only Accepting Whole Numbers");
		}
		if( i == 0 || i == 1) {
			return false;
		}
		if( i == 2 || i == 3) {
			 return true;
		}
		boolean isPrime = false;
		for(int x = 2; x < i/2; x++) {
			isPrime = true;
			if( i%x == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

}
