package two;
//Unbounded generic type
public class BrojevnaKutija<B extends Number>{

	private B number;
	
	public BrojevnaKutija() {
		// TODO Auto-generated constructor stub
	}
	
	public void setNumber(B number) {
		this.number = number;
	}
	
	public B getNumber() {
		return number;
	}
}
