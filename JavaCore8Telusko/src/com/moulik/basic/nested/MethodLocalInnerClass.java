package com.moulik.basic.nested;

public class MethodLocalInnerClass {

	public static void main(String[] args) {

		A a = new A();
		a.display();
		
	}

}
class A {
	
	public void display() {
		
		class B {
			
			int a ;
			
			public void bDisplay() {
				System.out.println("a:"+(a+10));
			}
		}
		
		B b = new B();
		b.bDisplay();
		
	}
}
