package nine;
//zašto ti klaso postojiš ??
//objekataaaaa
public class Outer {

	private int x;
	
	//STATIC INNER class
	static class StaticInnerClass{
		private int x;
	}
	
	//INNER -> preduvjet objekat kreiran po šablonu InnerClass je postojanje objekta outer klase
	class InnerClass{
		private int x;
	}
	
}
