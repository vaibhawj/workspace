package callCentre;

public class Fresher implements IEmployee {

	private boolean freeFlag;

	@Override
	public synchronized boolean takeCall(Call call) {
		freeFlag = false;
		System.out.println("Fresher taking call");

		freeFlag = true;

		return true;
	}

	@Override
	public boolean isFree() {
		return freeFlag;
	}

}
