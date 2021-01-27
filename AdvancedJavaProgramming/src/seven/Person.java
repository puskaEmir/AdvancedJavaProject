package seven;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import eight.Gender;

//Person -> human_resource.person
public class Person {
	private int id;
	private String name;
	private String surname;
	private LocalDate birthday;
	private Gender gender;

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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getAge() {
		LocalDate now = LocalDate.now();
		Period period = birthday.until(now);
		return period.getYears();
	}

	@Override
	public String toString() {
		return "[" + id + "]" + " " + name + " " + surname + ", birthday:" + birthday.toString() + ", spol: "
				+ gender.toString();
	}
	
	
	// true ili false
	//p1
	//p2
	//S1
	//p1.equals(p2)
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) {
			return false;
		}
		
		Person comparedPerson = (Person) obj;
		
		return id == comparedPerson.getId();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
