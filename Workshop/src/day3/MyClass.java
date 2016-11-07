package day3;

public class MyClass {

	int i;

	public MyClass() {
		this(20);
		i = 10;

	}

	public MyClass(int id) {
		i = id;

	}

	public static void main(String[] args) {

		MyClass e = new MyClass();
		System.out.println(e.i);
	}

	static class Parent {

		public void fun() {

		}

	}

	static class Child extends Parent {
		@Override
		public void fun() {
			// TODO Auto-generated method stub
			super.fun();
		}
	}

}
