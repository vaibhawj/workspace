package day13;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteList {

	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		Thread reader = new Thread(new Reader(list), "Reader");
		Thread writer = new Thread(new Writer(list), "Writer");

		reader.start();
		writer.start();

	}

	static class Reader implements Runnable {

		private CopyOnWriteArrayList<String> list;

		public Reader(CopyOnWriteArrayList<String> list) {
			this.list = list;
		}

		@Override
		public void run() {
			// Iterator<String> itr = list.iterator();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Iterator<String> itr = list.iterator();
			while (itr.hasNext()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Reader read " + itr.next());
			}

			System.out.println("reader done");

		}

	}

	static class Writer implements Runnable {

		private CopyOnWriteArrayList<String> list;

		public Writer(CopyOnWriteArrayList<String> list) {
			this.list = list;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				list.add("item" + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Writer done - " + list);

		}

	}

}
