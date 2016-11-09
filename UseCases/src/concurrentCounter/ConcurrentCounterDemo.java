package concurrentCounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentCounterDemo {

	public static void main(String[] args) {
		ConcurrentCounter counter = new ConcurrentCounter();
		ExecutorService ex = Executors.newFixedThreadPool(3);

		ex.submit(new MyJob(counter));
		ex.submit(new MyJob(counter));
		ex.submit(new MyJob(counter));

		ex.shutdown();

	}

	static class MyJob implements Runnable {

		private ConcurrentCounter counter;

		public MyJob(ConcurrentCounter counter) {
			this.counter = counter;
		}

		@Override
		public void run() {

			System.out.println(Thread.currentThread().getName()
					+ " increments from " + counter.get() + " to "
					+ counter.incrementAndGet());

		}

	}

}
