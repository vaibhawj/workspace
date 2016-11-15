package day9;

public class ThreadInterruptedWhichWasNotSleepingOrwaiting {

	public static void main(String[] args) {
		Object obj = new Object();
		Thread t1 = new Thread(new MyRun(obj), "T1");
		Thread t2 = new Thread(new MyRun(obj), "T2");

		t1.start();
		sleep(1000);
		t2.start();
		t2.interrupt();

	}

	static class MyRun implements Runnable {

		Object obj;

		public MyRun(Object obj) {
			this.obj = obj;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()
					+ " just outside synch block");
			synchronized (obj) {
				System.out.println(Thread.currentThread().getName()
						+ " entered synch block");
				System.err.println(Thread.currentThread().getName()
						+ " interrupt status- "
						+ Thread.currentThread().isInterrupted());
				sleep(4000);

			}
			System.out.println(Thread.currentThread().getName() + " completed");

		}

	}

	private static void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {

		}
	}
}
