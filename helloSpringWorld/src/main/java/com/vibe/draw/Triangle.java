package com.vibe.draw;

public class Triangle implements Shape {

	private Point pointA;
	private Point pointB;
	private Point pointC;
	private Color color;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	@Override
	public void draw() {

		System.out.println("Triangle drawn with points - ");
		System.out.println("Point A " + pointA);
		System.out.println("Point B " + pointB);
		System.out.println("Point C " + pointC);
		System.out.println("Color is " + color.getColorName());

	}

	public void destroy() throws Exception {
		System.out.println("Destroy called for triangle bean");

	}

	public void init() throws Exception {
		System.out.println("Triangle bean initialized");

	}
}
