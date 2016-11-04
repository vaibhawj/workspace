package downloadManager;

import java.util.List;
import java.util.Vector;

import downloadManager.MainEntry.TableRefresher;

public class DownloadManager {

	// private ExecutorService threadpool;

	public DownloadManager() {
		// threadpool = Executors.newFixedThreadPool(5);
	}

	public void startDownload(String url, String dest, Vector rowData, TableRefresher tableRefresher) {

		DownloadJob dj = new DownloadJob(url, dest, rowData, tableRefresher);
		Thread t = new Thread(dj);
		t.start();
	}

	public List getProgress() {
		return null;
	}

}
