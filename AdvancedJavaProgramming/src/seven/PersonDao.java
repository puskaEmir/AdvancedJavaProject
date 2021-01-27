package seven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public List<Person> getAll() {
		List<Person> personList = new ArrayList<>();
		// try-with-resource
		try (Connection connection = 
				DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Statement statement = connection.createStatement();) {
			String selectStatement = "SELECT * FROM person";
			ResultSet rs = statement.executeQuery(selectStatement);
			while(rs.next()) {
				Person person = new Person();
				person.setId(rs.getInt(1));
				person.setName(rs.getString("name"));
				person.setSurname(rs.getString("surname"));
				personList.add(person);
			}
			
			return personList;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return personList;
	}

}
