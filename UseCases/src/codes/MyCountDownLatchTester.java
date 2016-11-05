package codes;

public class MyCountDownLatchTester {

	public static void main(String[] args) {
		MyCountDownLatch latch = new MyCountDownLatch(3);

		Thread t1 = new Thread(new MyRunnable(latch), "T1");
		Thread t2 = new Thread(new MyRunnable(latch), "T2");
		Thread t3 = new Thread(new MyRunnable(latch), "T3");

		t1.start();
		t2.start();
		t3.start();

		latch.await();
		System.out.println("All threads done! Count=" + latch.getCount());

	}

	static class MyRunnable implements Runnable {

		private MyCountDownLatch latch;

		public MyRunnable(MyCountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " just started");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + " is done. Releasing latch.");
			this.latch.countDown();

		}

	}

}
