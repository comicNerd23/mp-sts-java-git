package com.moulik.interfaces;
//Sometimes we don't require to create objects of some classes. But we require the blueprint of these classes to create other child classes.
//Such classes we can have as Abstract
public class AbstractDemo {

	public static void main(String[] args) {

		//Human human = new Human(); this will give a compile time error.
		Human man = new Man();
		man.eat();
	}

}
abstract class Human {
	public abstract void eat();	//Whenever a class has an abstract method, it has to be an abstract class
	public void walk() {
		
	}
}
//When a class extends an abstract class, it has to implement the abstract methods of parent class.
class Man extends Human {	//Concrete class

	@Override
	public void eat() {
		System.out.println("Man is eating");
		
	}
	
}