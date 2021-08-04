package com.moulik.interfaces;
//Anonymous inner class is a class which does not have a name and it's scope is limited to its enclosing class.
//It is used when making an instance of an object with certain “extras” such as overloading methods of a class or interface,
//without actually having to subclass a class
public class AnonymousInnerClassDemo {

	public static void main(String[] args) {
		A a = new A();
		a.show();
		//Here we are defining a class which is a subclass of A, but we are not explicitly declaring a subclass
		A anonymousA = new A() {
			public void show() {
				System.out.println("show in AnonymousInnerClass");
			}
		};
		anonymousA.show();
	}

}
class A {
	public void show() {
		System.out.println("show in A");
	}
}