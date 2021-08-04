package com.moulik.encapsulation;

//Encapsulation is the concept of binding data with methods.
//In Java, we make the access of methods public and instance variables private
//Why this is used is for 2 reasons:
//1. This way we can make sure whenever someone is accessing the data, it can be logged.
//2. We can have some code in the methods which makes sure the data can be accessed by authenticated users.
public class EncapsulationDemo {

	public static void main(String[] args) {

		Employee e = new Employee();
		e.setEmpId(101);
		e.setName("Rahul");
		
		System.out.println("Name of employee:"+e.getName());
	}

}
class Employee {
	
	//Private member variables
	private int empId;
	private String name;
	//Public accessor methods
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		//if(user.isAuthenticated()) {	We are trying to make sure that only authenticated user can change the data
			this.empId = empId;
		//}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("Changing the Name!!");
	}
	
}
