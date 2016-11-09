package day4.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonBreakerThroughReflection {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {

		Class<MySingleton> cls = MySingleton.class;
		Constructor cons[] = cls.getDeclaredConstructors();
		Constructor con = cons[0];
		con.setAccessible(true);

		MySingleton s1 = (MySingleton) con.newInstance(null);
		System.out.println(s1);
		MySingleton s2 = MySingleton.getInstance();
		System.out.println(s2);

	}
}
