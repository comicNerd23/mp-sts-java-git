package com.moulik.basic.solid.lsp;


/**
 *  Liskov Substitution Principle states: Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S 
 *  where S is a subtype of T.
 *  This means that every subclass or derived class should be substitutable for their base or parent class.
 *  
 *  Building off the example AreaCalculator class, consider a new VolumeCalculator class that extends the AreaCalculator class:
 *  	where VolumeCalculator gives the sum of volumes of the various shapes in the form of array instead of double.
 *	Recall that the Outputter class resembles this:
 *	If you tried to run an example like this:
 *		VolumeCalculator ac  = new VolumeCalculator(objects);
 *		Outputter aco = new Outputter(ac);
 *		aco.outputToConsole();
 *	In that case, LSP will fail because the property of calculateSum() does not give the intended result because array is not convertible to double.
 *	Java compiler specifically does not allow a overridden method in a child class to return a type other than that in parent class. 
 *	 
 */
public class LspImprovedExample {

	public static void main(String[] args) {

		Object[] objects = {new Square(5), new Circle(7)};
		VolumeCalculator ac  = new VolumeCalculator(objects);
		Outputter aco = new Outputter(ac);
		aco.outputToConsole();
		aco.outputAsHtml();
		aco.outputAsJson();
		
	}

}
class VolumeCalculator extends AreaCalculator {

	public VolumeCalculator(Object[] objects) {
		super(objects);
	}
	
	public double calculateSum() {
		//double[] sum = new double[this.objects.length];
		double sum = 0;
		for(Object s : objects) {
			if(s instanceof Shapeable) {
				Shapeable shape =(Shapeable) s;
				sum  += shape.volume();
			} else {
				throw new IllegalArgumentException("object "+s+" is not a 3D Shape!");
			}
		}
		return sum;
	}
	
}
interface Shapeable {
	public double area();
	public double volume();
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
	@Override
	public double volume() {
		return 0; //A square does not have volume
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
	@Override
	public double volume() {
		return 0;	//A circle does not have volume
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

