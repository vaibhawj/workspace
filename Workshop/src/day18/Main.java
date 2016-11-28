package day18;

public class Main {

	public static void main(String[] args) {
		String s = "ONE" + 1 + 2 + "TWO" + "THREE" + 3 + 4 + "FOUR" + "FIVE"
				+ 5;

		System.out.println(s);
	}

	static class A {

		public A(int n) {
			// TODO Auto-generated constructor stub
		}

	}

	static class B extends A {

		public B(int n) {
			super(n);
			// TODO Auto-generated constructor stub
		}

	}

}
