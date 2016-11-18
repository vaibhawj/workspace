package callCentre;

public class ProductManager implements IEmployee {

	private boolean freeFlag;

	@Override
	public synchronized boolean takeCall(Call call) {
		freeFlag = false;
		System.out.println("Product manager taking call");
		freeFlag = true;
		this.notifyAll();

		return true;
	}

	@Override
	public boolean isFree() {
		return freeFlag;
	}

}
