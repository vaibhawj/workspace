package sorting;

public class BubbleSort implements ISort<Integer> {

	public static void main(String[] args) {
		BubbleSort b = new BubbleSort();
		Integer[] arr = { 10, 9, 4, 6, 7, 2, 5 };
		Integer[] sortedArr = b.sort(arr);
		b.print(sortedArr);
	}

	@Override
	public Integer[] sort(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}
		return arr;
	}

}
