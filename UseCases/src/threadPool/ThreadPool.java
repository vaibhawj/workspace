package threadPool;

import objectPool.ObjectPool;
import threadPool.ThreadPool.Worker;

public class ThreadPool extends ObjectPool<Worker> {

	public ThreadPool(int noOfThreads) {
		super(noOfThreads);
	}

	public ThreadPool(int minSize, int maxSize, int checkInterval) {
		super(minSize, maxSize, checkInterval);
	}

	@Override
	protected Worker createObject() {
		Worker worker = new Worker();
		worker.start();

		return worker;
	}

	protected static class Worker extends Thread {

		private Runnable work;

		@Override
		public void run() {
			while (true) {
				if (this.work != null) {
					this.work.run();
					this.work = null;
				}
			}

		}

		public void submit(Runnable myJob) {
			this.work = myJob;
		}
	}

	@Override
	public void checkIn(Worker object) {
		object.work = null;
		System.out.println(object + " returning to pool");
		super.checkIn(object);
	}

	@Override
	public Worker checkOut() {
		Worker worker = super.checkOut();
		System.out.println("Got " + worker + " from pool");
		return worker;
	}

}
