package day4.singleton;

public enum SingletonEnum {

	INSTANCE;

	public void fun() {

	}

	public static void main(String[] args) {

		SingletonEnum obj = SingletonEnum.INSTANCE;

		SingletonEnum obj2 = SingletonEnum.INSTANCE;

		System.out.println(obj == obj2);

	}

}
