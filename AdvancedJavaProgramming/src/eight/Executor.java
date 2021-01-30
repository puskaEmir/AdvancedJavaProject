package eight;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seven.Person;
import seven.PersonDao;

public class Executor {
	public static void main(String[] args) {
		PersonDao personDao = new PersonDao();
		List<Person> personList = personDao.retrieveAll();
		//printCollection(personList);
		//hashCode i equals 
		Set<Person> setOfPersons = new HashSet<Person>(personList);
		printCollection(setOfPersons);
	}
	
	static void printCollection(Collection<Person> listOfPerson) {
		for(Person p: listOfPerson) {
			System.out.println(p);
		}
	}
}
