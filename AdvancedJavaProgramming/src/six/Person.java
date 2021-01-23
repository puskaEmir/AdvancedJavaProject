package six;

/**
 * social_network -> person
 * 
 * <p>
 * 
 * @author emir
 *
 */

import java.time.LocalDate;
import java.time.Period;

public class Person {
	private int id;
	private String name;
	private String surname;
	private LocalDate birthday;
	private Gender gender;

	public Person(int id, String name, String surname, LocalDate birthday, Gender gender) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.gender = gender;
	}

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
		Period periodOdRodjenja = birthday.until(now);
		int years = periodOdRodjenja.getYears();
		return years;
	}

	@Override
	public String toString() {
		return id + " : " + name + " " + surname + " birthday:" + birthday.toString() + " gender:" + gender.toString();
	}
}
