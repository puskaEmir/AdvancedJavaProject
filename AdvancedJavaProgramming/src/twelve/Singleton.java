package twelve;
/**
 * SINGLETON
 * <p>
 * @author emir
 *
 */
public class Singleton {

	private static Singleton ELVIS = new Singleton();
	
	private Singleton() {
		System.out.println("Singleton....");
	}
	
	public static Singleton getInstance() {
		return ELVIS;
	}
}
