package seven;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import eight.Gender;
import ten.Dao;
/**
 * <li>1. Connection -> DriverManager
 * <li>2. Statement, PreparedStatement, CallableStatement-> connection
 * <li>3. ResultSet -> statement
 * 
 * @author emir
 *
 */
public class PersonDao implements Dao<Person> {
	static final String USERNAME = "root";
	static final String PASSWORD = "Kadira1965*";
	static final String URL = "jdbc:mysql://localhost:3306/human_resource?useSSL=false";

	//DDL -> CREATE, ALTER 
	//DML -> SELECT, INSERT, UPDATE, DELETE
	@Override
	public Person insert(Person person) {
		try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = connection.prepareStatement("INSERT INTO person (name,surname,birthday,gender) VALUES(?,?,?,?)")){
			 ps.setString(1, person.getName());
			 ps.setString(2, person.getSurname());
			 Date birthday = Date.valueOf(person.getBirthday());
			 ps.setDate(3, birthday);
			 ps.setString(4, person.getGender().toString());
			 ps.execute();
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return null;

	}

	@Override
	public Person update(Person object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Person retrieve(int id) {
		return null;
	}
	
	

	@Override
	public boolean delete(Person object) {
		System.out.println("Ovdje ide statement za brisanje jedno reda iz baze podataka....");
		return false;
	}

	@Override
	public List<Person> retrieveAll() {
		// 1 red u tabeli person -> 1 objektom po šablonu klase Person
		// n redova iz tabele person -> n objekata kreiranih po šablonu klase Person
		List<Person> personList = new ArrayList<>();
		// try-with-resource
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Statement statement = connection.createStatement();) {
			String selectStatement = "SELECT * FROM person";
			// RDBMS MySQL
			ResultSet resultSet = statement.executeQuery(selectStatement);
			while (resultSet.next()) { // false i pozicionirat će kursor na prvi red
				// 1. način da dobijem podatak iz neke kolone
				// MORAM ZNATI INDEKS
				// 2. način MORAM ZNATI IME kolone
				Person person = new Person(); // 1234
				person.setId(resultSet.getInt(1));// id 1 2
				person.setName(resultSet.getString("name"));// name Amer Amer
				person.setSurname(resultSet.getString("surname")); // Bogilović
				Date birthdayDate = resultSet.getDate(4); // java.sql.Date
				LocalDate birthdayLocalDate = birthdayDate.toLocalDate();
				person.setBirthday(birthdayLocalDate);
				String spol = resultSet.getString("gender");
				person.setGender(spol.equals("MALE") ? Gender.MALE : Gender.FEMALE);
				personList.add(person);
			}
			// new new -> add, add, add
			Person person1 = new Person(); // 5678
			person1.setId(1);
			person1.setName("Amer");
			person1.setSurname("Bogilović");
			person1.setBirthday(LocalDate.of(1985, 1, 1));
			person1.setGender(Gender.MALE);
			personList.add(person1);// -> 5678 .... 1234
			personList.add(person1);// -> 5678.....
			return personList;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return personList;
	}
	
	@Override
	public List<Person> retrieveAll(int limit) {
		// TODO Auto-generated method stub
		return null;
	}
}
