package com.moulik.codingInterview;

public class ExceptionsInInheritence {
	
	public static void main(String[] args) {
		
	}

}
class A {
	
	public void display() {
		System.out.println("display A");
	}
}
class B extends A {
	
	@Override
	public void display() throws IndexOutOfBoundsException {
		System.out.println("display B");
		throw new IndexOutOfBoundsException();
	}
}