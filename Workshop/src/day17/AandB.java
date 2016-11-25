package day17;

public class AandB {

	public static void main(String[] args) {
		A a = new B();
		a.fun();

	}

	static class A {
		private void fun() {
			System.out.println("A's fun");
		}
	}

	static class B extends A {
		public void fun() {
			System.out.println("B's fun");
		}
	}

}
