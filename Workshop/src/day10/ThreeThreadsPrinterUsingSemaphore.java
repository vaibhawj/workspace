package day10;

import java.util.concurrent.Semaphore;

public class ThreeThreadsPrinterUsingSemaphore {

	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(1);
		Counter counter = new Counter(1);

		Thread t1 = new Thread(new Printer(counter, semaphore, 1), "T1");
		Thread t2 = new Thread(new Printer(counter, semaphore, 2), "T2");
		Thread t3 = new Thread(new Printer(counter, semaphore, 0), "T3");

		t3.start();
		t2.start();
		t1.start();

	}

	static class Printer implements Runnable {

		private Counter counter;
		private Semaphore semaphore;
		private int numOfIterations;
		private int mod;

		public Printer(Counter counter, Semaphore semaphore, int mod) {
			this.counter = counter;
			this.semaphore = semaphore;
			this.mod = mod;
		}

		@Override
		public void run() {
			while (counter.num < 10) {
				numOfIterations++;
				if (counter.num % 3 == mod) {
					acquirePrintIncrementAndRelease();
				}
			}
			System.out.println(Thread.currentThread().getName()
					+ " number of Iterations= " + numOfIterations);
		}

		private synchronized void acquirePrintIncrementAndRelease() {
			try {
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName()
						+ " prints " + counter.num);
				counter.num++;
				semaphore.release();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	static class Counter {
		int num;

		public Counter(int n) {
			this.num = n;
		}
	}

}
