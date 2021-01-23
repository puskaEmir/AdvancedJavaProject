package six;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

//1. provjeravanje -> checked
//2. neprovjeranje -> unchecked /0
/**
 * <li>1. Predicate<T> tester -> tester.test(p) -> true/false
 * <li>2. Consumer<T> consumer -> accept  -> void
 * 
 * 
 * @author emir
 *
 */
public class Executor {
	public static void main(String[] args) {
		PersonDao personDao = new PersonDao();

		//Brian Goetz -> OOP ili FP .... OO i FP -> moć 
		List<Person> listOfPerson = personDao.getAll();
		//Kada kreiramo objekte tipa FUNCKIONALNOG interfejsa 
	
		//T -> Person
		Predicate<Person> tester = p -> true; // input ->p  -> output true/false
		Consumer<Person> personConsumer = p ->System.out.println(p);
		processPersons(listOfPerson, tester,personConsumer);
		//printPersons(listOfPerson, p->p.getGender().equals(Gender.FEMALE));
		//ZAKLJUČAK: operator LAMBDA ->  ... on mijenja operator new (NE UVIJEK) -> kada kreira objekat tipa FUNKCIONALNOG INTERFEJSA
		// LAMBDA -> definira blok koda apstraktne -> ne želi da definira blok koda više apstraktnih metoda
		// LAMBDA se i zbog toga veže samo za funkcionalni interfejs
	}
	
	
	

	
	
	
	
	//DOn't Repeat Yourself
	static void processPersons(Collection<Person> persons, Predicate<Person> tester, Consumer<Person> personConsumer) {
		//Iterator -> Spliterator 
		for (Person person : persons) {
			if(tester.test(person)) {
				personConsumer.accept(person);
			}
		}
	}
	/*
	static void printPersonWithGender(Collection<Person> persons, Gender gender) {
		for (Person person : persons) {
			if(person.getGender().equals(gender)) {
				System.out.println(person);
			}
		}
	}
	

	static void printPersonsYoungerThan(Collection<Person> persons, int age) {
		for (Person person : persons) {
			if(person.getAge()>=age) {
				System.out.println(person);
			}
		}
	}
	
	static void printPersonsOlderThan(Collection<Person> persons, int age) {
		for (Person person : persons) {
			if(person.getAge()<age) {
				System.out.println(person);
			}
		}
	}
*/
	/**

	//osudio Set -> HAshSet, LinkedHashSet, TreeSet -> 
	static void printSetOfPerson(Set<Person> persons) {
		for (Person person : persons) {
			System.out.println(person);
		}
	}

	// osudio samo na List -> ArrayList; LinkedList
	static void printListOfPerson(List<Person> persons) {
		for (Person person : persons) {
			System.out.println(person);
		}
	}*/

}
