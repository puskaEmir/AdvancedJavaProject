package eleven;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


// PRoces1  -> vlastitu RAM ---> 100 
// Proces2  -> vlastita RAM -> 
public class ElevenExecutor {
	
	public static void main(String[] args) {
		//List,Set, Map
		//  k,v   k uvijek razlicit value = fiksni
		// k,v .> vvalue uvijek fiksno
		Set<String> setOfNames = new HashSet<String>();
		//Map -> entry K, V
		// hashing -> hashCode ... "Faris" ->hashCode int
		// equals
		// entry elemenata -> k,v
		Map<String, Integer> map = new HashMap<>(); 
		// 1000 ->  n = 16 
		map.put("Zerina", 12); // unos "Zerina" 12
		map.put("Zerina", 12); // unos "Zerina" 12
		map.put("Esada", 12);
		map.put("Rijad", 12);
		map.put("Ali", 12);
		
		Integer zerininBroj = map.get("Zerina");
		Integer esadinBroj = map.get("Esada");
		Integer rijadovBroj = map.get("Rijad");
		
		//equals & hashCode  :: Ako su dva objekat jednaka onda treba da imaju isti hash code
		// p1.equals(p2) -> true  -> p1.hashCode i p2.hashCode 
		
		
	}

}
