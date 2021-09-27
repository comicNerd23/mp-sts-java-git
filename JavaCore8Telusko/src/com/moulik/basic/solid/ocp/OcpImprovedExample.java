package com.moulik.basic.solid.ocp;

/**
 * 	Open-closed Principle (OCP) states: Objects or entities should be open for extension but closed for modification.
 * 	This means that a class should be extendable without modifying the class itself.
 * 
 * 	Lets revisit the example of SrpImprovedDemo and specifically look at the sum method.
 *  Consider a scenario where the user would like the sum of additional shapes like triangles, pentagons, hexagons etc. You would have to constantly edit this 
 *  file and add more if/else blocks. That would violate the open-closed principle.
 * 
 * 	A way you can make this sum method better is to remove the logic to calculate the area of each shape out of the AreaCalculator class method and attach it to 
 * 	each shape’s class.
 *	But there is still another issue. How do we make sure that whatever object we are passing to AreaCalculator is actually a shape or it has an area method 
 *	defined for it?
 *	We do that by creating an interface called Shapeable (or ShapeInterface in other languages) that supports method area().
 *
 *	Coding to an interface is an integral part of SOLID.
 *
 *	Modify your shape classes to implement the Shapeable.
 *
 *	In the sum method for AreaCalculator, you can check if the shapes provided are actually instances of the ShapeInterface; otherwise, throw an exception.
 *	
 */
public class OcpImprovedExample {

	public static void main(String[] args) {
		
		Object[] objects = {new Square(5), new Circle(7)};
		AreaCalculator ac  = new AreaCalculator(objects);
		Outputter aco = new Outputter(ac);
		aco.outputToConsole();
		aco.outputAsHtml();
		aco.outputAsJson();
		
	}

}
interface Shapeable {
	public double area();
}
class Square implements Shapeable {
	
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
	@Override
	public double area() {
		return side*side;
	}
}
class Circle implements Shapeable {
	
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
	@Override
	public double area() {
		return Math.PI*radius*radius;
	}
}
/**
 * 	This class is used to calculate the area of an array of shapes. 
 * 	It has now only ONE method: 
 * 	calculateArea() to calculate the area of all shapes and sums it up.
 */
class AreaCalculator {
	
	Object[] objects;
	
	public AreaCalculator(Object[] objects) {
		this.objects = objects;
	}
		
	public double calculateSum() {
		double sum = 0;
		
		for(Object s : objects) {
			if(s instanceof Shapeable) {
				Shapeable shape =(Shapeable) s;
				sum += shape.area();
			} else {
				throw new IllegalArgumentException("object "+s+" is not a shape!");
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
