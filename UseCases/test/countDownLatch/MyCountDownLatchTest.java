package countDownLatch;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyCountDownLatchTest {

	private MyCountDownLatch latch;

	@Before
	public void before() {
		latch = new MyCountDownLatch(3);
	}

	@Test
	public void testAwait() throws InterruptedException {

		latch = new MyCountDownLatch(1);
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				latch.countDown();

			}
		});
		t.start();

		latch.await();
		Assert.assertTrue(true);

	}

	@Test
	public void testCountDown() {
		Assert.assertEquals(3, latch.getCount());
		latch.countDown();
		Assert.assertEquals(2, latch.getCount());
	}

	@Test
	public void testGetCount() {
		Assert.assertEquals(3, latch.getCount());
		latch.countDown();
		Assert.assertEquals(2, latch.getCount());

	}

	@After
	public void after() {
		latch = null;
	}

}
