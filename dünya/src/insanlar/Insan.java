package insanlar;

import araçlar.Arac;

public class Insan {

	private String isim;
	private String soyisim;
	private Arac arac;
	
	public Insan(String isim, String soyisim,Arac arac) {
		this.isim=isim;
		this.soyisim=soyisim;
		this.arac=arac;
		
		// TODO Auto-generated constructor stub
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public Arac getArac() {
		return arac;
	}
	
	public String getAracIsmi() {
		return arac.getName();
	}

	public void setArac(Arac arac) {
		this.arac = arac;
	}
	
	
	public String toString() {
		String res="--------------\n";
		res+="isim: "+getIsim()+"\n";
		res+="soyisim: "+getSoyisim()+"\n";
		res+="Arac: "+arac.getName()+"\n";
		res+=arac.hareket()+"\n";
		return res;
	}
	
	

}
