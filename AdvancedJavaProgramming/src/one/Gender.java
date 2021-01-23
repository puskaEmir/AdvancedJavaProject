package one;

public enum Gender {

	MALE("Muški rod"), FEMALE("Ženski rod");

	private String name;

	private Gender(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
