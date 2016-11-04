import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializerClass {

	public static void main(String[] args) throws IOException {

		MySerialClass o = new MySerialClass(10);

		FileOutputStream fos = new FileOutputStream("D:\\file.txt");
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(o);
		os.close();
		fos.close();

		System.out.println("Done");

	}
}
