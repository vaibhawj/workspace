package dec7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public class HashMapMultithreading {

	public static void main(String[] args) throws InterruptedException {
		HashMap<String, String> map = new HashMap<String, String>();
		CountDownLatch lat = new CountDownLatch(2);
		Thread t1 = new Thread(() -> {

			for (int i = 0; i < 10; i++) {
				map.put("K" + i, Thread.currentThread().getName() + "V" + i);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		lat.countDown();

	}, "T1");

		Thread t2 = new Thread(() -> {

			for (int i = 5; i < 15; i++) {
				map.put("K" + i, Thread.currentThread().getName() + "V" + i);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		lat.countDown();

	}, "T2");

		Thread t3 = new Thread(() -> {

			Iterator<String> itr = map.keySet().iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}	);

		t1.start();
		t2.start();
		t3.start();
		lat.await();
		System.out.println(map);

	}

}
