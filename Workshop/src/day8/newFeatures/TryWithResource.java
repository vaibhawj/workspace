package day8.newFeatures;

import java.io.FileReader;
import java.io.IOException;

public class TryWithResource {

	public static void main(String[] args) {

		try (FileReader f = new FileReader("temp.txt")) {
			System.out.println(f.read());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally");
		}

	}
}
