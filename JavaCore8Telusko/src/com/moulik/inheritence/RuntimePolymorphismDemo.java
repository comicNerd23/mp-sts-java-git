package com.moulik.inheritence;

public class RuntimePolymorphismDemo {

	public static void main(String[] args) {
		
		A a = new A();
		a.show();
		B b = new B();
		b.show();
		C c = new C();
		c.show();
		System.out.println("**********************************************");
		//JVM allows us to use a reference variable of parent class with child class object
		//The allocation of ref variable and object memory allocation happens at Compile-Time. 
		// Actually this linking of parent reference with child object happens at run-time. Hence this is called Run-time polymorphism.
		A obj = new B();	
		obj.show();//This will call B show()
		
		//obj.config(); This will give a compile time error because only those methods are visible which are present in parent.
		
		obj = new C();
		obj.show();//Here we used the parent ref-var with different child object. This is called Dynamic Method Dispatch.
	}

}
class A {
	public void show() {
		System.out.println("In A show");
	}
}
class B extends A {
	public void show() {
		System.out.println("In B show");
	}
	public void config() {
		System.out.println("In B config");
	}
}
class C extends A {
	public void show() {
		System.out.println("In C show");
	}
}