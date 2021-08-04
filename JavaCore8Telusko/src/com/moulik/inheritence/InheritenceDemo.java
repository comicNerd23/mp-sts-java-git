package com.moulik.inheritence;

public class InheritenceDemo {

	public static void main(String[] args) {
		//Inheritence is the one of the main concepts of OOPs which allow re-use of code.

		//IS-A Cat is a Animal, so Cat Extends Animal
		//HAS-A Bathroom has a Tub, so Bathroom has an instance/object of Tub.
		
		//This is multi-level inheritence. Java does not support Multiple Inheritence directly. 
		CalculaterVeryAdvanced cva = new CalculaterVeryAdvanced();
		cva.multiply(3, 4);
		cva.subtract(10, 5);
		cva.add(3, 4);
		
		//Multiple Inheritence is when a class has two or more parent classes.
		//Java does not allow multiple inheritence directly because there is ambiguity when a class with two parent classes having same method calls that method.
		//A extends B,C
		//A.show() If show method is part of both B and C, then JVM won't know which show method to call
	}

}

class Calculater {		//Super, Parent, Base
	
	public void add(int a, int b) {
		System.out.println("Sum:"+(a+b));
	}
}

class CalculaterAdvanced extends Calculater { //Sub, Child, Derived
	
	public void subtract(int a, int b) {
		System.out.println("Difference:"+(a-b));
	}
}

class CalculaterVeryAdvanced extends CalculaterAdvanced {
	
	public void multiply(int a, int b) {
		System.out.println("Product:"+(a*b));
	}
}