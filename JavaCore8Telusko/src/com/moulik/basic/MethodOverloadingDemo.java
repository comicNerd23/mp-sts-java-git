package com.moulik.basic;

/**
 * Method overloading is a feature of Java in which a class has more than one method of the same name and their parameters 
 * are different.
 * It is different from overriding which is used in the context of Inheritance.
 */
public class MethodOverloadingDemo {

	public static void main(String[] args) {
		
		//Constructor Overloading
		Calcul calc = new Calcul();
		Calcul calc1 = new Calcul(1);
		Calcul calc2 = new Calcul(1,2);
		Calcul calc3 = new Calcul(1,2,"Add");
		
		//Method Overloading
		calc.add(5,2);
		calc.add(5,2,9);
		calc.add(5.5,2.5);
		
	}
	
}

class Calcul {
	
	int num1;
	int num2;
	String operation;
	
	public Calcul() {
		int num1 = 0;
		int num2 = 0;
		String operation = "Nothing";
	}
	
	public Calcul(int i) {
		int num1 = i;
		int num2 = 0;
		String operation = "Nothing";
	}
	
	public Calcul(int i, int j) {
		int num1 = i;
		int num2 = j;
		String operation = "Nothing";
	}
	
	public Calcul(int i, int j, String op) {
		int num1 = i;
		int num2 = j;
		String operation = op;
	}
	public void add(int i, int j) {
		System.out.println("i+j="+i+j);
	}
	
	public void add(int i, int j, int k) {
		System.out.println("i+j+k="+i+j+k);
	}
	
	public void add(double i, double j) {
		System.out.println("i+j="+i+j);
	}
	
}
