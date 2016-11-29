package day19;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		A a = new A();
		CyclicBarrier cb = new CyclicBarrier(2);

		Thread t1 = new Thread(new Reader(a, cb));
		Thread t2 = new Thread(new Writer(a, cb));

		t1.start();
		t2.start();

	}

	static class Writer implements Runnable {

		private volatile A a;
		private CyclicBarrier cb;

		public Writer(A a, CyclicBarrier cb) {
			this.a = a;
			this.cb = cb;
		}

		@Override
		public void run() {
			try {
				cb.await();

				Thread.sleep(2000);

				a.i = 20;

			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	static class Reader implements Runnable {

		private volatile A a;
		private CyclicBarrier cb;

		public Reader(A a, CyclicBarrier cb) {
			this.a = a;
			this.cb = cb;
		}

		@Override
		public void run() {
			try {
				cb.await();
				while (a.i != 20) {
					System.out.println("a is not 20");

				}
				System.out.println(a.i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	static class A {

		int i;

		public A() throws InterruptedException {
			i = 10;

		}

	}

}
