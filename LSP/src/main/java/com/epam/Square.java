package com.epam;

public class Square extends Rectangle {

	public Square(double length) {
		super(length, length);
	}

	@Override
	public void setSize(double sideA, double sideB) {
		this.sideA = sideA;
		this.sideB = sideA;
	}

}
