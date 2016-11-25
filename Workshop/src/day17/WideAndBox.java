package day17;

public class WideAndBox {

	public static void main(String[] args) {
		byte b = 5;
		go(b, b, b);

		int n = 10;
		// go(n);
	}

	static void go(Byte b1, Byte b2) {
		System.out.println("first");
	}

	static void go(byte... b) {
		System.out.println("second");
	}

	static void go(Long n) {
		System.out.println("number");
	}

}
