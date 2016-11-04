import java.io.Serializable;

public class MySerialClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4965168203768200534L;

	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public MySerialClass() {
	}

	public MySerialClass(int n) {
		this.num = n;
	}

}
