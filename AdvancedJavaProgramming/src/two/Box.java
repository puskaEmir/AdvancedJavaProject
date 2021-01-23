package two;
/**
 * Generički tip
 * <li> 1. UNBOUNDED GENERIC TYPE
 * @author emir
 *
 * @param <G>
 */
public class Box<G> {
	private G polje;
	
	public Box() {
		// TODO Auto-generated constructor stub
	}
	
	public G getPolje() {
		return polje;
	}
	
	public void setPolje(G polje) {
		this.polje = polje;
	}

}
