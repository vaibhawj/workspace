package day20.lockVsSynch;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		MyClass obj = new MyClass(lock);

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				obj.m1();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				obj.m2();
			}
		});

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				obj.m3();
			}
		});

		Thread t4 = new Thread(new Runnable() {

			@Override
			public void run() {
				obj.m4();
			}
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

	static class MyClass {

		ReentrantLock lock;

		public MyClass(ReentrantLock lock2) {
			this.lock = lock2;
		}

		public void m1() {
			synchronized (this) {
				System.out.println(Thread.currentThread().getName()
						+ " inside m1");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()
						+ " exiting m1");

			}

		}

		public void m2() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()
					+ " wants to execute m2");
			lock.lock();
			System.out.println(Thread.currentThread().getName() + " inside m2");
			lock.unlock();
		}

		public void m3() {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + " inside m3");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out
					.println(Thread.currentThread().getName() + " exiting m3");
			lock.unlock();
		}

		public void m4() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (this) {

				System.out.println(Thread.currentThread().getName()
						+ " inside m4");
			}

		}

	}

}
