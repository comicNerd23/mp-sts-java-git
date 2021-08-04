package com.moulik.basic;

public class StaticDemo {

	int i = 0;
	
	public static void main(String[] args) {
		
		Employee e1 = new Employee();
		e1.eId = "1";
		e1.salary = 4000;

		Employee e2 = new Employee();
		e2.eId = "2";
		e2.salary = 5000;
		
		//Static variables are called with class names
		Employee.ceo = "Pillai";
		
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
	
	//Static block is used to 
	static {
		ceo = "Suresh";
		System.out.println("In static block");
	}
	public Employee() {
		eId = "0";
		salary = 0;
		System.out.println("In constructor");
	}
	
}