package com.vibe.draw;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		// Triangle triangle = new Triangle();
		// BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource(
		// "spring.xml"));
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();

		Shape shape = (Shape) context.getBean("circle");
		shape.draw();

	}
}
