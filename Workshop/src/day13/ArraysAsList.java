package day13;

import java.util.Arrays;
import java.util.List;

public class ArraysAsList {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		List<int[]> list = Arrays.asList(arr);
		int[] n = { 4 };
		list.set(1, n);
		// list.add(n);
		System.out.println(arr.length);
		System.out.println(list.size());

	}
}
