package cyclicBarrier;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class MyCyclicBarrierTest {

	private MyCyclicBarrier cb;

	@Test
	public void testAwait() throws InterruptedException {
		cb = new MyCyclicBarrier(3);
		ArrayList<String> list = new ArrayList<>();

		class MyRun implements Runnable {

			@Override
			public void run() {

				list.add(Thread.currentThread().getName());
				cb.await();

			}

		}

		new Thread(new MyRun()).start();
		new Thread(new MyRun()).start();
		cb.await();

		Assert.assertTrue(true);
		Assert.assertEquals(2, list.size());

	}

	@Test
	public void testReset() throws InterruptedException {
		cb = new MyCyclicBarrier(3);
		class MyRun implements Runnable {

			@Override
			public void run() {
				cb.await();
			}

		}

		Thread t = new Thread(new MyRun());
		t.start();
		Thread.sleep(1000);

		Assert.assertEquals(2, cb.getNumberWaiting());
		cb.reset();
		Assert.assertEquals(3, cb.getNumberWaiting());
	}

	@Test
	public void testGetNumberWaiting() {
		cb = new MyCyclicBarrier(3);
		Assert.assertEquals(3, cb.getNumberWaiting());
	}

}
