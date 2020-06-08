JOyunalani.java

import java.awt.BorderLayout;
import java.awt.color.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.awt.geom.AffineTransform;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class JOyunalani extends JFrame{
public static int oyunAlaniGenislik = 1000;
public static int oyunAlaniYukseklik = 800;
public static boolean tus = false;
public static int tusKodu;
public static void main(String[] args){ new JOyunalani(); }
public JOyunalani(){
this.setSize(oyunAlaniGenislik, oyunAlaniYukseklik);
this.setTitle("ProPhpHocam Java Uzay Oyunu");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 // keylistener tus takip
addKeyListener(new KeyListener(){ @Override public void keyPressed(KeyEvent e) {
if(e.getKeyCode() == 87){
System.out.println("İleri");
tusKodu = e.getKeyCode();
tus = true;
}else if(e.getKeyCode() == 83){
System.out.println("Geri");
tusKodu = e.getKeyCode();
tus = true;
}else if(e.getKeyCode() == 68){
System.out.println("Sağa Döndü");
tusKodu = e.getKeyCode(); tus = true;
}else if(e.getKeyCode() == 65){
System.out.println("Sola Döndü");
tusKodu = e.getKeyCode();
tus = true;
} }
@Override public void keyReleased(KeyEvent e) { tus = false; }
@Override public void keyTyped(KeyEvent e) { } });
oyunCizmePanel oyunPanel = new oyunCizmePanel();
this.add(oyunPanel, BorderLayout.CENTER);
ScheduledThreadPoolExecutor calistir = new ScheduledThreadPoolExecutor(5);
calistir.scheduleAtFixedRate(new EkraniTemizle(this), 0L, 20L, TimeUnit.MILLISECONDS);
this.setVisible(true);
} }

class EkraniTemizle implements Runnable {
	JOyunalani oyunAlani;

	public EkraniTemizle(JOyunalani oyunAlani) {
		this.oyunAlani = oyunAlani;
	}

	public void run() {
		oyunAlani.repaint();
	}
}

@SuppressWarnings("serial") class oyunCizmePanel extends JComponent{ public static ArrayList GokTaslari = new ArrayList();
int[] cokgenXArray = JGoktasi.hbCokgenXArray;
int[] cokgenYArray = JGoktasi.hbCokgenYArray;
JUzaygemisi gemi = new JUzaygemisi();
int genislik = JOyunalani.oyunAlaniGenislik;
int yukseklik = JOyunalani.oyunAlaniYukseklik;
public oyunCizmePanel(){
for(int i = 0; i < 10; i++){
int rastXBasPoz = (int) (Math.random() * (JOyunalani.oyunAlaniGenislik - 40) + 1);
int rastYBasPoz = (int) (Math.random() * (JOyunalani.oyunAlaniYukseklik - 40) + 1);
GokTaslari.add(new JGoktasi(JGoktasi.getCokgenXArray(rastXBasPoz), JGoktasi.getCokgenYArray(rastYBasPoz), 13, rastXBasPoz, rastYBasPoz));
JGoktasi.GokTaslari = GokTaslari; } }
public void paint(Graphics g){ Graphics2D grafikAyarlari = (Graphics2D) g;
AffineTransform id = new AffineTransform();
grafikAyarlari.setColor(Color.BLACK);
grafikAyarlari.fillRect(0, 0, getWidth(), getHeight());
grafikAyarlari.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
grafikAyarlari.setPaint(Color.WHITE);
for(JGoktasi tas: GokTaslari){ tas.hareketEt();
grafikAyarlari.draw(tas); }
if(JOyunalani.tus == true && JOyunalani.tusKodu == 68){
gemi.yonAcisiArttir();
System.out.println("Gemi açisi: " + gemi.getYonAcisi());
}else if(JOyunalani.tus == true && JOyunalani.tusKodu == 65){
gemi.yonAcisiAzalt();
System.out.println("Gemi açisi: " + gemi.getYonAcisi());
}else if(JOyunalani.tus == true && JOyunalani.tusKodu == 87){
gemi.setHareketAcisi(gemi.getYonAcisi());
gemi.xHizArttir(gemi.gemiXHareketAcisi(gemi.getHareketAcisi()) * 0.1); gemi.yHizArttir(gemi.gemiYHareketAcisi(gemi.getHareketAcisi()) * 0.1); }
gemi.hareketEt();
grafikAyarlari.setTransform(id);
grafikAyarlari.translate(gemi.getXOrtala(), gemi.getYOrtala());
 grafikAyarlari.rotate(Math.toRadians(gemi.getYonAcisi()));
grafikAyarlari.draw(gemi); } }

