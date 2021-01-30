package nine;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import eight.Gender;
import seven.Person;
import seven.PersonDao;

/**
 * Klasa može imati:
 * <li>1. polja ili atribute
 * <li>2. konstruktor mora imati
 * <li>3. funkcije ili metode
 * <li>4. INNER klase
 * <li>4.1 STATIC Inner klasa
 * <li>4.2.1 INNER klasa
 * <li>4.2.2 Anonymous inner type
 * <p>
 * Četiri važna funkcionalna interfejsa koja name je ponudila Java kao programski jezik
 * <li>1. Predicate<T> tester ->boolean test(T)
 * <li>2. Consumer<T> consumer -> void accept(T)
 * 
 * 
 * @author emir
 *
 */
public class CollectionExecutor {
	public static void main(String[] args) {
		/*
		 * //4.1. Static inner class object Outer.StaticInnerClass staticInnerObject =
		 * new Outer.StaticInnerClass(); // Outer outer = new Outer(); //4.2.1 Inner
		 * class object Outer.InnerClass innerObject= outer.new InnerClass(); //4.2.2
		 * Anonymous inner type Person person = new Person(); CheckPerson checkPerson =
		 * new CheckPerson() {
		 * 
		 * @Override public boolean test(Person p) { return p!=null; } }; //1.8 ->
		 * Functional Interface .. LAMBDA OPERATOR ...new ......objekte tipa
		 * funkcionalnog interfejsa -> CheckPerson checkPerson2 = (p)->p!=null; boolean
		 * testPass = checkPerson.test(person);
		 */
		Consumer<Person> personConsumer = p -> System.out.println(p);
		PersonDao personDao = new PersonDao();
		List<Person> personList = personDao.retrieveAll();
		// GUI-> TABELE ili LIST VIEW ili GRID ViEW
		//printPersonCollection(personList, p -> true, p->System.out.println(p));
		printPersonCollection(personList, p->p.getGender().equals(Gender.MALE), p->System.out.println(p));
		printPersonCollection(personList, p -> p.getGender().equals(Gender.MALE), p->p.setSurname("Ženino prezime"));
		System.out.println("NAKON promjene prezimena");
		printPersonCollection(personList, p->p.getGender().equals(Gender.MALE), p->System.out.println(p));
		
		
		personList.stream().filter(p->p.getGender().equals(Gender.FEMALE)).forEach(p->System.out.println(p));
	}
	
	//VI ŽELITE DA JEDNOM FUNKCIJOM zamijenite sve ove ispod funkcije
	//DRY -> Don't Repeat Yourself
	static void printPersonCollection(Collection<Person> collectionOfPersons, Predicate<Person> personChecker, Consumer<Person> personConsumer) {
		//Iterator
		/*for(Person person: collectionOfPersons) {
			if(personChecker.test(person)) {
				personConsumer.accept(person);
			}
		}*/
		//Spliterator -> Stream..IBM artikle 
		// 1. IZVOR Stream objekta
		// 2. INTERMEDIATE funkcijam ili operacijama Stream
		// 3. TERMINIRAJUĆA funkcija 
		collectionOfPersons.stream() // IZVOR Stream
		                   .filter(personChecker) // Stream -> novi stream koji je izbacio sve osobe koje nisu prošle test
		                   .forEach(personConsumer);//Terminirajuća operacija
		
		
		
		
		
		
	}
/*
	// Repeat Yourself -> DRY Don't Repeat Yourself
	static void printPersons(Collection<Person> personCollection) {
		for (Person person : personCollection) {
			System.out.println(person);
		}
	}*/

/*	static void printPersonsOlderThan(Collection<Person> personCollection, int age) {
		for (Person person : personCollection) {
			if (person.getAge() > age) {
				System.out.println(person);
			}
		}
	}*/

/*	static void printPersonsYoungerThan(Collection<Person> personCollection, int age) {
		for (Person person : personCollection) {
			if (person.getAge() <= age) {
				System.out.println(person);
			}
		}
	}*/

	/*static void printPersonsBetweenAge(Collection<Person> personCollection, int low, int high) {
		for (Person person : personCollection) {
			if (person.getAge() >= low && person.getAge() <= high) {
				System.out.println(person);
			}
		}
	}*/

/*	// Repeat Yourself -> DRY Don't Repeat Yourself
	static void printPersonsWithGender(Collection<Person> personCollection, Gender spol) {
		for (Person person : personCollection) {
			if (person.getGender().equals(spol)) {
				System.out.println(person);
			}
		}
	}*/
}
