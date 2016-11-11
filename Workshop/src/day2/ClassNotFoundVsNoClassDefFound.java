package day2;

public class ClassNotFoundVsNoClassDefFound {

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		Class clss = null;
		try {
			clss = Class.forName("day2.StaticClass");
		} catch (Error e) {

		}

		Object o = clss.newInstance();

		System.out.println(o);

	}
}
