package seven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import eight.Gender;

//Person -> PersonDao-> human_resource.person
/**
 * <li>1. Connection -> DriverManager
 * <li>2. Statement, PreparedStatement, CallableStatement-> connection
 * <li>3. ResultSet -> statement
 * 
 * @author emir
 *
 */
public class PersonDao {
	static final String USERNAME = "root";
	static final String PASSWORD = "Kadira1965*";
	static final String URL = "jdbc:mysql://localhost:3306/human_resource?useSSL=false";

	public void create(Person person) {
		// INSERT statement
	}

	public void update(Person person) {
		// UPDATE
	}

	public Person retrieve(int id) {
		return null;
	}

	public void delete(Person person) {
		// DELETE
	}

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
			while (resultSet.next()) {
				// 1. način da dobijem podatak iz neke kolone
				// MORAM ZNATI INDEKS
				// 2. način MORAM ZNATI IME kolone
				Person person = new Person(); // HASH CODE 2
				person.setId(resultSet.getInt(1));// id 1 2
				person.setName(resultSet.getString("name"));// name Amer Amer
				person.setSurname(resultSet.getString("surname")); // Bogilović
				Date birthdayDate = resultSet.getDate(4); //java.sql.Date
				LocalDate birthdayLocalDate = birthdayDate.toLocalDate();
				person.setBirthday(birthdayLocalDate);
				String spol = resultSet.getString("gender");
				person.setGender(spol.equals("MALE") ? Gender.MALE: Gender.FEMALE);
				personList.add(person);
			}
			Person person1 = new Person(); // HASH CODE 1
			person1.setId(1);
			person1.setName("Amer");
			person1.setSurname("Bogilović");
			person1.setBirthday(LocalDate.of(1985, 1, 1));
			person1.setGender(Gender.MALE);
			personList.add(person1);
			personList.add(person1);
			return personList;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return personList;
	}

}
