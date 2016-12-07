package dec7;

import java.io.Serializable;

public class A implements Serializable {

	private String name;

	private int num;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int id) {
		this.num = id;
	}

	@Override
	public String toString() {
		return this.num + " " + this.name;
	}

	public A(int id, String name) {
		this.num = id;
		this.name = name;
	}

}
