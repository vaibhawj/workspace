package concurrentCounter;

public class ConcurrentCounter {

	private volatile int value;

	public ConcurrentCounter() {
		this(0);
	}

	public ConcurrentCounter(int initialValue) {
		this.value = initialValue;
	}

	public int get() {
		return this.value;
	}

	public synchronized int incrementAndGet() {
		return ++this.value;
	}

	public synchronized int decrementAndGet() {
		return --this.value;
	}

}
