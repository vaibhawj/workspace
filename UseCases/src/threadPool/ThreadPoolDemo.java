package threadPool;

import threadPool.ThreadPool.Worker;

public class ThreadPoolDemo {

	public static void main(String[] args) throws InterruptedException {
		ThreadPool threadPool = new ThreadPool(2);
		threadPool.submit(new MyJob("J1", 2));
		threadPool.submit(new MyJob("J2", 1));

		Thread.sleep(3000);

		threadPool.submit(new MyJob("J3", 2));
		threadPool.shutDown();

	}

	static class MyJob implements Runnable {

		public Worker worker;
		private int i;
		private String name;

		public MyJob(String name, int i) {
			this.i = i;
			this.name = name;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(i * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + " completed " + name);

		}
	};

}
