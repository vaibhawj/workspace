package downloadManager;

import java.util.List;

public class DownloadManager {

	public void startDownload(String url, String dest) {

		DownloadJob dj = new DownloadJob(url, dest);
		Thread t = new Thread(dj);
		t.start();
	}

	public List getProgress() {
		return null;

	}

}
