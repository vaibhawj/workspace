package day8.threads;

public class ThreadStates {

	public static void main(String[] args) {
		Thread t = new Thread(new MyRun());
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("2. " + t.getState());
		while (t.isAlive()) {

		}
		System.out.println("4. " + t.getState());

	}

	static class MyRun implements Runnable {

		@Override
		public void run() {
			System.out.println("1. " + Thread.currentThread().getState());
			System.out.println("Gonna sleep..");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("3. " + Thread.currentThread().getState());
			System.out.println("Thread terminating..");

		}

	}

}
