package com.moulik.basic;

public class SelectionStatementsDemo {

	public static void main(String[] args) {

		int n = 5;
		
		//If Else Block
		if( n == 0) {
			System.out.println("It is 0");
		} else if ( n%2 == 0) {
			System.out.println("It is an even number");
		} else {
			System.out.println("It is an odd number");
		}
		
		//Ternary operator
		System.out.println(n>6?"Greater than 6":"Not Greater than 6");
		
		//Switch Block
		switch(n) { // n can be integer ( and also char). For java version >=8, Strings also
		case 1:
			System.out.println("ONE");
			break;
		case 2:
			System.out.println("TWO");
			break;
		case 3:
			System.out.println("THREE");
			break;
		case 4:
			System.out.println("FOUR");
			break;
		default:
			System.out.println("No match");
		}
		
	}

}
