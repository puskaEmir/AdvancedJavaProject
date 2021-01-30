package nine;

import seven.Person;

@FunctionalInterface
public interface CheckPerson {
	// pozove ova metoda -> postojanje objekta tipa CheckPerson
	// preduvjet je i da postoji blok koda metode koji će se izvršiti na poziv ove
	// metode
	boolean test(Person p);
}
