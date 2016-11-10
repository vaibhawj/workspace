package day5.statePattern;

public class DuckState implements State {

	public DuckState() {
		System.out.println("Mario ducks");
	}

	@Override
	public void handleUpKey(Mario mario) {
		mario.setState(new UpState());
	}

	@Override
	public void handleDownKey(Mario mario) {
		System.out.println("Mario keeps ducking");
	}

}
