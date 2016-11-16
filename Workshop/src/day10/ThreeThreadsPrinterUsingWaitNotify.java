package day10;

public class ThreeThreadsPrinterUsingWaitNotify {

	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter(1);

		Thread t1 = new Thread(new Printer(counter, 1), "T1");
		Thread t2 = new Thread(new Printer(counter, 2), "T2");
		Thread t3 = new Thread(new Printer(counter, 0), "T3");

		t3.start();
		t1.start();
		t2.start();

	}

	static class Printer implements Runnable {

		private volatile Counter counter;
		private int modulus;
		private int numberOfIterations;

		public Printer(Counter counter, int modulus) {
			this.counter = counter;
			this.modulus = modulus;
		}

		@Override
		public void run() {

			while (counter.num < 10) {
				numberOfIterations++;
				synchronized (counter) {
					if (counter.num % 3 == modulus) {
						System.out.println(Thread.currentThread().getName()
								+ " prints " + counter.num);
						counter.num++;
						counter.notifyAll();
					} else {
						try {
							counter.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			}
			System.out.println(Thread.currentThread().getName()
					+ " number of iterations = " + numberOfIterations);

		}

	}

	static class Counter {
		int num;

		public Counter(int n) {
			this.num = n;
		}
	}

}
