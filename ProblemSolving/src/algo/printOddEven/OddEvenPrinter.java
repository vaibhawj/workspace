package algo.printOddEven;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter {

	public static void main(String[] args) {

		Lock lock = new ReentrantLock();
		Condition oddCondition = lock.newCondition();
		Condition evenCondition = lock.newCondition();

		Thread t1 = new Thread(() -> {
			for (int i = 2; i < 10; i = i + 2) {
				lock.lock();
				System.out.println(Thread.currentThread().getName() + " got the lock ");
				try {
					evenCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " - " + i);
				oddCondition.signal();
				lock.unlock();
			}

		}, "T1");

		Thread t2 = new Thread(() -> {
			for (int i = 1; i < 10; i = i + 2) {
				lock.lock();
				System.out.println(Thread.currentThread().getName() + " got the lock ");
				if (i != 1) {
					try {
						oddCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " - " + i);
				evenCondition.signal();
				lock.unlock();
			}
		}, "T2");

		t1.start();
		t2.start();

	}

}
