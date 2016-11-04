package downloadManager;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadJob implements Runnable {

	private String url;
	private String downLoadDest;

	public DownloadJob(String url, String dest) {
		this.url = url;
		this.downLoadDest = dest;
	}

	@Override
	public void run() {
		try {
			URL website = new URL(url);
			String[] urlParts = url.split("/");
			String fileName = urlParts[urlParts.length - 1];
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(downLoadDest
					+ File.separator + fileName);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
