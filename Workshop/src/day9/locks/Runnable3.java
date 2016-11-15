package day9.locks;

public class Runnable3 implements Runnable {

	private Test obj;

	public Runnable3(Test obj) {
		this.obj = obj;
	}

	@Override
	public void run() {

		synchronized (obj) {

			Test.m3();
			obj.m4();
		}

	}

}
