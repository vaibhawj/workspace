package day22;

public class BitWiseShift {

	static final int HASH_BITS = 0x7fffffff;

	public static void main(String[] args) {
		// 11 -> 1 =1
		System.out.println(3 >> 1);

		// 10 -> 1 =1
		System.out.println(2 >> 1);

		// 100 -> 10 =2
		System.out.println(4 >> 1);

		// 11 -> 110 =6
		System.out.println(3 << 1);

		// 10 -> 100 =4
		System.out.println(2 << 1);

		// unsigned shift
		// TODO

	}

	static final int spread(int h) {
		return (h ^ (h >>> 16)) & HASH_BITS;
	}

}
