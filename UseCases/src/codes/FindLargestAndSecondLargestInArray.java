package codes;

/**
 * Write program to find largest and second largest element in an unsorted array
 * 
 * @author vku147
 *
 */
public class FindLargestAndSecondLargestInArray {

	public static void main(String[] args) {

		int[] unsortedArr = { 4, 6, 1, 5, 3, 2 };

		int largest = Integer.MIN_VALUE, secLargest = Integer.MIN_VALUE;
		for (int num : unsortedArr) {
			if (num > largest) {
				secLargest = largest;
				largest = num;
			}

			if (num > secLargest && num != largest) {
				secLargest = num;
			}
		}

		System.out.println(largest);
		System.out.println(secLargest);
	}
}
