package day19.rec;

public class StringReversal {

	public static void main(String[] args) {
		StringReversal s = new StringReversal();
		System.out.println(s.reverse("abcde"));
	}

	public String reverse(String s) {

		if (s.length() == 0) {
			return "";
		}

		return s.charAt(s.length() - 1) + ""
				+ reverse(s.substring(0, s.length() - 1));

	}
}
