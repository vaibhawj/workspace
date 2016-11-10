package day4.singleton;

import java.io.Serializable;

public class MySingleton implements Cloneable, Serializable {

	private static MySingleton instance;

	// Prone to reflection attack
	private MySingleton() {

		if (null != instance) {
			throw new IllegalStateException();
		}
	}

	public static MySingleton getInstance() {

		if (null == instance) {
			synchronized (MySingleton.class) {
				if (null == instance) {
					instance = new MySingleton();
				}
			}
		}

		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		return instance;
	}

	protected Object readResolve() {
		return instance;
	}
}
