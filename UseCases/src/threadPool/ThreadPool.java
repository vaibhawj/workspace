package threadPool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

	private BlockingQueue<Runnable> jobs;
	private List<Thread> workers;
	private volatile boolean shutDownInvoked;

	public ThreadPool(int noOfThreads, BlockingQueue<Runnable> jobs) {
		this.jobs = jobs;
		workers = new LinkedList<>();
		for (int i = 0; i < noOfThreads; i++) {
			Worker worker = new Worker(jobs);
			Thread t = new Thread(worker);
			workers.add(t);
			t.start();
		}

	}

	public ThreadPool(BlockingQueue<Runnable> jobs) {
		this(2, jobs);
	}

	protected class Worker implements Runnable {

		private BlockingQueue<Runnable> jobs;

		public Worker(BlockingQueue<Runnable> jobs) {
			this.jobs = jobs;
		}

		@Override
		public void run() {
			while (!shutDownInvoked && !jobs.isEmpty()) {

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

	public void submit(Runnable job) throws InterruptedException {
		if (shutDownInvoked) {
			throw new IllegalStateException(
					"ShutDown Invoked. Will not take new tasks");
		}

		this.jobs.put(job);
	}

	public void shutDownNow() {
		for (Thread workerThread : workers) {
			workerThread.interrupt();
		}
	}

	public void shutDown() {
		shutDownInvoked = true;
	}
}
