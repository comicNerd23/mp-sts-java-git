package com.moulik.basic;
//Nested Classes are of two types:
//1. Static nested classes: can access non-static members of outer class using objects, that's why they are rarely used
//2. NonStatic nested classes or Inner Classes: has access to all variables and methods of its outer class
// Inner classes are of three types:
//	i. Inner Class: Explained below
//  ii. Method Local Inner Class: Can be instantiated only within the method where the inner class is defined.
//  iii. Anonymous Inner Class: Class declared without a class name. It is declared and instantiated at the same time. Further explained later
public class InnerClassDemo {

	public static void main(String[] args) {
		
		Outer outer = new Outer();
		outer.perform();
		
		Outer.Inner inner = outer.new Inner();
		inner.display();
	}

}

class Outer {
	
	// A class can have variables, methods and also CLASSES
	
	int x;
	
	public void perform() {
		System.out.println("Perform");
	}
	
	//Inner Class
	class Inner {
		
		public void display() {
			System.out.println("Display");
		}
		
	}
}