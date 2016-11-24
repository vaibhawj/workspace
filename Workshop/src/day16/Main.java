package day16;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		References r = new References();

	}

	static class A {

		public Integer show() throws IOException {
			return 0;
		}
	}

	static class B extends A {

		public Integer show() throws RuntimeException {
			return 0;
		}

	}

}
