package externalSort;

import java.io.File;
import java.io.FileNotFoundException;

public class MainEntry {

	public static void main(String[] args) throws FileNotFoundException {
		String dir = "Users/vaibhawkumar/VBW/Work/ws2/workspace/UseCases/src/externalSort/";
		File dirFile = new File(dir);

		File[] files = dirFile.listFiles();

		// Sort each file
		for (File f : files) {
			sort(f);
		}

		// Read 20 MB from each file and perform k way merge

	}

	private static void sort(File f) {
		// TODO Auto-generated method stub

	}

}
