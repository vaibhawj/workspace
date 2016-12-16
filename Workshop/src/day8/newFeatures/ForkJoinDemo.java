package day8.newFeatures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinDemo {

	public static void main(String[] args) {
		int numOfProcessors = Runtime.getRuntime().availableProcessors();

		ForkJoinPool forkJoinPool = new ForkJoinPool(numOfProcessors);
		int size = 10;
		int solvableSize = 3;
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = i;
		}

		System.out.println("original");
		printArr(arr);

		forkJoinPool.execute(new MyTask(arr, 0, arr.length));

	}

	static class MyTask extends RecursiveAction {

		private int[] arr;
		private int start;
		private int end;

		public MyTask(int[] arr, int start, int end) {
			this.arr = arr;
			this.start = start;
			this.end = end;
		}

		@Override
		protected void compute() {
			if (arr.length <= 3) {
				for (int i = start; i < end; i++) {
					arr[i] = arr[i] + 1;
				}

				printArr(arr);

			} else {
				int mid = (start + end) / 2;
				MyTask task1 = new MyTask(arr, start, mid);
				MyTask task2 = new MyTask(arr, mid + 1, end);
				List<MyTask> list = new ArrayList<>();
				list.add(task1);
				list.add(task2);
				invokeAll(list);

			}

		}
	}

	public static void printArr(int arr[]) {
		for (int n : arr) {
			System.out.print(n + " ");
		}

	}
}
