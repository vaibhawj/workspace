package countDownLatch;

import java.util.concurrent.TimeoutException;

public class MyCountDownLatch {

	private volatile int count;

	public MyCountDownLatch(int count) {
		this.count = count;
	}

	public void await() throws InterruptedException {
		synchronized (this) {
			while (this.count > 0) {

				this.wait();
			}
		}
	}

	public void await(long timeout) throws InterruptedException,
			TimeoutException {
		synchronized (this) {
			while (this.count > 0) {

				this.wait(timeout);
				if (this.count > 0) {
					throw new TimeoutException("Time out occured");
				}

			}
		}
	}

	public void countDown() {

		count--;
		synchronized (this) {
			if (this.count == 0) {
				this.notifyAll();
			}
		}

	}

	public int getCount() {
		return this.count;
	}

}
