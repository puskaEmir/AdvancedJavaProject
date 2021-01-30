package nine;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import seven.Person;
import seven.PersonDao;
/**
 * 
 * Depend upon abstraction not upon concrete implementation.
 * <p>
 * Kad god možete da kreirate funkciju koja prima ArrayList vi recite ako ikako možete
 * da ta funkcija prima ne ArrayList nego List.
 * Zašto ????
 * Zbog toga što će u slučaju da funkcija prima ArrayList ona biti doživotno osuđena samo 
 * na objekte tipa ArrayList...... printPerson(objekat tipa ArrayList)..
 * <p>
 * Ako funkcija prima List a ne ArrayList ona funkciju mozete koristiti 
 * kada saljete objekte tipa ArrayLIst ...printPersons(objekat tipa ArrayLIst)
 * ... printPersons(objekat tipa LinkedLIst)..
 * <p>
 * printPersons(Collection objekat).--> 
 * <li>printPersons(objekat tipa ArrayList)
 * <li>printPersons(objekat tipa LinkedList)
 * <li>printPersons(objekat tipa HashSet)
 * <li>printPersons(objekat tipa LinkedHashSet)
 * <li>printPersons(objekat tipa TreeSet)....
 * <li>printPersons(objekat bilo klojeg tipa...preduvjet je jedino na taj objekat kroz svoju klasu implementira Collection)
 * 
 * 
 * <p>
 * 
 * 
 * @author emir
 *
 */
public class PersonExecutor {
	public static void main(String[] args) {
		//DAO -> Data Access Object
		//Person -> PersonDao -> human_resource.person
		PersonDao personDao = new PersonDao();
		List<Person> personList = personDao.retrieveAll();
		//printPersons(personList);
		//HashSet -> Set verzija
		//IZBACUJE DUPLIKATE .... hashCode i equals 
		Set<Person> setOfPersons = new HashSet<Person>(personList);
		//printPersons(setOfPersons);
		//LinkedHashSet -> Set verzija
		setOfPersons = new LinkedHashSet<Person>(personList);
		//printPersons(setOfPersons);
		//TreeSet -> Set verzija
		//TreeSet takođe izbacuje duplikate ... compareTo   p1.compareTo(p2).... -1  0  1
		setOfPersons = new TreeSet<Person>(personList);
		printPersons(setOfPersons);
	}
	
	//ArrayList, LInkedList, HashSet
	static void printPersons(Collection<Person> collectionOfPersons) {
		for(Person person: collectionOfPersons) {
			System.out.println(person);
		}
	}
}
