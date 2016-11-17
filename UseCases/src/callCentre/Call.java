package callCentre;

public class Call {

	public boolean handle(IEmployee e) {
		return e.takeCall(this);

	}

}
