package day5.statePattern;

public class Mario {

	private State currentState;

	public State getState() {
		return currentState;
	}

	public void setState(State state) {
		this.currentState = state;
	}

	public Mario() {
		System.out.println("Press U for up, D for down, E for exit");
		currentState = new UpState();
	}

	public void handleInput(String choice) {

		switch (choice.toUpperCase()) {
		case "U":
			currentState.handleUpKey(this);
			break;

		case "D":
			currentState.handleDownKey(this);
			break;

		case "E":
			System.out.println("Mario says bye for now");
			System.exit(0);

		default:
			break;
		}

	}

}
