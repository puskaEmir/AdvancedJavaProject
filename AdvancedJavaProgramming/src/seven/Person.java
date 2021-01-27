package seven;

import java.time.LocalDate;

//Person -> human_resource.person
public class Person {
	private int id;
	private String name;
	private String surname;
	private LocalDate birthday;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + ", name:" + name + " surname:" + surname;
	}
}
