package com.vibe.draw;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;

public class Circle implements Shape, ApplicationEventPublisherAware {

	private Point center;
	private MessageSource msgSource;
	private ApplicationEventPublisher publisher;

	public MessageSource getMsgSource() {
		return msgSource;
	}

	public void setMsgSource(MessageSource msgSource) {
		this.msgSource = msgSource;
	}

	public Point getCenter() {
		return center;
	}

	@Required
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println(msgSource.getMessage("circle.drawn",
				new Object[] { this.center }, null));
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);

	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

}
