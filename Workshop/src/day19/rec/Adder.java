package day19.rec;

public class Adder {

	public static void main(String[] args) {
		Adder adder = new Adder();
		System.out.println(adder.add(5, 6));

	}

	public int add(int a, int b) {
		if (b == 0) {
			return a;
		}

		return add(++a, --b);

	}

}
