package com.vibe.draw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		// Triangle triangle = new Triangle();
		// BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource(
		// "spring.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");

		Shape shape = (Shape) context.getBean("circle");
		shape.draw();

		shape = (Shape) context.getBean("triangle");
		shape.draw();

	}
}
