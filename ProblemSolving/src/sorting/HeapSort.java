package sorting;

public class HeapSort implements ISort<Integer> {

	public static void main(String[] args) {
		HeapSort h = new HeapSort();
		Integer[] arr = { 4, 10, 9, 6, 7, 2, 5 };
		h.print(arr);
		Integer[] sortedArr = h.sort(arr);
		h.print(sortedArr);
	}

	@Override
	public Integer[] sort(Integer[] arr) {

		for (int i = 0; i < arr.length; i++) {
			maxHeapify(arr, i);
			swap(arr, 0, arr.length - 1 - i);
		}
		return arr;
	}

	private void maxHeapify(Integer[] arr, int n) {
		int max = Integer.MIN_VALUE;
		int j = -1;
		int size = arr.length - n;
		for (int i = 0; i < size; i++) {
			if (arr[i] > max) {
				max = arr[i];
				j = i;
			}
		}

		swap(arr, 0, j);
	}

	private void swap(Integer[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
