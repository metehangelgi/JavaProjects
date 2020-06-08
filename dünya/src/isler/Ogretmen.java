package isler;

public class Ogretmen extends Isler{
	
	private double fazlaTatil=1;
	

	public Ogretmen(double maas,String isIsmi,double tatilHakkı) {
		super(maas,isIsmi,tatilHakkı);
		setTatilHakkı();
		// TODO Auto-generated constructor stub
	}
	
	public double setTatilHakkı() {
		return super.getTatilHakkı()+fazlaTatil;
	}
	

	public double kazanılanpara() {
		return super.getMaas();
	}
	
	public String toString() {
		String res="Meslek: "+getIsIsmi()+"\n";
		res+="Maas: "+kazanılanpara()+"\n";
		res+="TatilHakkı: "+getTatilHakkı()+"\n";
		
		return res;
	}
	
}
