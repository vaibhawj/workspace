package largestAndSecLargest;

/**
 * Write program to find largest and second largest element in an unsorted array
 * 
 * @author vku147
 *
 */
public class FindLargestAndSecondLargestInArray {

	public class Result {

		private int largest;

		private int secondLargest;

		public Result(int largest, int secondLargest) {
			this.largest = largest;
			this.secondLargest = secondLargest;
		}

		public int getLargest() {
			return largest;
		}

		public int getSecondLargest() {
			return secondLargest;
		}

	}

	public Result findLargestAndSecondLargest(int[] arr) {
		int largest = Integer.MIN_VALUE, secLargest = Integer.MIN_VALUE;
		for (int num : arr) {
			if (num > largest) {
				secLargest = largest;
				largest = num;
			}

			if (num > secLargest && num != largest) {
				secLargest = num;
			}
		}

		return new Result(largest, secLargest);

	}

}
