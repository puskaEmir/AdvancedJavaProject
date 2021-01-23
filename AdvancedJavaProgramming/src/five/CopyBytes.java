package five;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//STREAM bytes -> 01011100010
/**
 * <li>FileInputStream
 * <li>FileOutputStream
 * 
 * @author emir
 *
 */
public class CopyBytes {
	public static void main(String[] args) {
		File file = new File("imena.txt");
		try (FileInputStream input = new FileInputStream(file);) {
			int sadrzaj;
			while((sadrzaj = input.read())!=-1) {
				System.out.println(sadrzaj);
			}
		} catch (IOException exception) {

		}
	}
}
