package day7;

public class Main {

	public static void main(String[] args) {
		try {
			fun();
		} catch (Exception e) {
			System.out.println("Runtime exp occured");
		}

		// gun();
	}

	public static void fun() {
		throw new MyRunTimeException();
	}

	public static void gun() throws MyException {
		throw new MyException();
	}

}
