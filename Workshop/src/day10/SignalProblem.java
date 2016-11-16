package day10;

public class SignalProblem {

	public static void main(String[] args) {

		Thread signalThread1 = new Thread(new Signal(new RedState()), "S1");
		Thread signalThread2 = new Thread(new Signal(new GreenState()), "S2");
		Thread signalThread3 = new Thread(new Signal(new RedState()), "S3");
		Thread signalThread4 = new Thread(new Signal(new RedState()), "S4");

		signalThread1.start();
		signalThread2.start();
		signalThread3.start();
		signalThread4.start();

	}

	static class Signal implements Runnable {

		private State state;

		public Signal(State state) {
			this.state = state;
		}

		@Override
		public void run() {

			if ("Red".equals(state)) {
				state.switchState(this);
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
