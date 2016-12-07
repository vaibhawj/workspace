package dec7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	static final String FILE = "file.txt";

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		// write();
		read();
	}

	private static void write() throws FileNotFoundException, IOException {
		A a = new A(10, "vibe");

		FileOutputStream fos = new FileOutputStream(FILE);
		ObjectOutputStream os = new ObjectOutputStream(fos);

		os.writeObject(a);
		fos.close();
	}

	private static void read() throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream(FILE);
		ObjectInputStream is = new ObjectInputStream(fis);

		A a = (A) is.readObject();
		is.close();
		System.out.println(a);

	}

}
