package eleven;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import seven.Person;
import seven.PersonDao;

/**
 * 
 * <li>1. Funkcionalni interfejsi -> LAMBDA i ide još operator koji se zove
 * METHOD REFERENCING
 * <li>1. Predicate<T> tester -> T eleement -> true/false
 * <li>2. Consumer<T> consumer -> T element -> void
 * <li>3. Supplier<R> supplier -> () -> T element
 * <li>4. Function<T, R> transformer/mapper -> Person -> String
 * 
 * 
 * @author emir
 *
 */
public class Executor {

	public static void main(String[] args) {
		PersonDao personDao = new PersonDao();
		// TreeSet<Person> treeSet = new TreeSet<>(personDao.retrieveAll());
		// Iterator
		/*
		 * for(Person p : personList) { System.out.println(p); }
		 */
		// Spliterator: -> LAMBDA je shortcut za new operator
		// METHOD refernciranje je skraćenica za LAMBDU ->
		// 1. STATIC method referencing
		Consumer<Person> personConsumer = Executor::printElement;
		// treeSet.forEach(Executor::printElement);
		// 2. instance method referencing
		Executor executor = new Executor();
		// treeSet.forEach(executor::print);
		List<Person> personList = personDao.retrieveAll();
		/*
		 * Person[] arrayOfPersons = personList.toArray(new Person[personList.size()]);
		 * PersonAgeComparator ageComparator = new PersonAgeComparator();
		 * Arrays.sort(arrayOfPersons, Executor::compareByAge); for(Person p:
		 * arrayOfPersons) { System.out.println(p); }
		 */
		//
		Collections.sort(personList, Executor::compareByAge);
		personList.forEach(System.out::println);
		System.out.println("IDU PRezimena");
		personList.stream().map(Person::getName).forEach(System.out::println);

	}

	static int compareByAge(Person o1, Person o2) {
		// -1 0 1
		// o1 o2
		// o2 o1
		return o2.getAge().compareTo(o1.getAge());
	}

	<E> void print(E eleemnt) {
		System.out.println(eleemnt);
	}

	static <E> void printElement(E element) {
		System.out.println(element);
	}

	static class PersonAgeComparator implements Comparator<Person> {
		@Override
		public int compare(Person o1, Person o2) {
			return o1.getAge().compareTo(o2.getAge());
		}
	}

}
