package one;

import java.time.LocalDate;

import one.animal.Cat;
import one.animal.Dog;
import one.animal.Hamster;

/**
 * <li>1. Enkapsulacija
 * <li>2. Nasljeđivanje
 * <li>3. Polimorfizam
 * <li>4. Apstrakcija -> abstract klasa, interface
 * @author emir
 *
 */
public class OneExecutor {
	
	public static void main(String[] args) {
		
		char slovo = 'A';
		slovo = 'B';
		
		char[] slova = new char[4];
		slova[0] = 'A';
		slova[1] = 'B';
		
		Person p = new Person();
		p.setName("Muamer");
		LocalDate pBirthday = LocalDate.of(1986, 1, 1);
		p = new Student();
		p.setBirthday(pBirthday);
		Dog dog = new Dog("Bingo");
		p.setAnimal(dog); 
		Cat c1 = new Cat("Tom");
		p.setAnimal(c1);
		Hamster h1 = new Hamster("Hrčko");
		p.setAnimal(h1);
		
	}

}
