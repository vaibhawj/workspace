package backtracking;

import java.util.HashSet;
import java.util.Set;

public class PermutationOfAString {

	public static void main(String[] args) {

		String s = "ABCD";
		Set<String> set = new HashSet<>();

		findPermutation(s, 0, set);

		System.out.println(set);
		System.out.println(set.size());

	}

	private static void findPermutation(String s, int n, Set<String> set) {

		if (n == s.length() - 1) {
			return;
		}

		for (int i = n; i < s.length(); i++) {
			s = swap(s, n, i);
			set.add(s);
			findPermutation(s, n + 1, set);
		}

	}

	private static String swap(String s, int i, int j) {
		char[] charArr = s.toCharArray();
		char temp = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = temp;

		return new String(charArr).intern();
	}

}
