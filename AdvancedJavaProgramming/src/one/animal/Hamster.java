package one.animal;


//Head first design patterns
public class Hamster extends Animal{

	public Hamster(String name) {
		super(name);
	}

	@Override
	public void playSound() {
		System.out.println("Ciju CIju");
	}

}
