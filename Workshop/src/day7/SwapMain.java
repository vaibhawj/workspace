package day7;

public class SwapMain {

	public static void main(String[] args) {
		int s1 = 5;
		int s2 = 10;
		System.out.println(s1);
		// System.out.println(s1.toString() + " " + s2.toString());
		swap(s1, s2);
		// System.out.println(s1.toString() + " " + s2.toString());
		System.out.println(s1);
	}

	private static void swap(int s1, int s2) {
		System.out.println(s1);
		int tmp;
		tmp = s1;
		s1 = s2;
		s2 = tmp;
		System.out.println(s1);

	}

	static class MyString {

	}

}
