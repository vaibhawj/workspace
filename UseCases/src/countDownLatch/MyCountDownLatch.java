package countDownLatch;

public class MyCountDownLatch {

	private volatile int count;

	public MyCountDownLatch(int count) {
		this.count = count;
	}

	public void await() throws InterruptedException {
		while (this.count > 0) {
			synchronized (this) {
				this.wait();
			}
		}
	}

	public void countDown() {
		synchronized (this) {
			count--;
			if (this.count == 0) {
				this.notifyAll();
			}
		}

	}

	public int getCount() {
		return this.count;
	}

}
