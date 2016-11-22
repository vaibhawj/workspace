package day14;

import java.util.concurrent.locks.ReentrantLock;

public class LockUnlockMutipleThread {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				lock.lock();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				lock.unlock();

			}
		});

		t1.start();
		t2.start();

	}

}
