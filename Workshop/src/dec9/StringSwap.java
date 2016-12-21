package dec9;

public class StringSwap {

	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "ef";

		s1 = s1 + s2;
		s2 = s1.substring(0, s1.indexOf(s2));
		s1 = s1.substring(s2.length());

		System.out.println(s1);
		System.out.println(s2);

	}

}
