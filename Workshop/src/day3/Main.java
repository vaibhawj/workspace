package day3;

abstract class Base {
	public int x = 1;

	public Base() {
		foo();
	}

	public abstract void foo();
}

class Derived extends Base {
	int x = 2;

	@Override
	public void foo() {
		System.out.println("Derived: " + x);
	}
}

class Main {
	public static void main(String... args) {
		Base base = new Derived();
		base.foo();
	}
}