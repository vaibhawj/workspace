package downloadManager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

import downloadManager.MainEntry.TableRefresher;

public class DownloadJob implements Runnable {

	private String url;
	private String downLoadDest;
	private Vector rowData;
	private TableRefresher tableRefresher;

	public DownloadJob(String url, String dest, Vector rowData, TableRefresher tableRefresher) {
		this.url = url;
		this.downLoadDest = dest;
		this.rowData = rowData;
		this.tableRefresher = tableRefresher;
	}

	@Override
	public void run() {
		try {
			URL website = new URL(url);
			String fileName = Utility.getFileNameFromURL(url);
			URLConnection conn = website.openConnection();
			int size = conn.getContentLength();

			BufferedInputStream in = null;
			FileOutputStream out = null;
			in = new BufferedInputStream(website.openStream());
			out = new FileOutputStream(downLoadDest + File.separator + fileName);
			byte data[] = new byte[1024];
			int count;
			double sumCount = 0.0;

			while ((count = in.read(data, 0, 1024)) != -1) {
				out.write(data, 0, count);
				sumCount += count;
				if (size > 0) {
					String percentage = Math.round((sumCount / size * 100.0)) + "%";
					this.rowData.set(2, percentage);
					tableRefresher.refreshTable();
				}
				// TODO Remove sleep
				Thread.sleep(1000);
			}
			out.close();
			in.close();
			this.rowData.set(2, "100%");
			tableRefresher.refreshTable();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
