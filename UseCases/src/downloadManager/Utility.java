package downloadManager;

public class Utility {

	public static String getFileNameFromURL(String url) {
		String[] urlParts = url.split("/");
		String fileName = urlParts[urlParts.length - 1];

		return fileName;

	}

}
