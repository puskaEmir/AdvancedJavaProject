package one.animal;

public abstract class Animal {
	
	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void playSound();
	
	

}
