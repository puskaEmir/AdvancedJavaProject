package five;

import java.io.FileReader;
import java.io.IOException;

//FileReader
public class CopyCharacters {

	public static void main(String[] args) {

		try (FileReader fileReader = new FileReader("imena.txt")) {
			int sadrzaj;
			while ((sadrzaj = fileReader.read()) != -1) {
				System.out.println(sadrzaj);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
