package four;

public class Person {
	private String name;
	private int age;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	public Person(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	//2019 -> 23
	//2020 -> 24
	public void setAge(int age) {
		this.age = age;
	}
}
