package cyclicBarrier;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyCyclicBarrier {

	private int parties;

	private volatile int count;

	private volatile boolean barrierBroken;

	private Runnable barrierCommand;

	private volatile boolean barrierCommandExecuted;

	private ReentrantLock lock;

	private Condition condition;

	public MyCyclicBarrier(int parties) {
		this.parties = parties;
		this.count = parties;
		lock = new ReentrantLock(true);
		condition = lock.newCondition();
	}

	public MyCyclicBarrier(int parties, Runnable barrierAction) {
		this(parties);
		this.barrierCommand = barrierAction;
	}

	public void await() throws BarrierBrokenException {
		this.count--;

		if (this.count == 0) {
			lock.lock();
			condition.signalAll();
			lock.unlock();
		}

		if (this.count > 0) {
			while (this.count > 0) {
				if (this.barrierBroken) {
					this.barrierBroken = false;
					throw new BarrierBrokenException();
				}
			}
			lock.lock();
			try {
				condition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.unlock();
		}

		if (!barrierCommandExecuted) {
			barrierCommandExecuted = true;
			barrierCommand.run();
		}
	}

	public void reset() {
		count = parties;
		this.barrierBroken = true;
	}

	public int getNumberWaiting() {
		return this.parties - this.count;
	}

	static class BarrierBrokenException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1340198090568923005L;

	}

}
