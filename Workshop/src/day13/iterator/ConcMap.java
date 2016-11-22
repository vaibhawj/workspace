package day13.iterator;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcMap {

	public static void main(String[] args) {

		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		Thread reader = new Thread(new Reader(map), "Reader");
		Thread writer1 = new Thread(new Writer(map), "Writer1");
		Thread writer2 = new Thread(new Writer(map), "Writer2");

		reader.start();
		writer1.start();
		writer2.start();

	}

	static class Reader implements Runnable {

		private ConcurrentHashMap<String, String> map;

		public Reader(ConcurrentHashMap<String, String> map) {
			this.map = map;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Iterator<String> itr = map.keySet().iterator();
			while (itr.hasNext()) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(itr.next());
			}
			System.out.println("Done");

		}

	}

	static class Writer implements Runnable {

		private ConcurrentHashMap<String, String> map;

		public Writer(ConcurrentHashMap<String, String> map) {
			this.map = map;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				map.put(Thread.currentThread().getName() + " k" + i, i + "");
			}

		}
	}

}
