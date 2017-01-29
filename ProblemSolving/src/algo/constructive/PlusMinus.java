package algo.constructive;

import java.util.Scanner;

public class PlusMinus {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double n = in.nextInt();

		double countOfMinus = 0;
		double countOfPlus = 0;
		double countOfZeroes = 0;

		double num;
		for (int i = 0; i < n; i++) {
			num = in.nextInt();
			if (num < 0) {
				countOfMinus++;
			} else if (num > 0) {
				countOfPlus++;
			} else {
				countOfZeroes++;
			}
		}
		in.close();

		System.out.println(format(countOfPlus / n));
		System.out.println(format(countOfMinus / n));
		System.out.println(format(countOfZeroes / n));

	}

	public static String format(double num) {
		return String.format("%.6f", num);
	}

	public static void main1(String[] args) {

		double countOfPlus = 3d;
		double n = 6d;
		double countOfMinus = 2d;
		double countOfZeroes = 1d;

		System.out.println(format(countOfPlus / n));

		System.out.println(format(countOfMinus / n));

		System.out.println(format(countOfZeroes / n));

	}

}
