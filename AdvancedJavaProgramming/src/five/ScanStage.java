package five;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class ScanStage {
	public static void main(String[] args) {

		File file = new File("imena.txt");
		try (Scanner fileScanner = new Scanner(file)) {
			fileScanner.useLocale(Locale.GERMAN);
			while (fileScanner.hasNextDouble()) {
				double number = fileScanner.nextDouble();
				System.out.println(number);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}
}
