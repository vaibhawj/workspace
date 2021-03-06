package threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import threadPool.ThreadPool.Worker;

public class ThreadPoolDemo {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Runnable> jobs = new LinkedBlockingQueue<Runnable>();
		ThreadPool threadPool = new ThreadPool(2, jobs);
		threadPool.submit(new MyJob("J1", 2));
		threadPool.submit(new MyJob("J2", 1));

		Thread.sleep(3000);

		threadPool.submit(new MyJob("J3", 2));
		threadPool.shutDownNow();

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

			System.out.println(Thread.currentThread() + " completed " + name);

		}
	};

}
