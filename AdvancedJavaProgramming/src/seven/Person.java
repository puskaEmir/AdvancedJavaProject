package seven;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;


import eight.Gender;

//Person -> human_resource.person
public class Person {
	// implements Comparable<Person>
	private Integer id;
	private String name;
	private String surname;
	private LocalDate birthday;
	private Gender gender;

	public Integer getId() {
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

	public Integer getAge() {
		LocalDate now = LocalDate.now();
		Period period = birthday.until(now);
		return period.getYears();
	}

	@Override
	public String toString() {
		return "[" + id + "]" + " " + name + " " + surname + ", birthday:" + birthday.toString() + ", spol: "
				+ gender.toString();
	}
	
	
	//HashSet
	// p1.equals(a1)
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
	/*
	 * compareTo -> TreeSet primiti element tipa Person u sebe.
	 * <p> 
	 * Izbaciti duplikate
	 * <p> 
	 * Napraviti order ..redoslijed..
	 * <p>
	 * p1.compareTo(p2)
	 * -1  .... 0  .... 1
	 */
	/*
	@Override
	public int compareTo(Person o) {
		int result = 0;
		if(id < o.getId()) {
			result = -1;
		}
		if(id > o.getId()) {
			result = 1;
		}
		return result;
	}*/
}
