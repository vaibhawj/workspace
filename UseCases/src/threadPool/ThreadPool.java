package threadPool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

	private BlockingQueue<Runnable> jobs;
	private List<Thread> workers;

	public ThreadPool(int noOfThreads) {
		jobs = new LinkedBlockingQueue<>();
		workers = new LinkedList<>();
		for (int i = 0; i < noOfThreads; i++) {
			Worker worker = new Worker(jobs);
			Thread t = new Thread(worker);
			workers.add(t);
			t.start();
		}

	}

	public ThreadPool() {
		this(2);
	}

	protected static class Worker implements Runnable {

		private BlockingQueue<Runnable> jobs;

		public Worker(BlockingQueue<Runnable> jobs) {
			this.jobs = jobs;
		}

		@Override
		public void run() {
			while (true) {

				try {
					Runnable job = this.jobs.take();
					if (null != job) {
						System.out.println(Thread.currentThread()
								+ " dint find any job");
						job.run();
					}
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()
							+ " exiting");
					break;
				}
			}

		}

	}

	public void submit(Runnable job) {
		this.jobs.offer(job);
	}

	public void shutDown() {
		for (Thread workerThread : workers) {
			workerThread.interrupt();
		}
	}
}
