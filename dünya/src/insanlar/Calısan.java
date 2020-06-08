package insanlar;

import araçlar.Arac;
import isler.Isler;

public class Calısan extends Insan{
	
	
	private Isler is;



	public Calısan(String isim, String soyisim,Isler is,Arac arac) {
		super(isim,soyisim, arac);
		this.is=is;
		
	}



	public Isler getIs() {
		return is;
	}



	public void setIs(Isler is) {
		this.is = is;
	}


	public String toString() {
		String res=super.toString()+"\n";
		res+=is.toString()+"\n"; 
		return res;
	}
	
	
	
	
	

}
