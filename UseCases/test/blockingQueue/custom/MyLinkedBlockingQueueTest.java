package blockingQueue.custom;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedBlockingQueueTest {

	@Test
	public void testOffer() throws InterruptedException {
		MyLinkedBlockingQueue<Integer> q = new MyLinkedBlockingQueue<Integer>(3);
		Assert.assertTrue(q.offer(5));
		Assert.assertTrue(q.offer(8));
		Assert.assertTrue(q.offer(10));
		Assert.assertFalse(q.offer(12));
	}

	@Test
	public void testTake() throws InterruptedException {
		MyLinkedBlockingQueue<Integer> q = new MyLinkedBlockingQueue<Integer>(3);
		q.offer(5);
		q.offer(8);
		q.offer(10);
		Assert.assertEquals(5, q.take().intValue());
		Assert.assertEquals(8, q.take().intValue());
		Assert.assertEquals(10, q.take().intValue());
	}

	@Test
	public void testPut() throws InterruptedException {
		MyLinkedBlockingQueue<Integer> q = new MyLinkedBlockingQueue<Integer>(3);
		q.offer(5);
		q.offer(8);
		q.offer(10);

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);

					System.out.println(q.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();

		q.put(12);
		// if it reaches here, it means it waited for space to be available and
		// finally was able to put it
		Assert.assertTrue(true);
		Assert.assertEquals(8, q.take().intValue());
		Assert.assertEquals(10, q.take().intValue());
		Assert.assertEquals(12, q.take().intValue());

	}

}
