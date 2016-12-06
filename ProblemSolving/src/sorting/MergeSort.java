package sorting;

public class MergeSort implements ISort<Integer> {

	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		Integer[] arr = { 10, 9, 4, 6, 7, 2, 5 };
		Integer[] sortedArr = m.sort(arr);
		m.print(sortedArr);
	}

	@Override
	public Integer[] sort(Integer[] arr) {
		int left = 0;
		int right = arr.length - 1;
		mergeSort(arr, left, right);
		return arr;
	}

	private void mergeSort(Integer[] arr, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;

			mergeSort(arr, left, middle);

			mergeSort(arr, middle + 1, right);

			merge(arr, left, middle, right);

		}

	}

	private void merge(Integer[] arr, int left, int middle, int right) {

		int lengthOfLeftArr = middle - left + 1;
		int lengthOfRightArr = right - middle;
		int leftArr[] = new int[lengthOfLeftArr];
		int rightArr[] = new int[lengthOfRightArr];

		for (int i = 0; i < lengthOfLeftArr; i++) {
			leftArr[i] = arr[left + i];
		}

		for (int i = 0; i < lengthOfRightArr; i++) {
			rightArr[i] = arr[middle + 1 + i];
		}

		int i = 0, j = 0;
		int k = left;

		while (i < lengthOfLeftArr && j < lengthOfRightArr) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}

		while (i < lengthOfLeftArr) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}

		while (j < lengthOfRightArr) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}

	}

}
