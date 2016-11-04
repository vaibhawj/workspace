import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializerClass {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		FileInputStream fis = new FileInputStream("D:\\file.txt");
		ObjectInputStream is = new ObjectInputStream(fis);

		MySerialClass o = (MySerialClass) is.readObject();
		is.close();
		fis.close();

		System.out.println("Done");

	}

}
