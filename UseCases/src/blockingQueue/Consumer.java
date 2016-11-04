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
				Thread.sleep(3000);
				consume(blockingQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	private void consume(Task task) {
		System.err.println(Thread.currentThread().getName() + " consuming task-" + task.getId() + " produced by "
				+ task.getProducer());
	}
}
