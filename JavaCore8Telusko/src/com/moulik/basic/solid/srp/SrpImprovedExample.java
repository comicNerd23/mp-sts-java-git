package com.moulik.basic.solid.srp;


/**
 * As you can see we have separated the output() method in its own class. So, if we want add another method of output in future, we can add that in this class
 * only and don't need to modify any other class.	
 *
 */
public class SrpImprovedExample {

	public static void main(String[] args) {
		Object[] objects = {new Square(5), new Circle(7)};
		AreaCalculator ac  = new AreaCalculator(objects);
		Outputter aco = new Outputter(ac);
		aco.outputToConsole();
		aco.outputAsHtml();
		aco.outputAsJson();
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
 * 	It has now only ONE method: 
 * 	calculateArea() to calculate the area of all objects and sums it up.
 */
class AreaCalculator {
	
	Object[] shapes;
	
	public AreaCalculator(Object[] shapes) {
		this.shapes = shapes;
	}
		
	public double calculateSum() {
		double sum = 0;
		for(Object s : shapes) {
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
	
	
}
/**
 * 	This class is used to output the calculatedAreaSum. 
 * 	It has now only ONE method: 
 * 	output(): to output the area
 */
class Outputter {
	
	private AreaCalculator ac;
	
	public Outputter(AreaCalculator ac) {
		this.ac = ac;
	}
	
	public void outputToConsole() {
		System.out.println("The sum is "+ac.calculateSum());
	}
	
	public void outputAsHtml() {
		System.out.println("The html sum is "+ac.calculateSum());
	}
	
	public void outputAsJson() {
		System.out.println("The json sum is "+ac.calculateSum());
	}
	
}
