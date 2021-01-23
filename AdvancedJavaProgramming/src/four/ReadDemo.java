package four;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

//FileReader
//BufferedReader ->
public class ReadDemo {

	public static void main(String[] args) {

		try (FileReader fr = new FileReader("imena.txt");
				BufferedReader br = new BufferedReader(fr)) {
			String line = null; 
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException exception) {
			JOptionPane.showMessageDialog(null, "Unesi pravo ime fajla");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
