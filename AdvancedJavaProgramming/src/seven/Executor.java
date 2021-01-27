package seven;

import java.util.List;

public class Executor {
	public static void main(String[] args) {
		PersonDao personDao = new PersonDao();
		List<Person> personList = personDao.retrieveAll();
		for(Person person: personList) {
			System.out.println(person);
		}
	}
}
