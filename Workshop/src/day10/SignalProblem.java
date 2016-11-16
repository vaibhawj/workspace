package day10;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SignalProblem {

	static SignalProblem s;
	Signal signal1;
	Signal signal2;
	Signal signal3;
	Signal signal4;

	public static void main(String[] args) {
		s = new SignalProblem();
		s.letTheFunBegin();

	}

	private void letTheFunBegin() {
		Lock lock = new ReentrantLock(true);
		Condition tripCondition = lock.newCondition();
		signal1 = new Signal(new GreenState(), lock, tripCondition);
		signal2 = new Signal(new RedState(), lock, tripCondition);
		signal3 = new Signal(new RedState(), lock, tripCondition);
		signal4 = new Signal(new RedState(), lock, tripCondition);

		Thread signalThread1 = new Thread(signal1, "S1");
		Thread signalThread2 = new Thread(signal2, "S2");
		Thread signalThread3 = new Thread(signal3, "S3");
		Thread signalThread4 = new Thread(signal4, "S4");

		signalThread2.start();
		signalThread3.start();
		signalThread4.start();
		signalThread1.start();
	}

	void printStatus() {
		System.out.println("S1 is " + signal1.state);
		System.out.println("S2 is " + signal2.state);
		System.out.println("S3 is " + signal3.state);
		System.out.println("S4 is " + signal4.state);

		System.out.println("************************");
	}

	static class Signal implements Runnable {

		private State state;
		private Lock lock;
		private int numOfIterations;
		private Condition condition;

		public Signal(State state, Lock lock, Condition tripCondition) {
			this.state = state;
			this.lock = lock;
			this.condition = tripCondition;
		}

		@Override
		public void run() {

			while (numOfIterations <= 4) {
				numOfIterations++;
				lock.lock();
				if ("Red".equals(state.toString())) {
					try {
						condition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					state.switchState(this);
					s.printStatus();
				} else {
					state.switchState(this);
					condition.signal();
				}

				lock.unlock();

			}

		}
	}

	interface State {

		void switchState(Signal signal);

	}

	static class RedState implements State {

		@Override
		public void switchState(Signal signal) {
			signal.state = new GreenState();
		}

		@Override
		public String toString() {
			return "Red";
		}

	}

	static class GreenState implements State {

		@Override
		public void switchState(Signal signal) {
			signal.state = new RedState();
		}

		@Override
		public String toString() {
			return "Green";
		}

	}

}
