package linkedHashMap;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import linkedHashMap.MyLinkedHashMap.Node;

public class MyLinkedHashMapDemo {
	public static void main(String[] args) throws InterruptedException {
		// To test the concurrency and lock on bucket making array size as 1
		MyLinkedHashMap<String, String> map = new MyLinkedHashMap<String, String>();
		Node<String, String> n1 = new Node<String, String>("abc", "123");
		Node<String, String> n2 = new Node<String, String>("def", "456");
		Node<String, String> n3 = new Node<String, String>("fgh", "678");

		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService ex = Executors.newFixedThreadPool(3);

		ex.submit(new MyJob(map, n1, latch));
		ex.submit(new MyJob(map, n2, latch));
		ex.submit(new MyJob(map, n3, latch));

		latch.await();
		ex.shutdown();

		System.out.println(map);

	}

	static class MyJob implements Runnable {

		private MyLinkedHashMap<String, String> map;
		private Node<String, String> toPut;
		private CountDownLatch latch;

		public MyJob(MyLinkedHashMap<String, String> map,
				Node<String, String> toPut, CountDownLatch latch) {
			this.map = map;
			this.toPut = toPut;
			this.latch = latch;
		}

		@Override
		public void run() {
			map.put(toPut.getKey(), toPut.getValue());
			this.latch.countDown();
		}

	}
}
