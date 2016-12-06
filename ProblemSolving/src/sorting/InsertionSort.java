package sorting;

public class InsertionSort implements ISort<Integer> {

	public static void main(String[] args) {
		InsertionSort i = new InsertionSort();
		Integer[] arr = { 10, 9, 4, 6, 7, 2, 5 };
		Integer[] sortedArr = i.sort(arr);
		i.print(sortedArr);
	}

	@Override
	public Integer[] sort(Integer[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int num = arr[i];
			while (j >= 0 && (num <= arr[j])) {
				j--;
			}
			j++;
			for (int k = i; k > j; k--) {
				arr[k] = arr[k - 1];
			}
			arr[j] = num;

		}

		return arr;
	}
}
