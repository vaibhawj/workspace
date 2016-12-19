package com.vibe.draw;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent {

	private Object source;

	public DrawEvent(Object source) {
		super(source);
		this.source = source;
	}

	@Override
	public String toString() {
		return "Draw event -> " + super.toString();
	}
}
