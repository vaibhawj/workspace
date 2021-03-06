package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Producer implements Runnable {

	private ArrayBlockingQueue<Task> blockingQueue;

	public Producer(ArrayBlockingQueue<Task> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {

		for (int i = 0; i < 30; i++) {
			Task task = new Task(i + 1, Thread.currentThread().getName());
			try {
				System.out.println(Thread.currentThread().getName()
						+ " to produce task=" + task.getId());
				blockingQueue.put(task);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
