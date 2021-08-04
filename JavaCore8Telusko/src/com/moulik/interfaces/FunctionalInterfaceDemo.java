package com.moulik.interfaces;

//Interfaces are of three types
//Normal: when an interface has 2 or more methods
//Single Abstract Method: has only 1 method - from Java 8 it is called Functional interface for incorporating Lambda Expressions (Scala)
//Marker: does not have any methods eg Serializable
public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		
		Abc abc = new Abc() {
			public void show() {
				System.out.println("Inside Show");
			}
		};
		//Instead of above code, we can use lambda expressions
		Abc abcLambda = () -> System.out.println("Inside Show");
		abcLambda.show();
	}

}
@FunctionalInterface //This annotation is only for proofing purpose like @Override. We don't need it when we have an interface with only one method.
interface Abc {
	void show();
}