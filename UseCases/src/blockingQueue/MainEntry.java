package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class MainEntry {

	public static void main(String[] args) {
		ArrayBlockingQueue<Task> blockingQueue = new ArrayBlockingQueue<>(20);

		Thread producerThread1 = new Thread(new Producer(blockingQueue), "Producer1");
		Thread producerThread2 = new Thread(new Producer(blockingQueue), "Producer2");

		Thread ConsumerThread1 = new Thread(new Consumer(blockingQueue), "Consumer1");
		Thread ConsumerThread2 = new Thread(new Consumer(blockingQueue), "Consumer2");

		producerThread1.start();
		producerThread2.start();
		ConsumerThread1.start();
		ConsumerThread2.start();

	}

}
