package day19.staticSynhcronizeAndInheritance;

public class A {

	public synchronized static void method1() {

		System.out.println("in A's methd 1" + Thread.currentThread().getName());

		try {
			Thread.sleep(500000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized static void method2() {

		System.out
				.println("in A's methd 2 " + Thread.currentThread().getName());

	}

}
