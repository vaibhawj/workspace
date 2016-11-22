package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer implements Runnable {

	private ArrayBlockingQueue<Task> blockingQueue;

	public Consumer(ArrayBlockingQueue<Task> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {

		while (true) {

			try {
				consume(blockingQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void consume(Task task) {
		System.err.println(Thread.currentThread().getName()
				+ " consuming task-" + task.getId() + " produced by "
				+ task.getProducer());
	}
}
