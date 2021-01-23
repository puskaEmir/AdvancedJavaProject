package five;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CopyLines {
	public static void main(String[] args) {
		//Decorator pattern -> Header First Design Patterns
		try(FileReader fr = new FileReader("imena.txt");
				BufferedReader br = new BufferedReader(fr);){
			String line = null;
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			//TODO
		}
	}
}
