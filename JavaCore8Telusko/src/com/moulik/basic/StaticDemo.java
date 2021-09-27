package com.moulik.basic;

/**
 * 	Static variables are those which are associated with a class and not with a particular object.
 * 	Static methods are those which are associated with a class also and are referenced using Classname unlike member methods which are referenced using Objects.
 * 
 * 	member variables are initialized inside Constructor since they are associated with particular objects.
 * 	static variables are initialized inside static block.
 * 
 * 	Since member (non-static) variables are associated with objects, they cannot be called inside static blocks/methods.
 * 
 * 	Static variables and methods are now stored in the Metaspace space of the heap. (Before Java 8, it was PermGen Space)
 * 	PermGen Space was fixed and contiguous. Metaspace is dynamic.
 * 	https://stackoverflow.com/questions/8387989/where-are-static-methods-and-static-variables-stored-in-java
 * 	
 *
 */
public class StaticDemo {

	int i = 0;
	static {
		System.out.println("In 1 static block");
	}
	
	public StaticDemo() {
		System.out.println("Inside StaticDemo Constructor");
	}
	
	public static void printa() {
		System.out.println("printing a");
	}
	
	public static void main(String[] args) {
		System.out.println("Ceo:"+Employee.ceo);
		
		System.out.println("In main method");
		Employee e1 = new Employee();
		e1.eId = "1";
		e1.salary = 4000;

		Employee e2 = new Employee();
		e2.eId = "2";
		e2.salary = 5000;
		
		System.out.println(e2.ceo);
		System.out.println(Employee.ceo);
		
		//Static variables are called with class names
		Employee.ceo = "Pillai";
		System.out.println(Employee.ceo);
		//This will not work because non-static (member) variables cannot be called in static methods/block
		//i = 9;
		
	}

}

class Employee {
	
	//member variables are stored in Heap memory
	String eId;
	int salary;
	
	//static member variables are stored in Classloader memory
	//CEO for this remains same that is why it is prefixed with static
	static String ceo; 
	
	//Static block is used to initialize static variables
	static {
		//eId = ""; This will not work because eId is a non-static (instance) variable and hence, it cannot be accessed in static block.
		ceo = "Suresh";
		System.out.println("In static block");
	}
	
	public Employee() {
		eId = "0";
		salary = 0;
		//uncommenting this below line will work but is not helpful because static variables are created at load time and this constructor will not be present.
		ceo = "Rahul"; 
		System.out.println("In constructor");
	}
	
}