JUzaygemisi.java

import java.awt.Polygon;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class JUzaygemisi extends Polygon {
	private double xHiz = 0, yHiz = 0;
	int oAGenislik = JOyunalani.oyunAlaniGenislik;
	int oAYukseklik = JOyunalani.oyunAlaniYukseklik;
	private double ortalaX = oAGenislik / 2, ortalaY = oAYukseklik / 2;
	public static int[] cokgenXArray = { -13, 14, -13, -5, -13 };
	public static int[] cokgenYArray = { -15, 0, 15, 0, -15 };
	private int gemiGenislik = 27, gemiYukseklik = 30;
	private double uSolXpoz = getXOrtala() + this.cokgenXArray[0];
	private double uSolYpoz = getYOrtala() + this.cokgenYArray[0];
	private double yonAcisi = 0, hareketAcisi = 0;

	public JUzaygemisi() {
		super(cokgenXArray, cokgenYArray, 5);
	}

	public double getXOrtala() {
		return ortalaX;
	}

	public double getYOrtala() {
		return ortalaY;
	}

	public void setXOrtala(double ortX) {
		this.ortalaX = ortX;
	}

	public void setYOrtala(double ortY) {
		this.ortalaY = ortY;
	}

	public void xPozArttir(double PozArt) {
		this.ortalaX += PozArt;
	}

	public void yPozArttir(double PozArt) {
		this.ortalaY += PozArt;
	}

	public double getuSolXpoz() {
		return uSolXpoz;
	}

	public double getuSolYpoz() {
		return uSolYpoz;
	}

	public void setuSolXpoz(double usXPoz) {
		this.uSolXpoz = usXPoz;
	}

	public void setuSolYpoz(double usYPoz) {
		this.uSolYpoz = usYPoz;
	}

	public int getGemiGenislik() {
		return gemiGenislik;
	}

	public int getGemiYukseklik() {
		return gemiYukseklik;
	}

	public double getXHiz() {
		return xHiz;
	}

	public double getYHiz() {
		return yHiz;
	}

	public void setXHiz(double xHiz) {
		this.xHiz = xHiz;
	}

	public void setYHiz(double yHiz) {
		this.yHiz = yHiz;
	}

	public void xHizArttir(double xHizArt) {
		this.xHiz += xHizArt;
	}

	public void yHizArttir(double yHizArt) {
		this.yHiz += yHizArt;
	}

	public void xHizAzalt(double xHizAz) {
		this.xHiz -= xHizAz;
	}

	public void yHizAzalt(double yHizAz) {
		this.yHiz -= yHizAz;
	}

	public void setHareketAcisi(double hareketAcisi) {
		this.hareketAcisi = hareketAcisi;
	}

	public double getHareketAcisi() {
		return hareketAcisi;
	}

	public void hareketAcisiArttir(double hareketAcisi) {
		this.hareketAcisi += hareketAcisi;
	}

	public double gemiXHareketAcisi(double xHareketAcisi) {
		return (double) (Math.cos(xHareketAcisi * Math.PI / 180));
	}

	public double gemiYHareketAcisi(double yHareketAcisi) {
		return (double) (Math.sin(yHareketAcisi * Math.PI / 180));
	}

	public double getYonAcisi() {
		return yonAcisi;
	}

	public void yonAcisiArttir() {
		if (getYonAcisi() >= 355) {
			yonAcisi = 0;
		} else {
			yonAcisi += 5;
		}
	}

	public void yonAcisiAzalt() {
		if (getYonAcisi() < 0) {
			yonAcisi = 355;
		} else {
			yonAcisi -= 5;
		}
	}

	public Rectangle getSekme() {
		return new Rectangle((int) getXOrtala() - 14, (int) getYOrtala() - 14, getGemiGenislik(), getGemiYukseklik());
	}

	public double getGemiBurunX() {
		return this.getXOrtala() + Math.cos(yonAcisi) * 14;
	}

	public double getGemiBurunY() {
		return this.getYOrtala() + Math.sin(yonAcisi) * 14;
	}

	public void hareketEt() {
		this.xPozArttir(this.getXHiz());
		if (this.getXOrtala() < 0) {
			this.setXOrtala(oAGenislik);
		} else if (this.getXOrtala() > oAGenislik) {
			this.setXOrtala(0);
		}
		this.yPozArttir(this.getYHiz());
		if (this.getYOrtala() < 0) {
			this.setYOrtala(oAYukseklik);
		} else if (this.getYOrtala() > oAYukseklik) {
			this.setYOrtala(0);
		}
	}
}
