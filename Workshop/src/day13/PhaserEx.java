package day13;

import java.util.concurrent.Phaser;

public class PhaserEx {

	public static void main(String[] args) {
		Phaser phaser = new Phaser();

		Thread t1 = new Thread(new myRun(phaser), "T1");
		Thread t2 = new Thread(new myRun(phaser), "T2");
		Thread t3 = new Thread(new myRun(phaser), "T3");

		phaser.register();
		t1.start();
		phaser.register();
		t2.start();
		phaser.register();
		t3.start();

		phaser.register();

		phaser.arriveAndAwaitAdvance();
		System.out.println("Done");

	}

	static class myRun implements Runnable {

		private Phaser phaser;

		public myRun(Phaser phaser) {
			this.phaser = phaser;
		}

		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " just entered");
			try {
				Thread.sleep(1000 * Integer.parseInt(threadName.charAt(1) + ""));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(threadName + " just woke up");
			phaser.arriveAndAwaitAdvance();
			System.out.println(threadName + " arrived");

		}

	}

}
