package com.day3.OOPs.Shape;

public class Circle extends Shape {

	double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	@Override
	double area() {
		return Math.PI * radius * radius;
	}

	@Override
	double perimeter() {
		return 2 * Math.PI * radius;
	}
}
