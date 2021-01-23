package three;

import java.util.*;

/**
 * 
 * Teme koje ćemo obrađivati:
 * <li> 1. Collection API(library)
 * <li> 2. Detekcije i obrade grešaka -> Exception Handling
 * 
 * @author emir
 *
 */
public class ThreeExecutor {
	
	public static void main(String[] args) {
		String[] names = new String[4];
		names[0] = "Almisa";
		names[1] = "Inda";
		names[2] = "Esada";
		names[3] = "Nermina";
		/*for(String ime : names) {
			System.out.println(ime);
		}*/
		//pamti redoslijed, pamti indekse elemenata, prima duplikate
		//pamti redoslijed, ne pamti indekse, ne trebaju duplikate 
		//NATURAL ORDER -> abecedno slaže elemente
		Set<String> collectionOfNames = new TreeSet<String>(); //LinkedList
		collectionOfNames.add("Almisa"); // -> "Almisa" -> hashCode -> ubaci element sa proračunim hashCode
		collectionOfNames.add("Inda"); // -> "Inda" -> hashCode -> ubaci elementa sa proračn...
		collectionOfNames.add("Esada"); // -> "Esada" -> hashCode -> ubaci e
		collectionOfNames.add("Nermina");
		collectionOfNames.add("Amer");// -> "Amer" -> hashCode -> ubaci hashCode i element u kolekciju
		collectionOfNames.add("Amer"); // -> "Amer" -> hashCode -> equals(hashCodeOdNekogPrethodno) -> izvini Amere ja imam već Amera
		collectionOfNames.add("Amer");// -> 
		collectionOfNames.add("Amer"); // -> 
		printCollection(collectionOfNames);
		
		//MySQL -> SQL 
		//Tabela podataka _> mnogo redova -> 
		//NoSQL -> caching baze, Document based 
		//fajlova -> xml, .txt, xls, pdf 
	}
	
	static void printCollection(Collection<String> lista) {
		for(String name: lista) { // Java koristi Iterator<String>
			System.out.println(name);
		}
	}
}
