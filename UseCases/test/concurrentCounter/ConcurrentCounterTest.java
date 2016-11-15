package concurrentCounter;

import org.junit.Assert;
import org.junit.Test;

public class ConcurrentCounterTest {

	@Test
	public void testIncrementAndGet() {
		ConcurrentCounter counter = new ConcurrentCounter();
		Assert.assertEquals(1, counter.incrementAndGet());
		Assert.assertEquals(2, counter.incrementAndGet());
	}

	@Test
	public void testDecrementAndGet() {
		ConcurrentCounter counter = new ConcurrentCounter(3);
		Assert.assertEquals(2, counter.decrementAndGet());
		Assert.assertEquals(1, counter.decrementAndGet());
	}

	@Test
	public void testCompareAndSetPositive() {
		ConcurrentCounter counter = new ConcurrentCounter(0);
		Assert.assertTrue(counter.compareAndSet(0, 2));
	}

	@Test
	public void testCompareAndSetNegative() {
		ConcurrentCounter counter = new ConcurrentCounter(0);
		Assert.assertFalse(counter.compareAndSet(1, 2));
	}

}
