package com.moulik.inheritence;

public class SuperDemo {

	public static void main(String[] args) {
		Bbb b = new Bbb(4);
		
	}

}
class Aaa {
	public Aaa() {
		System.out.println("Inside A");
	}
	public Aaa(int i) {
		System.out.println("Inside A int");
	}
}
class Bbb extends Aaa {
	public Bbb() {
		//Super keyword is used to call the constructor of parent class
		super();	//This is added by default in all constructors of child classes. To override this behavior, we add super explicitly.
		System.out.println("Inside B");
	}
	public Bbb(int i) {
		super(i);
		System.out.println("Inside B int");
	}
}