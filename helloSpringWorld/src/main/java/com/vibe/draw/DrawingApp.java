package com.vibe.draw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		// Triangle triangle = new Triangle();
		// BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource(
		// "spring.xml"));
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"spring.xml");

		Triangle triangle = (Triangle) appContext.getBean("triangle");
		triangle.draw();

		Point p1 = (Point) appContext.getBean("pointA");
		Point p2 = (Point) appContext.getBean("pointA");

		System.out.println(p1 == p2);

	}
}
