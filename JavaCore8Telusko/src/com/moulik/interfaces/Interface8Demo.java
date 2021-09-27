package com.moulik.interfaces;
//Till Java 7, Abstract Class can have both abstract and non-abstract methods, that is, it can both declare and define methods,
//while interfaces can only declare methods.
//From Java 8, we can define methods in interfaces. These methods have to be default or static. Default methods can be overridden, static methods cannot.
//From Java 8, we can also have variables in interfaces but these variables are always final.
public class Interface8Demo {

	public static void main(String[] args) {
		Demo demo = new DemoImp();
		demo.show();
		Demo.simpleMethod();
	}

}
@FunctionalInterface
interface Demo {
	//This variable is implicitly made final by JVM
	int num = 8;
	void abc();
	default void show() {
		System.out.println("Default Show");
	}
	
	static void simpleMethod() {
		System.out.println("simple method");
	}
}
class DemoImp implements Demo {
	
	public void abc() {
		System.out.println("Implemented abc");
	}
	//Default methods can be overridden
	public void show() {
		System.out.println("Overridden Show");
	}
}