package com.moulik.basic.solid;

/**
 *	SRP states that "A class should have one and only one reason for change, meaning that a class should have only one job."
 *	
 *	Consider an app that takes a collection of shapes - circles and squares - and calculates the sum of the area of all the shapes of the collection.
 *	
 *	The problem with the output method is that the AreaCalculator handles the logic to output the data. 
 *	Consider a scenario where the output should be converted to another format like JSON. 
 *	All of the logic would be handled by the AreaCalculator class. This would violate the single-responsibility principle. The AreaCalculator class should only
 *	be concerned with the sum of the areas of provided shapes. It should not care whether the user wants JSON or HTML.
 *
 *	To address this, you can create a separate SumCalculatorOutputter class and use that new class to handle the logic you need to output the data to the user.
 *	Check SrpImprovedExample.
 *	
 */
public class NonSrpExample {

	public static void main(String[] args) {
		Square sq = new Square(5);
		Circle ci = new Circle(7);
		AreaCalculator ac = new AreaCalculator(new Object[] {sq,ci});
		ac.output();
	}

}
class Square {
	
	private int side;
	
	public Square(int side) {
		this.side = side;
	}
	public int getSide() {
		return side;
	}
	
	public void construct() {
		System.out.println("Constructed Square with side:"+side);
	}
}
class Circle {
	
	private int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	public int getRadius() {
		return radius;
	}
	
	public void construct() {
		System.out.println("Constructed Circle with radius:"+radius);
	}
}
/**
 * 	This class is used to calculate the area of an array of shapes. 
 * 	It has two methods: 
 * 	calculateArea() to calculate the area of all shapes and sums it up.
 * 	output() to print the result on console.
 *
 */
class AreaCalculator {
	
	Object[] objects;
	
	public AreaCalculator(Object[] shapes) {
		this.objects = shapes;
	}
		
	public double calculateSum() {
		double sum = 0;
		for(Object s : objects) {
			if(s instanceof Square) {
				Square sq = (Square) s;
				sum += sq.getSide()*sq.getSide();
			} else if (s instanceof Circle) {
				Circle ci = (Circle) s;
				sum += Math.PI*ci.getRadius()*ci.getRadius();
			}
		}
		return sum;
	}
	
	public void output() {
		System.out.println("The sum is "+calculateSum());
	}
}
