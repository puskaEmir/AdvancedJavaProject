package four;
/**
 * ArrayIndexOutOfBoundException
 * ArithmeticException
 * @author Faris
 *
 */
public class DemoExceptionExecutor {
	public static void main(String[] args) {
		String[] names = new String[3];
		names[0] = "Faris";
		//names[3] = "Amer";// Ovdje će program pasti 
		
		int number = 23;
		//int result = 23/0; // ArithmeticException 
		//RuntimeException -> 
		Person person = null;
		System.out.println(person.getName());
	}
}
