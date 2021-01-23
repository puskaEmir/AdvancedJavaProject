package two.collection;

/**
 * Klasa postoji zašto ?
 * 
 * 
 * 
 * @author emir
 *
 */

import java.time.LocalDate;
import java.time.Period;

import one.Gender;

public class Person {
	private String name;
	private String surname;
	private LocalDate birthday;
	private String emailAddress;
	private Gender gender;

	public Person() {
		System.out.println("Kreiram person objekat");
	}
	
	public int getAge() {
		LocalDate now = LocalDate.now();
		Period period = birthday.until(now);
		int age = period.getYears();
		return age;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
	

}
