package com.moulik.interfaces;

public class MultipleInheritenceResolution {

	public static void main(String[] args) {
		
		ADemo demo = new ADemoImpl();
		demo.show();
		demo.abc();
	}

}
interface ADemo {
	void abc();
	default void show() {
		System.out.println("Demo show");
	}
}
interface MyADemo {
	default void show() {
		System.out.println("MyDemo show");
	}
}
//When we have two default methods of same name, to resolve the ambiguity, we have to define the functionality for that method in our implementation class
class ADemoImpl implements ADemo, MyADemo {

	//here we can define our own implementation for show method or we can call the implementations of any of the two interfaces using super 
	//with that interface name. Below I have called both implementations
	@Override
	public void show() {
		ADemo.super.show();
		MyADemo.super.show();
	}

	@Override
	public void abc() {
		System.out.println("Inside abc");
		
	}
	
}