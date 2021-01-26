package six;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDemo {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Books?useSSL=false", "root","Kadira1965*");
				Statement statement = connection.createStatement();){

			ResultSet rs = statement.executeQuery("SELECT * FROM author");
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
