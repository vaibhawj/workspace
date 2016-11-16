package day10;

public class ThreeThreadsPrinter {

	public static void main(String[] args) {
		Counter counter = new Counter(1);

		Thread t1 = new Thread(new Printer(counter), "T1");
		Thread t2 = new Thread(new Printer(counter), "T2");
		Thread t3 = new Thread(new Printer(counter), "T3");

		t3.start();
		t1.start();
		t2.start();

	}

	static class Printer implements Runnable {

		private volatile Counter counter;

		public Printer(Counter counter) {
			this.counter = counter;
		}

		@Override
		public void run() {

			while (counter.num < 10) {
				if (counter.num == 1
						&& Thread.currentThread().getName().equals("T1")) {
					printAndIncrement(Thread.currentThread(), counter);
				} else {

					synchronized (counter) {
						if (counter.num % 3 == Integer.parseInt(Thread
								.currentThread().getName().charAt(1)
								+ "")
								|| (counter.num % 3 == 0 && Thread
										.currentThread().getName().equals("T3"))) {

							printAndIncrement(Thread.currentThread(), counter);

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

			}
		}

		private void printAndIncrement(Thread currentThread, Counter counter) {
			synchronized (counter) {

				System.out.println(Thread.currentThread().getName()
						+ " prints " + counter.num);
				counter.num++;
				counter.notifyAll();
			}
		}
	}

	static class Counter {
		volatile int num;

		public Counter(int n) {
			this.num = n;
		}
	}

}
