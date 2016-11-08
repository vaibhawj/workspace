package threadPool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

	private BlockingQueue<Runnable> jobs;
	private List<Worker> workers;

	public ThreadPool(int noOfThreads) {
		jobs = new LinkedBlockingQueue<>();
		workers = new LinkedList<>();
		for (int i = 0; i < noOfThreads; i++) {
			Worker worker = new Worker(jobs);
			workers.add(worker);
			Thread t = new Thread(worker);
			t.start();
		}

	}

	public ThreadPool() {
		this(2);
	}

	protected static class Worker implements Runnable {

		private BlockingQueue<Runnable> jobs;
		private volatile boolean running;

		public Worker(BlockingQueue<Runnable> jobs) {
			this.jobs = jobs;
			this.running = true;
		}

		public void terminate() {
			this.running = false;
		}

		@Override
		public void run() {
			while (running) {

				try {
					Runnable job = this.jobs.take();
					if (null != job) {
						System.out.println(Thread.currentThread() + " dint find any job");
						job.run();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println(Thread.currentThread().getName() + " exiting");

		}

	}

	public void submit(Runnable job) {
		this.jobs.offer(job);
	}

	public void shutDown() {
		for (Worker worker : workers) {
			worker.terminate();
		}
	}

}
