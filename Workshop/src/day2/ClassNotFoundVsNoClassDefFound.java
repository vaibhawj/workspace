package day2;

public class ClassNotFoundVsNoClassDefFound {

	public static void main(String[] args) {

		// NoClassDefFoundError
		try {
			StaticClass.getConnection();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		try {
			StaticClass.getConnection();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		//

		// ClassNotFoundException

		try {
			Class.forName("day2.StaticClasss");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
