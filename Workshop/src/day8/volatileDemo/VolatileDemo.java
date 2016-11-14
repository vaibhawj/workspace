package day8.volatileDemo;

public class VolatileDemo {

	public static void main(String[] args) throws InterruptedException {
		MyRunnable run = new MyRunnable();

		Thread startThread = new Thread(run, "Runner");
		Thread stopThread = new Thread(run, "Stopper");

		startThread.start();

		Thread.sleep(3000);

		stopThread.start();

		Thread.sleep(3000);
		System.out.println("After 3 seconds status");
		System.out.println("Runner - " + startThread.getState() + " | isAlive="
				+ startThread.isAlive());
		System.out.println("Stopper - " + stopThread.getState() + " | isAlive="
				+ stopThread.isAlive());

		while (startThread.isAlive()) {

		}
		System.out.println("Finally.. Without volatile you may not see this");
	}

	static class MyRunnable implements Runnable {

		volatile private boolean stop;

		@Override
		public void run() {
			if (Thread.currentThread().getName().equals("Stopper")) {
				stop = true;
				System.out.println("Stopper has set the stop flag");
			} else {
				while (!stop) {

				}

			}

		}

	}
}
