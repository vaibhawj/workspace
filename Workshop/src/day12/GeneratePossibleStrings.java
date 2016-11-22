package day12;

import java.util.HashSet;

public class GeneratePossibleStrings {

	public static void main(String[] args) {

		String s = "abc";
		GeneratePossibleStrings g = new GeneratePossibleStrings();

		HashSet<String> set = new HashSet<String>();
		g.getAllPossibleStrings(s, set);
		System.out.println(set);

	}

	private void getAllPossibleStrings(String s, HashSet<String> set) {

	}
}
