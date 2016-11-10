package day5.statePattern;

public class UpState implements State {

	public UpState() {
		System.out.println("Mario stands tall on ground");
	}

	@Override
	public void handleUpKey(Mario mario) {
		mario.setState(new JumpState());
	}

	@Override
	public void handleDownKey(Mario mario) {
		mario.setState(new DuckState());
	}

}
