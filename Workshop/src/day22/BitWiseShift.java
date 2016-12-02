package day22;

public class BitWiseShift {

	public static void main(String[] args) {

		int i = -2;
		System.out.println(i + " << " + (i << 1));

		i = -2;
		System.out.println(i + " >> " + (i >> 1));

		i = 2;
		System.out.println(i + " << " + (i << 1));

		i = 2;
		System.out.println(i + " >> " + (i >> 1));

		i = -2;
		System.out.println(i + " >>> " + (i >>> 1));

		i = 2;
		System.out.println(i + " >>> " + (i >>> 1));

	}

}
