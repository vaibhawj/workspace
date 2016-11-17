package cyclicBarrier;

import cyclicBarrier.MyCyclicBarrier.BarrierBrokenException;

public class MyCyclicBarrierTester {

	public static void main(String[] args) {
		// MyCyclicBarrier cb = new MyCyclicBarrier(3, new BarrierAction());
		MyCyclicBarrier cb = new MyCyclicBarrier(3);

		Thread t1 = new Thread(new MyRunnable(cb), "T1");
		Thread t2 = new Thread(new MyRunnable(cb), "T2");
		Thread t3 = new Thread(new MyRunnable(cb), "T3");

		t1.start();
		t2.start();
		t3.start();

	}

	static class BarrierAction implements Runnable {

		@Override
		public void run() {
			System.out.println("Barrier Action executed by "
					+ Thread.currentThread().getName());
		}

	}

	static class MyRunnable implements Runnable {

		private MyCyclicBarrier cb;

		public MyRunnable(MyCyclicBarrier cb) {
			this.cb = cb;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()
					+ " just started");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()
					+ " reaching barrier");

			try {
				this.cb.await();
			} catch (BarrierBrokenException e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName()
					+ " moving ahead");

		}

	}
}
