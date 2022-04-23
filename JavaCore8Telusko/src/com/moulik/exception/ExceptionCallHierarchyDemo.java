package com.moulik.exception;

/**
 * How will be the exception be handled in case a class A is parent and B extends A and B has a method which throws
 * Exception
 *
 */
public class ExceptionCallHierarchyDemo {

	public static void main(String[] args) throws Exception {

		A a = new B();
		a.sayGreeting("GERMAN");
		
	}

}
class A {
	
	public void sayGreeting(String english)  {
		System.out.println("Hello World!");
	}
}
class B extends A {
	
	public void sayGreeting(String german)   {
		
		try {
			if(!german.equals("GERMAN")) {
				throw new Exception("Wrong Language requested");
			} else {
				System.out.println("Hallo Welt!");
			}
		} catch (Exception e) {
			System.out.println("E:"+e);
		}
	}
	
}