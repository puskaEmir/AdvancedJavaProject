package ten;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.mysql.fabric.xmlrpc.base.Array;

import seven.Person;
import seven.PersonDao;

// person Person PersonDao
// orders Order  OrderDao
// customers Customer CustomerDao
// products Product ProductDao
public class TenExecutor {

	public static void main(String[] args) {
		// person -> redovi
		// Person -> objekti kreirani po šablonu klase
		// Dao-> Data Access Object -> PersonDao...ResultSet -> objekte
		Dao<Person> personDao = new PersonDao();
		// više redova uvijek mapirano na kolekciju objekata
		List<Person> personList = personDao.retrieveAll();
		// add add add
		// new new
		Set<Person> personSet = new TreeSet<>(personList);
		// p1 set ->
		// p2 set x p1.compareTo(p2)
		// p3 set x p1.compareTo(p3)
		TenExecutor tenExecutor = new TenExecutor();
		tenExecutor.printElements(personList);
		List<String> names = new ArrayList<>();
		names.add("Bingo");
		names.add("Tom");
		tenExecutor.printElements(names);

		
		// HashSet  -> HashMap
		//HashMap -> k,v - 16 elemenat 
		//entry1  hash  4 3 
		// entry 2 hash 4 3 ...16 

	}

	public <E> void printElements(Collection<E> elements) {
		for (E element : elements) {
			System.out.println(element);
		}
	}

}
