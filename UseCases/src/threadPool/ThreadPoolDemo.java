package threadPool;

import java.util.ArrayList;
import java.util.List;

import threadPool.ThreadPool.Worker;

public class ThreadPoolDemo {

	static ThreadPool pool = new ThreadPool(2, 2, 1);

	public static void main(String[] args) {

		List<MyJob> jobs = new ArrayList<>();
		jobs.add(new MyJob("J1", 2));
		jobs.add(new MyJob("J2", 3));
		jobs.add(new MyJob("J3", 1));
		jobs.add(new MyJob("J4", 4));

		for (MyJob job : jobs) {
			Worker worker = pool.checkOut();
			job.worker = worker;
			worker.submit(job);
		}

	}

	static class MyJob implements Runnable {

		public Worker worker;
		private int i;
		private String name;

		public MyJob(String name, int i) {
			this.i = i;
			this.name = name;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(i * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + " completed " + name);
			pool.checkIn(worker);

		}
	};

}
