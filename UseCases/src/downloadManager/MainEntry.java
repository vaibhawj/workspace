package downloadManager;

import java.util.List;
import java.util.Scanner;

public class MainEntry {

	private static DownloadManager dm = new DownloadManager();

	public static void main(String[] args) throws InterruptedException {

		Scanner in = new Scanner(System.in);

		System.out.println("Welcome to download manager");

		while (true) {
			String choice = showOptions(in);

			System.out.println("Okay!");
			switch (choice) {
			case "1":
				showProgress(in);
				break;

			case "2":
				addFileForDownload(in);
				break;

			case "3":
				System.out.println("Exiting...");
				System.exit(0);
				break;

			default:
				System.err.println("Wrong choice!");
				break;
			}
		}

	}

	private static void showProgress(Scanner in) {

		List progress = dm.getProgress();
		if (progress.isEmpty()) {
			System.out.println("Nothing to show");
		} else {
			progress.forEach(p -> System.out.println(p));
		}

		System.out.println("Press any key when you are done");
		in.nextLine();

	}

	private static String showOptions(Scanner in) {
		System.out.println("Options-");
		System.out.println("1. To see active downloads and status");
		System.out.println("2. To add file for download");
		System.out.println("3. Exit");
		System.out.println("Enter Choice");
		String choice = in.nextLine();
		return choice;
	}

	public static void addFileForDownload(Scanner in) {

		System.out.println("Enter url of source file");
		String url = in.nextLine();
		System.out.println("Enter destination directory");
		String dest = in.nextLine();
		dm.startDownload(url, dest);

		System.out.println("Download started. You can see the progress!");

	}

}
