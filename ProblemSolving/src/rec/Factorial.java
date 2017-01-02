package rec;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(factorial(n));
		in.close();

	}

	private static int factorial(int n) {
		if (n == 0)
			return 1;

		return n * factorial(n - 1);
	}

}
