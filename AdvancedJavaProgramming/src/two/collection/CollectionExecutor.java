package two.collection;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionExecutor {
	
	public static void main(String[] args) {
		//collection, list, ArrayList
		Collection<String> kolekcijaImena = new LinkedList<String>();
		kolekcijaImena.add("Inda");
		kolekcijaImena.add("Inda");
		kolekcijaImena.add("Inda");
		kolekcijaImena.add("Nihada");
		kolekcijaImena.add("Almisa");
		kolekcijaImena.add("Nermina");
		kolekcijaImena.add("Mumaer");
		System.out.println("PRINT LIST");
		printCollection(kolekcijaImena);
		System.out.println();
		kolekcijaImena = new TreeSet<String>();
		kolekcijaImena.add("Inda");
		kolekcijaImena.add("Inda");
		kolekcijaImena.add("Inda");
		kolekcijaImena.add("Nihada");
		kolekcijaImena.add("Almisa");
		kolekcijaImena.add("Nermina");
		kolekcijaImena.add("Mumaer");
		System.out.println("PRINT  SET");
		printCollection(kolekcijaImena);
		
	}

	
	static void printCollection(Collection<String> kolekcija) {
		for(String name: kolekcija) {
			System.out.println(name);
		}
	}
	
	static void printList(List<String> kolekcija) {
		for(String name: kolekcija) {
			System.out.println(name);
		}
	}
	
	static void printSet(Set<String> kolekcija) {
		for(String name: kolekcija) {
			System.out.println(name);
		}
	}
}
