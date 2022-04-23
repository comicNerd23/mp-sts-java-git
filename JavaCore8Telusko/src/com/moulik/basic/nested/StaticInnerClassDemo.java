package com.moulik.basic.nested;

/**
 * Static nested class is a class which is static that is, it is associated with the class and not the object and hence 
 * it can be referenced using Classname only.
 *
 * 
 */
public class StaticInnerClassDemo {
	
	public static void main(String[] args) {
		
		Outer1.Inner1 newInner = new Outer1.Inner1();
		newInner.display();
		
	}

}

class Outer1 {
	
	// A class can have variables, methods and also CLASSES
	int i;
	static int x;
	
	public void perform() {
		System.out.println("Perform");
	}
	
	//Inner Class
	static class Inner1 {
		
		public void display() {
			System.out.println("Display:"+x);
			//System.out.println("Display:"+i); This line will not compile because a static variable can only be 
			//accessed from inside static method/block/class.
		}
		
	}
}
