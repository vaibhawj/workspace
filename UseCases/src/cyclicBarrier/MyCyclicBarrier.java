package cyclicBarrier;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyCyclicBarrier {

	private int parties;

	private volatile int count;

	private ReentrantLock lock;

	private Condition condition;

	public MyCyclicBarrier(int parties) {
		this.parties = parties;
		this.count = parties;
		lock = new ReentrantLock(true);
		condition = lock.newCondition();
	}

	public void await() {
		this.count--;

		if (this.count == 0) {
			lock.lock();
			condition.signalAll();
			lock.unlock();
		}

		if (this.count > 0) {
			lock.lock();
			while (this.count > 0) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			lock.unlock();
		}

	}

	public void reset() {
		count = parties;
	}

	public int getNumberWaiting() {
		return this.count;
	}

}
