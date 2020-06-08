package dünya;

import araçlar.Araba;
import araçlar.Arac;
import araçlar.Ucak;
import insanlar.Calısan;
import insanlar.Insan;
import insanlar.Issiz;
import isler.Doktor;
import isler.Isler;
import isler.Ogretmen;

public class DünyaTest {

	public DünyaTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		

		
		Arac araba=new Araba("araba");
		Arac ucak=new Ucak("ucak");
		Isler doktor=new Doktor(2000, "Doktor", 2, 2000);
		Isler öğretmen=new Ogretmen(1500, "öğretmen", 3);
		
		Insan mete=new Issiz("Mete", "Gelgi", araba);
		Insan ahmet=new Calısan("Ahmet", "Taş",doktor , araba);
		Insan kerem=new Calısan("Kerem", "anar",öğretmen , ucak);
		
		System.out.println(mete);
		System.out.println(ahmet);
		System.out.println(kerem);
		
	}

}
