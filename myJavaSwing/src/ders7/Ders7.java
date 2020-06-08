package ders7;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Arc2D.Double;
import java.awt.geom.Line2D.Float;

@SuppressWarnings("serial")
public class Ders7 extends JFrame {
	public static void main(String[] args) {
		new Ders7();
	}

	public Ders7() {
		this.setSize(500, 500);
		this.setTitle("Şekil Çizme");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new ciz(), BorderLayout.CENTER);
		this.setVisible(true);
	}

	private class ciz extends JComponent {
		public void paint(Graphics g) {
			Graphics2D graf2 = (Graphics2D) g;
			graf2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			Shape cizgiCiz = new Line2D.Float(20, 90, 55, 250);
			Shape aciCiz2D = new Arc2D.Double(5, 150, 100, 100, 45, 180, Arc2D.OPEN);
			Shape aciCiz2D2 = new Arc2D.Double(5, 200, 100, 100, 45, 45, Arc2D.CHORD);
			Shape aciCiz2D3 = new Arc2D.Double(5, 250, 100, 100, 45, 45, Arc2D.PIE);
			graf2.setPaint(Color.BLACK);
			graf2.draw(cizgiCiz);
			graf2.draw(aciCiz2D);
			graf2.draw(aciCiz2D2);
			graf2.draw(aciCiz2D3);
			Shape elipsCiz = new Ellipse2D.Float(10, 10, 100, 100);
			Shape yuvar = new RoundRectangle2D.Double(25, 25, 50, 50, 45, 45);
			CubicCurve2D kupegrisi = new CubicCurve2D.Double();
			kupegrisi.setCurve(110, 50, 300, 200, 200, 200, 90, 263);
			Shape dikCiz = new Rectangle2D.Float(300, 300, 150, 100);
			Shape qauadCurve = new QuadCurve2D.Float(300, 100, 400, 200, 150, 300);
			Shape transDik = new Rectangle2D.Double(300, 300, 75, 50);
			graf2.draw(elipsCiz);
			graf2.setColor(Color.GREEN);
			graf2.fill(dikCiz);
			graf2.setPaint(Color.BLACK);
			graf2.draw(qauadCurve);
			graf2.draw(transDik);
			graf2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.40F));
			graf2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0F));
			GradientPaint gradient = new GradientPaint(0, 0, Color.BLUE, 60, 0, new Color(0x66ffff), true);
			graf2.setPaint(gradient);
			graf2.fill(new Rectangle2D.Float(10, 10, 150, 100));
			graf2.fill(transDik);
		}
	}
}