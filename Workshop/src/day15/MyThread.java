package day15;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread extends Thread implements Callable<Long> {

	public static void main(String[] args) {
		MyThread t = new MyThread();

		ExecutorService e = Executors.newSingleThreadExecutor();
		// e.submit(t);
	}

	@Override
	public Long call() throws Exception {

		return 12l;
	}

}
