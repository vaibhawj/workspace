package day1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class ParentOfA {

	protected int num;

	public ParentOfA() {
		System.out.println("Inside Parents const");
		this.num = 10;
	}

}

class A extends ParentOfA implements Serializable {

	int anum;
	B bb;

	public A() {
		System.out.println("Inside A default const");
	}

	public A(int a, int b) {
		System.out.println("Inside A const");
		bb = new B(b);
		this.anum = a;
	}

	class B implements Serializable {

		int bnum;

		public B(int b) {
			System.out.println("Inside B const");
			this.bnum = b;
		}

		public B() {
			System.out.println("Inside B default const");
		}

	}

}

public class SerializableExample {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		A a = new A(10, 20);
		a.num = 30;

		FileOutputStream fos = new FileOutputStream("temp.txt");
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(a);
		os.close();
		fos.close();

		FileInputStream fis = new FileInputStream("temp.txt");
		ObjectInputStream is = new ObjectInputStream(fis);
		A newA = (A) is.readObject();
		is.close();
		fis.close();
		System.out.println(newA.anum + newA.bb.bnum);
		System.out.println(newA.num);

	}
}
