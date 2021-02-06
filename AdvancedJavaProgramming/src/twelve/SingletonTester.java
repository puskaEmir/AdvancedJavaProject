package twelve;

import java.lang.reflect.Constructor;
/*
 * ORM alat Hibernate, MyBAtis, Toplink
 */
public class SingletonTester {
	public static void main(String[] args) throws Exception{
		//Effective Java Josh Bloch
		Singleton singleton1 = Singleton.getInstance();
		System.out.println(singleton1.hashCode());
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton2.hashCode());
		Singleton singleton3 = Singleton.getInstance();
		System.out.println(singleton3.hashCode());
		//Refleksija -> private
		// .java -> .class -> singleton --- Class 
		Class andeoCuvarElvisa = Class.forName("twelve.Singleton");
		//Method Constructors Field
		Constructor<Singleton> constructor = andeoCuvarElvisa.getDeclaredConstructor();
		constructor.setAccessible(true);
		Singleton elvis2 = constructor.newInstance();
		System.out.println(elvis2.hashCode());
		
	}
}
