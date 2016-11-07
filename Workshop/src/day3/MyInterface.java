package day3;

public interface MyInterface {

	public static void main(String[] s) {
		InsideClass c = new InsideClass();
		System.out.println("here " + c.s);
	}

	static class InsideClass {

		private String s = "blah";

	}

}
