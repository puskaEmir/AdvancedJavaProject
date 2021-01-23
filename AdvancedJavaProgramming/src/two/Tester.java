package two;

import java.time.LocalDate;
import java.util.ArrayList;

import two.collection.Person;

/**
 * <li>1. Prosti tipovi
 * <li> 2.1 Složeni ili objektni
 * <li> 2.2 Parametrizovani objektni tipovi
 * 
 * 
 * @author emir
 *
 */
public class Tester {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("Amer");
		Box<String> amerovaKutija = new Box<String>();
		amerovaKutija.setPolje("Amerov omiljeni string");
		//Ja hocu kutiju ? ali neću u njoj da čuvam String
		Box<Double> amer2Kutija = new Box<>();
		//int
		//LocalDate
		Box<LocalDate> almisinaKutija = new Box<>();
		LocalDate datumNekiAlmisin = LocalDate.of(2000, 1, 1);
		almisinaKutija.setPolje(datumNekiAlmisin);
		//double
		Box<Person> alijevaKutija = new Box<Person>();
		alijevaKutija.setPolje(person);
		
		BrojevnaKutija<Integer> zerininaKutija = new BrojevnaKutija<Integer>();
		zerininaKutija.setNumber(23);
		
		BrojevnaKutija<RijadovBroj> rijadovaKutija = new BrojevnaKutija<>();
		//OGRANIČENJE NIZA
		//1. fiksna dužina
		//2. svi unutar niza moraju biti istog tipa  -> OČEKIVANO PONAŠANJE SVAKOG NIZA
		ArrayList<String> names = new ArrayList<String>();
		names.add("Faris");
		names.add("Ali");
		
		
		
		
	}

}
