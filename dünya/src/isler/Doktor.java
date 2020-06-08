package isler;

public class Doktor extends Isler {
	
	private double mesaiUcreti;
	
	

	public Doktor(double maas,String isIsmi,double tatilHakkı,double mesaiUcreti) {
		super(maas, isIsmi, tatilHakkı);
		this.mesaiUcreti=mesaiUcreti;
		
		
		
	}
	
	


	public double getMesaiUcreti() {
		return mesaiUcreti;
	}



	public void setMesaiUcreti(double mesaiUcreti) {
		this.mesaiUcreti = mesaiUcreti;
	}
	
	public double kazanılanpara() {
		return super.getMaas()+mesaiUcreti;
	}
	
	public String toString() {
		String res="Meslek: "+getIsIsmi()+"\n";
		res+="Maas: "+kazanılanpara()+"\n";
		res+="TatilHakkı: "+getTatilHakkı()+"\n";
		return res;
	}

}
