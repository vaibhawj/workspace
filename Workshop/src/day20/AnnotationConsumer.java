package day20;

@MyAnnotation("hello annotaion")
public class AnnotationConsumer {

	public static void main(String[] args) {
		MyAnnotation an = AnnotationConsumer.class
				.getAnnotation(MyAnnotation.class);

		System.out.println(an.value());

	}

}
