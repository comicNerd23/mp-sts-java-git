package com.moulik.basic;

public class ObjectDemo {

	public static void main(String[] args) {
		
		//A "class" is a blueprint which the JVM uses to create "objects".
		//An object knows something (data) and does something (behaviour).
		Calc obj;
		obj = new Calc();
		obj.num1 = 3;
		obj.num2 = 6;
		obj.performAdd();
		System.out.println("Result:"+obj.result);

	}

}

//Calculator Class
class Calc {
	
	//Instance Variables
	int num1;
	int num2;
	int result;
	
	//Member methods
	public void performAdd() {
		result = num1 + num2;
	}
	
	//Constructor is the member method that is used to create objects (that is used to allocate memory and so on).
	//It has the same name as the class name.
	//It will never return anything
	//It will be used to allocate memory
	public Calc() {
		//Default Constructor is given by JVM and it only allocates memory
	}
	
	public Calc(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
}
