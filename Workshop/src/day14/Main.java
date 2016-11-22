package day14;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				int i = 0;
				while (!Thread.currentThread().isInterrupted()) {

					System.out.println("hey" + i++);

				}
				System.out.println("Done");

			}
		});

		t.start();

		Thread.sleep(2000);

		t.interrupt();

	}

}
