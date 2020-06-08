package insanlar;

import araçlar.Arac;

public class Issiz extends Insan{

	private final String issizlikMaas="1000";
	
	
	public Issiz(String isim,String soyisim,Arac arac) {
		super(isim,soyisim, arac);
		
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		String res=super.toString()+"\n";
		res+="meslek: işsiz"+ "\n";
		res+="maas: "+issizlikMaas+"\n";
		return res;
	}
	
	
	
}
