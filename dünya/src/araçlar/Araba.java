package araçlar;

public class Araba extends Arac {
	
	
	private static String hız="yavaş gideeim";

	public Araba(String name) {
		this(name,hız);
		// TODO Auto-generated constructor stub
	}
	
	
	public Araba(String name,String hız) {
		super(name);
		this.hız=hız;
	}
	
	
	

	
	public String getHız() {
		return hız;
	}


	public String hareket() {
		return "yavaş hareket ederim...";
	}
	
	
	
	
	
}
