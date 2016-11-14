package day8.newFeatures;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo {

	public static void main(String[] args) {
		int numOfProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println(numOfProcessors);

		ForkJoinPool forkJoinPool = new ForkJoinPool(numOfProcessors);

	}
}
