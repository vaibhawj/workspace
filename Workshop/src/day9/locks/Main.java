package day9.locks;

public class Main {

	public static void main(String[] args) {

		Test obj = new Test();
		Thread t1 = new Thread(new Runnable1(obj), "T1");
		Thread t2 = new Thread(new Runnable2(obj), "T2");
		Thread t3 = new Thread(new Runnable3(obj), "T3");

		t1.start();
		t3.start();
		t2.start();

	}
}
