package day13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CollectionSerialEx {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		Map<MyKey, MyValue> map = new HashMap<>();
		map.put(new MyKey("k1"), new MyValue("v1"));
		map.put(new MyKey("k2"), new MyValue("v2"));

		FileOutputStream fos = new FileOutputStream("temp.txt");
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(map);
		os.close();

		FileInputStream fis = new FileInputStream("temp.txt");
		ObjectInputStream is = new ObjectInputStream(fis);
		Map<MyKey, MyValue> mapRead = (Map<MyKey, MyValue>) is.readObject();
		is.close();
		System.out.println(mapRead);

	}

	static class MyKey implements Serializable {
		String key;

		public MyKey(String key) {
			this.key = key;
		}

		@Override
		public String toString() {
			return this.key;
		}
	}

	static class MyValue implements Serializable {
		String value;

		public MyValue(String v) {
			this.value = v;
		}

		@Override
		public String toString() {
			return this.value;
		}
	}
}
