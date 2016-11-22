package day14;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		Future<Double> d = service.submit(new CallExample());
		try {
			System.out.println(d.get());
		} catch (Exception e) {
			System.out.println("Catch Exception");
			e.printStackTrace();
		}

	}

	static class CallExample implements Callable<Double> {
		@Override
		public Double call() throws Exception {
			int i = 10 / 0;
			return 100.1d;
		}
	}
}
