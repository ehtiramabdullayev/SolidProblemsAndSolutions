package com.epam;

public class Rectangle {

	protected double sideA;

	protected double sideB;

	public Rectangle(double sideA, double sideB) {
		this.sideA = sideA;
		this.sideB = sideB;
	}

	public double getSideA() {
		return sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public void setSize(double sideA, double sideB) {
		this.sideA = sideA;
		this.sideB = sideB;
	}

	public double area() {
		return sideA * sideB;
	}

	public double perimeter() {
		return 2 * (sideA + sideB);
	}
}
