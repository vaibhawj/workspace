package rec;

public class FibonacciSeries {

	public static void main(String[] args) {

		for (int i = 0; i < 9; i++) {
			System.out.println(i + "=" + fibonacci(i));
		}

	}

	private static int fibonacci(int n) {
		if (n <= 1) {
			if (n < 0) {
				return 0;
			}
			return n;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
