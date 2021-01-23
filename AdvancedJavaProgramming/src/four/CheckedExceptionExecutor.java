package four;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * <li>File
 * <li>FileWriter
 * <li>PrintWriter
 * 
 * @author Faris
 *
 */
public class CheckedExceptionExecutor {
	public static void main(String[] args) {
		List<String> listOfNames = new ArrayList<>();
		listOfNames.add("Muamer");
		listOfNames.add("Amer");
		listOfNames.add("Inda");
		listOfNames.add("Esada");
		listOfNames.add("Rijad");
		File file = new File("imena.txt");
		// try-catch-finally <1.7
		// 1.7 try-with-resource
		try (PrintWriter out = new PrintWriter(file)) {
			for (String name : listOfNames) {
				System.out.println();
				out.println(name);
			}
		} catch (FileNotFoundException fileNotFoundException) {
			JOptionPane.showMessageDialog(null, "Unesite pravo ime fajla");
		} catch (IOException exception) { // FileNotFoundException IOException
			System.err.println(exception.getMessage());
		}
	}
}
