package day5.statePattern;

public class JumpState implements State {

	public JumpState() {
		System.out.println("Mario Jumps");
	}

	@Override
	public void handleUpKey(Mario mario) {
		System.out.println("Mario can't fly. He is gonna come down soon");
	}

	@Override
	public void handleDownKey(Mario mario) {
		mario.setState(new UpState());
	}

}
