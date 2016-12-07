package dec7;

import java.util.concurrent.locks.ReentrantLock;

public class MultipleLockSingleUnlockEx {

	ReentrantLock lock = new ReentrantLock();
	int count = 0;

	public static void main(String[] args) throws InterruptedException {
		MultipleLockSingleUnlockEx e = new MultipleLockSingleUnlockEx();
		e.fun();

		Thread t = new Thread(() -> {
			e.fun1();
		});
		t.start();

	}

	private void fun1() {
		lock.lock();
		System.out.println("fun1");
		lock.unlock();

	}

	private void fun() {

		if (this.count == 10) {

			while (lock.isHeldByCurrentThread()) {
				System.out.println("unlcok");
				lock.unlock();
			}
			System.out.println(lock.isLocked());
			return;
		}

		lock.lock();
		System.out.println(count++);
		fun();

	}

}
