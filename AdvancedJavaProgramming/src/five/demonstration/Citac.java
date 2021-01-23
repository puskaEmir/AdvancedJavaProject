package five.demonstration;

import java.io.Closeable;


public class Citac implements Closeable{

	@Override
	public void close()  {
		System.out.println("Poziva se CLOSE metoda...");
	}
}
