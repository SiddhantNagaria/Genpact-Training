package com.day3.OOPs.Shape;

public class ShapeApp {

	public static void main(String[] args) {
		// Circle
		Circle c = new Circle(5);
		System.out.println("area of circle  " + c.area());
		System.out.println("perimeter of circle  " + c.perimeter());

		// Rectangle
		Rectangle r = new Rectangle(4, 5);

		System.out.println("area of rectangle  " + r.area());
		System.out.println("perimeter of rectangle  " + r.perimeter());

	}

}
