package day9.locks;

public class Runnable1 implements Runnable {

	private Test obj;

	public Runnable1(Test obj) {
		this.obj = obj;
	}

	@Override
	public void run() {

		synchronized (Test.class) {
			Test.m1();
			obj.m2();
			Test.m3();
			obj.m4();
		}

	}

}
