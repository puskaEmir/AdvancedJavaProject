package six;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

	public void create(Person person) {
		// INSERT
	}

	public Person get(int id) {
		// RETRIEVE
		return null;
	}

	//INSTANCNA -> instanca ili objekat
	public List<Person> getAll() {
		// RETRIEVE ali više Person zapisa koje ćemo mapirati u List<Person>
		List<Person> personList = new ArrayList<Person>();
		//MySQL driver
		Person p1 = new Person(0, "Almisa", "Berhamović", LocalDate.of(1999, 1, 1), Gender.FEMALE);
		personList.add(p1);
		personList.add(p1);
		personList.add(new Person(0, "Almisa", "Berhamović", LocalDate.of(1999, 1, 1), Gender.FEMALE));
		personList.add(new Person(1, "Rijad", "Vatrić", LocalDate.of(1963, 1, 1), Gender.MALE));
		personList.add(new Person(2, "Esada", "Karović", LocalDate.of(2000, 9, 1), Gender.FEMALE));
		personList.add(new Person(3, "Amira", "Nuhić", LocalDate.of(2003, 1, 1), Gender.FEMALE));
		personList.add(new Person(4, "Nihad", "Ajanović", LocalDate.of(1996, 1, 1), Gender.MALE));
		personList.add(new Person(5, "Amer", "Agović", LocalDate.of(1979, 1, 1), Gender.MALE));
		personList.add(new Person(6, "Amer", "Bogilović", LocalDate.of(1985, 1, 1), Gender.MALE));
		personList.add(new Person(7, "Ali", "Šehović", LocalDate.of(1998, 1, 1), Gender.MALE));
		personList.add(new Person(8, "Nermina", "Šahbegović", LocalDate.of(2005, 1, 1), Gender.FEMALE));
		personList.add(new Person(9, "Muamer", "Đanko", LocalDate.of(1981, 1, 1), Gender.MALE));
		personList.add(new Person(10, "Emir", "Puška", LocalDate.of(1988, 1, 1), Gender.MALE));
		personList.add(new Person(11, "Zerina", "Hasić", LocalDate.of(2006, 1, 1), Gender.FEMALE));
		return personList;
	}
}
