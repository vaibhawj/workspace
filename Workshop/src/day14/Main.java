package day14;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				int i = 0;
				System.out.println(Thread.currentThread().isInterrupted());
				while (true) {

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {

						break;
					}

					System.out.println("hey" + i++);

				}
				System.out.println(Thread.currentThread().isInterrupted());

			}
		});

		t.start();

		Thread.sleep(2000);

		t.interrupt();

	}

}
