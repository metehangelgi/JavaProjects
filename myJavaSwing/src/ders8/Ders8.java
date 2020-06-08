//package ders8;
//
//import javax.swing.*;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//import java.awt.event.*;
//import java.awt.*;
//import java.awt.geom.*;
//import java.util.*;
//import java.text.DecimalFormat;
//
//@SuppressWarnings("serial")
//public class Ders8 extends JFrame {
//	JButton fircaBut, cizgiBut, elipsBut, dikBut, kenarlikBut, dolguBut;
//	JSlider transSlider;
//	JLabel transLabel;
//	DecimalFormat dec = new DecimalFormat("#.##");
//	Graphics2D grafikAyarlari;
//	int hareket = 1;
//	float transparantVal = 1.0F;
//	Color kenarlikRengi = Color.BLACK, dolguRengi = Color.black;
//
//	public static void main(String[] args) {
//		new Ders8();
//	}
//
//	public Ders8() {
//		this.setSize(1000, 700);
//		this.setTitle("Java Paint Uygulaması");
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JPanel butonPanel = new JPanel();
//		Box kutu = Box.createHorizontalBox();
//		fircaBut = beniButonYap("./src/firca.png", 1);
//		cizgiBut = beniButonYap("./src/cizgi.png", 2);
//		elipsBut = beniButonYap("./src/elips.png", 3);
//		dikBut = beniButonYap("./src/dik.png", 4);
//		kenarlikBut = beniRenkliButonYap("./src/darbe.png", 5, true);
//		dolguBut = beniRenkliButonYap("./src/dolgu.png", 6, false);
//		kutu.add(fircaBut);
//		kutu.add(cizgiBut);
//		kutu.add(elipsBut);
//		kutu.add(dikBut);
//		kutu.add(kenarlikBut);
//		kutu.add(dolguBut);
//		transLabel = new JLabel("Transparan: 1");
//		transSlider = new JSlider(1, 99, 99);
//		ListenForSlider sliderL = new ListenForSlider();
//		transSlider.addChangeListener(sliderL);
//		kutu.add(transLabel);
//		kutu.add(transSlider);
//		butonPanel.add(kutu);
//		this.add(butonPanel, BorderLayout.SOUTH);
//		this.add(new CizimTahtasi(), BorderLayout.CENTER);
//		this.setVisible(true);
//	}// Constructer sonu
//
//	public JButton beniButonYap(String iconDosyasi, final int hareketSayisi) {
//		JButton but = new JButton();
//		Icon butIcon = new ImageIcon(iconDosyasi);
//		but.setIcon(butIcon);
//		but.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				hareket = hareketSayisi;
//			}
//		});
//		return but;
//	}
//
//	// benibutonyap sonu
//	public JButton beniRenkliButonYap(String iconDosyasi, final int hareketSayisi, final boolean kenarlik) {
//		JButton but = new JButton();
//		Icon butIcon = new ImageIcon(iconDosyasi);
//		but.setIcon(butIcon);
//		but.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (kenarlik) {
//					kenarlikRengi = JColorChooser.showDialog(null, "Kenarlık Rengi Seç", Color.BLACK);
//				} else {
//					dolguRengi = JColorChooser.showDialog(null, "Dolgu Rengi Seç", Color.BLACK);
//				}
//			}
//		});
//		return but;
//	}
//
///// renkli buton sonu private class CizimTahtasi extends JComponent{
//	ArrayList<Shape> sekiller = new ArrayList<Shape>();
//	ArrayList<Color> dolguSekli = new ArrayList<Color>();
//	ArrayList<Color> kenarlikSekli = new ArrayList<Color>();
//	ArrayList<Float> transYuzdesi = new ArrayList<Float>();
//	Point cizimBaslangic, cizimSon;
//
//	public void CizimTahtasi() {
//this.addMouseListener(new MouseAdapter(){
//public void mousePressed(MouseEvent e) {
//if(hareket != 1) { cizimBaslangic = new Point(e.getX(), e.getY());
//cizimSon = cizimBaslangic; repaint(); } }
//public void mouseReleased(MouseEvent e) {
//if(hareket != 1) {
//Shape sekil = null;
//if(hareket == 2) {
//sekil = cizgiCiz(cizimBaslangic.x, cizimBaslangic.y, e.getX(), e.getY());
//}else if(hareket == 3) {
//sekil = elipsCiz(cizimBaslangic.x, cizimBaslangic.y, e.getX(), e.getY());
//}else if(hareket == 4) {
//sekil = dikdortgenCiz(cizimBaslangic.x, cizimBaslangic.y, e.getX(), e.getY());
//}sekiller.add(sekil);
//dolguSekli.add(dolguRengi);
//kenarlikSekli.add(kenarlikRengi);
//transYuzdesi.add(transparantVal);
//cizimBaslangic = null; cizimSon = null; repaint(); } } });
////addmouselistener sonu this.addMouseMotionListener(new MouseMotionAdapter(){
//	public void mouseDragged(MouseEvent e) {
//		if (hareket == 1) {
//			int x = e.getX();
//			int y = e.getY();
//			Shape sekil = null;
//			kenarlikRengi = dolguRengi;
//			sekil = fircaCiz(x, y, 5, 5);
//			sekiller.add(sekil);
//			dolguSekli.add(dolguRengi);
//			kenarlikSekli.add(kenarlikRengi);
//			transYuzdesi.add(transparantVal);
//		}
//		cizimSon = new Point(e.getX(), e.getY());
//		repaint();
//	}
//
//});
////mousetion sonu
//	}
//
//	public void paint(Graphics g) {
//		grafikAyarlari = (Graphics2D) g;
//		grafikAyarlari.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		grafikAyarlari.setStroke(new BasicStroke(4));
//		Iterator<Color> kenarlikSay = kenarlikSekli.iterator();
//		Iterator<Color> dolguSay = dolguSekli.iterator();
//		Iterator<Float> transSay = transYuzdesi.iterator();
//		for (Shape s : sekiller) {
//			grafikAyarlari.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transSay.next()));
//			grafikAyarlari.setPaint(kenarlikSay.next());
//			grafikAyarlari.draw(s);
//			grafikAyarlari.setPaint(dolguSay.next());
//			grafikAyarlari.fill(s);
//		}
//		if (cizimBaslangic != null && cizimSon != null) {
//			grafikAyarlari.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.40f));
//			grafikAyarlari.setPaint(Color.LIGHT_GRAY);
//			Shape sekil = null;
//			if (hareket == 2) {
//				sekil = cizgiCiz(cizimBaslangic.x, cizimBaslangic.y, cizimSon.x, cizimSon.y);
//			} else if (hareket == 3) {
//				sekil = elipsCiz(cizimBaslangic.x, cizimBaslangic.y, cizimSon.x, cizimSon.y);
//			} else if (hareket == 4) {
//				sekil = dikdortgenCiz(cizimBaslangic.x, cizimBaslangic.y, cizimSon.x, cizimSon.y);
//			}
//			grafikAyarlari.draw(sekil);
//		}
//	}
//
//	private Rectangle2D.Float dikdortgenCiz(int x1, int y1, int x2, int y2) {
//		int x = Math.min(x1, x2);
//		int y = Math.min(y1, y2);
//		int genislik = Math.abs(x1 - x2);
//		int yukseklik = Math.abs(y1 - y2);
//		return new Rectangle2D.Float(x, y, genislik, yukseklik);
//	}
//
//	private Ellipse2D.Float elipsCiz(int x1, int y1, int x2, int y2) {
//		int x = Math.min(x1, x2);
//		int y = Math.min(y1, y2);
//		int genislik = Math.abs(x1 - x2);
//		int yukseklik = Math.abs(y1 - y2);
//		return new Ellipse2D.Float(x, y, genislik, yukseklik);
//	}
//
//	private Line2D.Float cizgiCiz(int x1, int y1, int x2, int y2) {
//		return new Line2D.Float(x1, y1, x2, y2);
//	}
//
//	private Ellipse2D.Float fircaCiz(int x1, int y1, int fircaKenarlikGenisligi, int fircaKenarlikYuksekligi) {
//		return new Ellipse2D.Float(x1, y1, fircaKenarlikGenisligi, fircaKenarlikYuksekligi);
//	}
//}
//
//// çizim tahtasi sono
//public class ListenForSlider implements ChangeListener {
//	public void stateChanged(ChangeEvent e) {
//		if (e.getSource() == transSlider) {
//			transLabel.setText("Transparan " + dec.format(transSlider.getValue() * .01));
//		}
//		transparantVal = (float) (transSlider.getValue() * .01);
//	}
//}}