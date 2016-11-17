package callCentre;

public class ProductManager implements IEmployee {

	@Override
	public boolean takeCall(Call call) {
		synchronized (this) {
			// handle call
			this.notifyAll();
		}
		return false;
	}

	@Override
	public boolean isFree() {
		// TODO Auto-generated method stub
		return false;
	}

}
