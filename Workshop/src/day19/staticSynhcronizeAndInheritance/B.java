package day19.staticSynhcronizeAndInheritance;

public class B extends A {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				A.method2();

			}
		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				B.method3();

			}
		});
		t2.start();

		B.method1();

	}

	public synchronized static void method3() {

		System.out.println("in B's methd 3" + Thread.currentThread().getName());

	}

}
