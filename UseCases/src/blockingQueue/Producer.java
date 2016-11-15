package blockingQueue;

import blockingQueue.custom.MyLinkedBlockingQueue;

public class Producer implements Runnable {

	private MyLinkedBlockingQueue<Task> blockingQueue;

	public Producer(MyLinkedBlockingQueue<Task> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {

		for (int i = 0; i < 30; i++) {
			Task task = new Task(i + 1, Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()
						+ " to produce task=" + task.getId());
				blockingQueue.put(task);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
