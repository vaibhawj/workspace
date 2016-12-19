package com.vibe.draw;

import org.springframework.context.MessageSource;

public class Triangle implements Shape {

	private Point pointA;
	private Point pointB;
	private Point pointC;
	private Color color;
	private MessageSource msgSource;

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

		System.out.println(msgSource.getMessage("triangle.drawn", new Object[] {
				pointA, pointB, pointC, this.color.getColorName() }, null));

	}

	public void destroy() throws Exception {
		System.out.println("Destroy called for triangle bean");

	}

	public void init() throws Exception {
		System.out.println("Triangle bean initialized");

	}

	public MessageSource getMsgSource() {
		return msgSource;
	}

	public void setMsgSource(MessageSource msgSource) {
		this.msgSource = msgSource;
	}
}
