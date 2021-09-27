package com.moulik.interfaces;
//Interface are used to just have a behavior outline. Some objects have certain common behaviour.
//This behaviour can be outlined (declared, not defined) in the Interface. Each object that implements this interface can define the behaviour their own way.
//Another advantage of using interface is multiple behaviors can be implemented by a class. However, class can extend only once.
//When we are creating a project, if we don't know all the features that are required, we should first add(declare) them in interfaces. This way, it can be
//made kind of future-proof
//Real-life scenario: APIs like Facebook, Twitter etc are actually interfaces because they declare the behaviour of such apps which can then be implemented
// by the program accessing those APIs.
public class InterfaceDemo {

	public static void main(String[] args) {
		Writer writer = new Pen();	//Similar to how a parent class ref-var can be assigned to a child class, an interface ref-var can be assigned to it too
		writer.write();
		writer = new Pencil();
		writer.write();
	}

}
//Interface can only declare methods not define them. Abstract classes can do both.
//All methods in an interface are abstract by default. From Java 8, default methods are introduced.
interface Writer {
	void write();
}
class Pen implements Writer {

	@Override
	public void write() {
		System.out.println("Pen is writing");
	}
	
}
class Pencil implements Writer {

	@Override
	public void write() {
		System.out.println("Pencil is writing");
	}
	
}