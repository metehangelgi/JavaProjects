package isler;

public class Isler {
	
	private double maas;
	private String isIsmi;
	private double tatilHakkı;
	
	
	

	public Isler(double maas,String isIsmi,double tatilHakkı) {
		this.maas=maas;
		this.isIsmi=isIsmi;
		this.tatilHakkı=tatilHakkı;
		
		// TODO Auto-generated constructor stub
	}




	public double getMaas() {
		return maas;
	}




	public void setMaas(double maas) {
		this.maas = maas;
	}




	public String getIsIsmi() {
		return isIsmi;
	}




	public void setIsIsmi(String isIsmi) {
		this.isIsmi = isIsmi;
	}




	public double getTatilHakkı() {
		return tatilHakkı;
	}




	public void setTatilHakkı(double tatilHakkı) {
		this.tatilHakkı = tatilHakkı;
	}

	public String toString() {
		String res="Meslek: "+getIsIsmi()+"\n";
		res+="Maas: "+getMaas()+"\n";
		res+="TatilHakkı: "+getTatilHakkı()+"\n";
		
		return res;
	}
	
	
	
}
