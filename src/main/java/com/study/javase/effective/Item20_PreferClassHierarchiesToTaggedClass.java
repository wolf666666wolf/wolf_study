package com.study.javase.effective;

public class Item20_PreferClassHierarchiesToTaggedClass {

}

/**
 * Bad example
 * @author BULL
 *
 */
// Tagged class - vastly inferior to a class hierarchy!
class Figure_BadExample {
	enum Shape {
		RECTANGLE, CIRCLE
	};

	// Tag field - the shape of this figure
	final Shape shape;
	// These fields are used only if shape is RECTANGLE
	double length;
	double width;
	// This field is used only if shape is CIRCLE
	double radius;

	// Constructor for circle
	Figure_BadExample(double radius) {
		shape = Shape.CIRCLE;
		this.radius = radius;
	}

	// Constructor for rectangle
	Figure_BadExample(double length, double width) {
		shape = Shape.RECTANGLE;
		this.length = length;
		this.width = width;
	}

	double area() {
		switch (shape) {
		case RECTANGLE:
			return length * width;
		case CIRCLE:
			return Math.PI * (radius * radius);
		default:
			throw new AssertionError();
		}
	}
}







//Class hierarchy replacement for a tagged class
abstract class Figure {
	abstract double area();
}

class Circle extends Figure {
	final double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	double area() {
		return Math.PI * (radius * radius);
	}
}

class Rectangle extends Figure {
	final double length;
	final double width;

	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	double area() {
		return length * width;
	}
}