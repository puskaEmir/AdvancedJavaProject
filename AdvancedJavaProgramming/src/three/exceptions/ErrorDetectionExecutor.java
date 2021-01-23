package three.exceptions;

import java.io.File;
import java.io.FileWriter;

/**
 * Loše stvari:
 * <li>1. pokušaj da pristupimo elementu unutar niza koji ne postoji
 * 
 * 
 * @author emir
 *
 */
public class ErrorDetectionExecutor {
	public static void main(String[] args) {
		//ErrorDetectionExecutor.java -> IDE javac -> ErrorDetectionExecutor.class -> RUNTIME -> mašinski kod
		String[] names = new String[2];
		names[0] = "Muamer";
		names[1] = "Zerina";
		names[3] = "Emir";//Ispoštovao sintaksu programsku ArrayIndexOutOfBounException
		//ArrayIndexOutBoundException
		//Klasa postoji zašto ??
		//ODGOVOR: da se kreira instanca ili objekat ili varijabla po šablonu klase
		//JRE -> Java Runtime Environment
		//ArrayIndexOutBoundException -> RuntimeException
		File file = new File("nekiFajl.txt");
		//FileWriter fileWriter = new FileWriter(file); // Checked Exception -> try-catch-finally ili try-with-resource
		
		System.out.println("Vozdra raja. .... dosta nam je za danas");
	}
}
