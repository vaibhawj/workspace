package countDownLatch;

public class MyCountDownLatch {

	private volatile int count;

	public MyCountDownLatch(int count) {
		this.count = count;
	}

	public void await() {
		while (this.count > 0) {

		}
	}

	public void countDown() {
		count--;
	}

	public int getCount() {
		return this.count;
	}

}
