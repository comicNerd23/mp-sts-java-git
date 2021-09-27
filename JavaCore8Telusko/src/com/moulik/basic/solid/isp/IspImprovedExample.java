package com.moulik.basic.solid.isp;


/**
 * Interface segregation principle states: A client should never be forced to implement an interface that it doesn’t use, or clients shouldn’t be forced to 
 * depend on methods they do not use.
 * 
 * Still building from the previous ShapeInterface example, you will need to support the new three-dimensional shapes of Cuboid and Spheroid, and these shapes 
 * will need to also calculate volume.
 * 
 * If you see the previous example, any shape you create must implement the volume method but you know that Square and Circles are actually 2D shapes and do not 
 * have volume. So this interface would force the Square class to implement a method that it has no use of.
 * This would violate the interface segregation principle. Instead, you could create another interface called ThreeDimensionalShapeInterface that has the volume 
 * contract and three-dimensional shapes can implement this interface:
 * 	interface ThreeDimensionalShapeInterface
 * {
 * 		public function volume();
 * }
 * 
 * This is a much better approach, but a pitfall to watch out for is when type-hinting these interfaces. Instead of using a ShapeInterface or a 
 * ThreeDimensionalShapeInterface, you can create another interface, maybe ManageShapeInterface, and implement it on both the flat and three-dimensional shapes.
 *
 * This way, you can have a single API for managing the shapes:
 */
public class IspImprovedExample {

	public static void main(String[] args) {

		Square s = new Square(7);
		Circle ci = new Circle(7);
		Cuboid cu = new Cuboid(8, 4, 4);
		Object[] objects = {cu};
		VolumeCalculator vc = new VolumeCalculator(objects);
		Outputter op = new Outputter(vc);
		op.outputToConsole();
		
	}

}

interface Shapeable {
	public double area();
}
interface ThreeDimShape {
	public double volume();
}
interface ManageShape {
	public double calculate();
}
class Square implements Shapeable, ManageShape {
	
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
	public double calculate() {
		return area();
	}
	
}
class Circle implements Shapeable, ManageShape {
	
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
	public double calculate() {
		return area();
	}
}
class Cuboid implements Shapeable, ThreeDimShape, ManageShape {
	
	private int length;
	private int width;
	private int height;
	
	public Cuboid(int length, int width, int height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}
	public int getLength() {
		return length;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public void construct() {
		System.out.println("Constructed Cuboid");
	}
	@Override
	public double area() {
		return 2*(length*width + width*height + height*length);
	}
	@Override
	public double volume() {
		return length*width*height;
	}
	@Override
	public double calculate() {
		return area();
	}
}
/**
 * 	This class is used to calculate the area of an array of shapes. 
 * 	It has now only ONE method: 
 * 	calculateSum() to calculate the area of all shapes and sums it up.
 */
class AreaCalculator {
	
	Object[] objects;
	
	public AreaCalculator(Object[] objects) {
		this.objects = objects;
	}
		
	public double calculateSum() {
		double sum = 0;
		
		for(Object s : objects) {
			if(s instanceof ManageShape) {
				ManageShape shape =(ManageShape) s;
				sum += shape.calculate();
			} else {
				throw new IllegalArgumentException("object "+s+" is not a shape!");
			}
		}
		return sum;
	}
	
}
/**
 * 	This class is used to calculate the volume of an array of objects. 
 * 	It has now only ONE method: 
 * 	calculateSum() to calculate the volume of all shapes and sums it up.
 */
class VolumeCalculator extends AreaCalculator {

	public VolumeCalculator(Object[] objects) {
		super(objects);
	}
	
	public double calculateSum() {
		//double[] sum = new double[this.objects.length];
		double sum = 0;
		for(Object s : objects) {
			if(s instanceof ThreeDimShape) {
				ThreeDimShape shape =(ThreeDimShape) s;
				sum  += shape.volume();
			} else {
				throw new IllegalArgumentException("object "+s+" is not a 3D Shape!");
			}
		}
		return sum;
	}
	
}
/**
 * 	This class is used to output the calculatedSum. 
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