package codes;

public class MyCyclicBarrier {

	private int parties;

	private volatile int count;

	private volatile boolean barrierBroken;

	private Runnable barrierCommand;

	private volatile boolean barrierCommandExecuted;

	public MyCyclicBarrier(int parties) {
		this.parties = parties;
		this.count = parties;
	}

	public MyCyclicBarrier(int parties, Runnable barrierAction) {
		this.parties = parties;
		this.count = parties;
		this.barrierCommand = barrierAction;
	}

	public void await() throws BarrierBrokenException {
		this.count--;

		while (this.count > 0) {
			if (this.barrierBroken) {
				this.barrierBroken = false;
				throw new BarrierBrokenException();
			}
		}

		if (!barrierCommandExecuted) {
			barrierCommandExecuted = true;
			barrierCommand.run();
		}
	}

	public void reset() {
		count = parties;
		this.barrierBroken = true;
	}

	public int getNumberWaiting() {
		return this.parties - this.count;
	}

	static class BarrierBrokenException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1340198090568923005L;

	}

}
