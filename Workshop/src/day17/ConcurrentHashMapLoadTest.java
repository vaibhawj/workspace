package day17;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapLoadTest {

	private static final int COUNT = 10_00_000;

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>(
				COUNT);
		int nofReaders = 500;
		int nofWriters = 500;

		int totalThreads = nofReaders + nofWriters;
		CyclicBarrier cb = new CyclicBarrier(totalThreads + 1);
		ExecutorService ex = Executors.newFixedThreadPool(totalThreads);

		for (int i = 0; i < nofReaders; i++) {
			ex.execute(new Reader(map, cb));
		}

		for (int i = 0; i < nofWriters; i++) {
			ex.execute(new Writer(map, cb));
		}

		long startTime = 0;
		try {
			cb.await();
			startTime = System.currentTimeMillis();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}

		while (map.size() <= COUNT) {
			// busy wait
		}

		ex.shutdownNow();
		long endTime = System.currentTimeMillis();
		System.out.println("Done");
		System.out.println(map.size());
		System.out.println(endTime - startTime);

	}

	static class Reader implements Runnable {

		private CyclicBarrier cb;
		private ConcurrentHashMap<Integer, Integer> map;

		public Reader(ConcurrentHashMap<Integer, Integer> map, CyclicBarrier cb) {
			this.map = map;
			this.cb = cb;
		}

		@Override
		public void run() {
			try {
				cb.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}

			while (!Thread.currentThread().isInterrupted()) {
				Iterator<Entry<Integer, Integer>> itr = map.entrySet()
						.iterator();

				while (itr.hasNext()) {
					int k = itr.next().getKey();
				}

			}

		}
	}

	static class Writer implements Runnable {

		private CyclicBarrier cb;
		private ConcurrentHashMap<Integer, Integer> map;

		public Writer(ConcurrentHashMap<Integer, Integer> map, CyclicBarrier cb) {
			this.map = map;
			this.cb = cb;
		}

		@Override
		public void run() {
			try {
				cb.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}

			int i = 1;
			while (map.size() <= COUNT) {
				map.put(i++, i++);
			}

		}
	}

}
