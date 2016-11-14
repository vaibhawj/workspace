package day8.deadlock;

public class DeadlockDemo {

	public static void main(String[] args) {
		System.err.println("Deadlock demo");
		MyLock lock1 = new MyLock("L1");
		MyLock lock2 = new MyLock("L2");

		Runnable run1 = new MyRun(lock1, lock2);
		Runnable run2 = new MyRun(lock2, lock1);
		Thread t1 = new Thread(run1, "T1");
		Thread t2 = new Thread(run2, "T2");

		t1.start();

		t2.start();

	}

	static class MyRun implements Runnable {

		private Object lock1;
		private Object lock2;

		public MyRun(Object lock1, Object lock2) {
			this.lock1 = lock1;
			this.lock2 = lock2;
		}

		public void run() {
			final String threadName = Thread.currentThread().getName();
			System.out
					.println(threadName + " just outside the 1st synch block");

			sleep(1000);

			synchronized (lock1) {
				System.out.println(threadName
						+ " got inside 1st synch block, got lock on " + lock1);

				sleep(1000);

				System.out
						.println(threadName
								+ " just outside the 2nd synch block, wanna have lock on "
								+ lock2);

				synchronized (lock2) {
					System.out.println(threadName
							+ " got inside 2nd synch block");
				}

			}

			System.out.println(threadName + " just completed");
		}

		private void sleep(long milis) {
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static class MyLock {

		private String resourceName;

		public MyLock(String resourceName) {
			this.resourceName = resourceName;
		}

		@Override
		public String toString() {
			return this.resourceName;
		}

	}

}
