package day9.locks;

public class Runnable2 implements Runnable {

	private Test obj;

	public Runnable2(Test obj) {
		this.obj = obj;
	}

	@Override
	public void run() {

		synchronized (Test.class) {
			Test.m1();
			obj.m2();
		}

	}

}
