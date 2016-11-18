package callCentre;

public class TechnicalLead implements IEmployee {

	private boolean freeFlag;

	@Override
	public synchronized boolean takeCall(Call call) {
		freeFlag = false;
		System.out.println("Tech lead taking call");
		freeFlag = true;
		this.notifyAll();

		return true;
	}

	@Override
	public boolean isFree() {
		return freeFlag;
	}

}
