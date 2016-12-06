package sorting;

public class QuickSort implements ISort<Integer> {

	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		Integer[] arr = { 10, 9, 4, 6, 7, 2, 5 };
		Integer[] sortedArr = q.sort(arr);
		q.print(sortedArr);
	}

	@Override
	public Integer[] sort(Integer[] arr) {
		int lo = 0;
		int hi = arr.length - 1;

		quickSort(arr, lo, hi);

		return arr;
	}

	private void quickSort(Integer[] arr, int lo, int hi) {
		if (lo < hi) {
			int p = partition(arr, lo, hi);
			quickSort(arr, lo, p - 1);
			quickSort(arr, p + 1, hi);
		}

	}

	private int partition(Integer[] arr, int lo, int hi) {
		int pivot = arr[hi];
		int i = lo;
		for (int j = lo; j < hi; j++) {
			if (arr[j] <= pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, hi);
		return i;
	}

	private void swap(Integer[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
