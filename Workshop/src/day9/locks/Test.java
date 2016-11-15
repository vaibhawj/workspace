package day9.locks;

public class Test {

	public static synchronized void m1() {
		System.out.println(Thread.currentThread().getName() + " Inside m1");
	}

	public synchronized void m2() {
		System.out.println(Thread.currentThread().getName() + " Inside m2");
	}

	public static synchronized void m3() {
		System.out.println(Thread.currentThread().getName() + " Inside m3");
	}

	public synchronized void m4() {
		System.out.println(Thread.currentThread().getName() + " Inside m4");
	}

}
