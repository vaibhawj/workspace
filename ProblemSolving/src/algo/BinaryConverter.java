package algo;

public class BinaryConverter {

	public static void main(String[] args) {
		int num = 8;
		BinaryConverter c = new BinaryConverter();
		System.out.println("Binary of " + num + " is ");
		System.out.println(c.convert(num));
	}

	public String convert(int num) {

		if (num < 2) {
			return String.valueOf(num);
		}

		int rem = num % 2;
		int div = num / 2;

		return convert(div) + String.valueOf(rem);

	}
}
