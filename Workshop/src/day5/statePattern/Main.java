package day5.statePattern;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Mario m = new Mario();
		Scanner s = new Scanner(System.in);

		while (true) {
			String c = s.next();
			m.handleInput(c);
		}

	}

}
