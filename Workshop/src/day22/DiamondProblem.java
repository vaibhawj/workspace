package day22;

public class DiamondProblem {

	public static void main(String[] args) {
		Impl o = new Impl();
		o.m();
	}

}

interface Int1 {

	default void m() {
		System.out.println("Int1");
		hello();
	}

	void hello();

}

interface Int2 {

	default void m() {
		System.out.println("Int2");
	}
}

class Impl implements Int1, Int2 {

	@Override
	public void m() {
		Int1.super.m();
	}

	@Override
	public void hello() {
		System.out.println("hello");

	}

}
