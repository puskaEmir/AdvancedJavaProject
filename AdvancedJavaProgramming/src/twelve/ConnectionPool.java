package twelve;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *  
 * 
 * 
 * 2. List<Connection> -> POOL objekat 
 * 
 * 
 * 
 * 
 * 
 * <li> otvarate/zatvarate
 * 1. otvaranje konekcije na bazu --komunicira s DriverManager
 * 2. opennning tcp socket eread
 * 3. pisemo 
 * 4. closing connection
 * 5. close i socket 
 * 
 *  <li> List<Connection> pool ... Apache Common DBCP
 *  10 konekcija ... SQL upite INSERT, UPDATE, DELETE -> ConnectionPool pool 
 *                                                        Connection connectionIzPool = pool.getConnection();
 * 
 * 
 * 
 * @author emir
 *
 */
public class ConnectionPool {
	private String url;
	private String username;
	private String password;
	private List<Connection> connectionPool;
	private List<Connection> usedConnections = new ArrayList<Connection>();
	private static int  POOL_SIZE = 10;
	
	public ConnectionPool() {
		
	}
	
	
//	public static ConnectionPool create(String url, String password, String password) {
//		List<Connection> pool = new ArrayList<Connection>();
//		for(int i = 0; i<POOL_SIZE; i++) {
//			pool.add(null);
//		}
//		return null;
//	}
	
}
