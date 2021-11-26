package com.moulik.jvm;

/**
 * Method Table 
 * 
 * 
 * Assumption 1: Superclass methods are stored first
 * Assumption 2: In same class, methods are stored based on order of appearance
 * 
 * In the below scenario, JVM does not have to perform any search to perform a.foo()
 * a.foo() in X's runtime constant pool points to index 0
 * 
 * Actually in A and its subclasses, the method will stay at the same index 0 (because of our rule 1 above)
 * This, however, does not apply when the reference type is an interface rather than a class.
 * For an interface, the method can be at any position in the method table and so the JVM has to search through the table.
 * Hence, the invoking of object methods using class references is slightly faster than using Interface references.
 * 
 * Even considering this, we should still prefer using Interface ref-variables to support good OOP design (as recommended
 * in Effective Java).
 * 
 * 
 *
 */
public class MethodTable9 {
	
	public static void main(String[] args) {
		
	}
	
}
class A {
	public void staticMethod() {
		
	}
	public void foo() {
		
	}
}
interface I {
	public void bar();
}
class B extends A {
	public void staticMethod() {
		
	}
	public void norf() {
		
	}
}
class C extends A implements I {
	public void bar() {
		
	}
	public void foo() {
		
	}
}
class X {
	public void go(A a) {
		a.foo();
		a.staticMethod();
	}
}
