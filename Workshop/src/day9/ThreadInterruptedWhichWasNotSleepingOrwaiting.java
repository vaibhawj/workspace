package day9;

public class ThreadInterruptedWhichWasNotSleepingOrwaiting {

	public static void main(String[] args) {

		Object o = new Object();

		o.notify();

	}
}
