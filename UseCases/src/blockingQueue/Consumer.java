package blockingQueue;

import blockingQueue.custom.MyLinkedBlockingQueue;

public class Consumer implements Runnable {

	private MyLinkedBlockingQueue<Task> blockingQueue;

	public Consumer(MyLinkedBlockingQueue<Task> blockingQueue) {
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
		System.err.println(Thread.currentThread().getName()
				+ " consuming task-" + task.getId() + " produced by "
				+ task.getProducer());
	}
}
