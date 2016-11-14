package day8.threads;

public class ThreadInterruptedDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new MyRunnable());
		t.start();

		Thread.sleep(4000);

		t.interrupt();
		System.out.println("Done main");

	}

	static class MyRunnable implements Runnable {

		@Override
		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("Interrupted");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Printing done");

		}

	}

}
