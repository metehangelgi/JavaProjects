package araçlar;

public abstract class Arac {
	
	private String name;

	public Arac(String name) {
		this.name=name;
		// TODO Auto-generated constructor stub
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public abstract String hareket();
	

}
