package ders3;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.text.NumberFormat;
import javax.swing.border.*;

public class Ders3 extends JFrame {
	JButton buton1;
	JLabel label1, label2, label3;
	JTextField textField1, textField2;
	JCheckBox dolarisareti, virgul;
	JRadioButton topla, cikar, carp, bol;
	JSlider kackere;
	double sayi1, sayi2, sonuc;

	public static void main(String[] args) {
		new Ders3();
	}

	public Ders3() {
		this.setSize(330, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Hesap Makinesi");
		JPanel panelim = new JPanel();
		
		label1 = new JLabel("Sayi 1");
		panelim.add(label1);
		textField1 = new JTextField("", 5);
		panelim.add(textField1);
		label2 = new JLabel("Sayi 1");
		panelim.add(label2);
		textField2 = new JTextField("", 5);
		panelim.add(textField2);
		dolarisareti = new JCheckBox("Para Birimi");
		virgul = new JCheckBox("Virgül");
		panelim.add(dolarisareti);
		panelim.add(virgul);
		topla = new JRadioButton("Topla");
		cikar = new JRadioButton("cikar");
		carp = new JRadioButton("carp");
		bol = new JRadioButton("bol");
		ButtonGroup isaret = new ButtonGroup();
		isaret.add(topla);
		isaret.add(cikar);
		isaret.add(carp);
		isaret.add(bol);
		JPanel isaretPanel = new JPanel();
		Border isaretBorder = BorderFactory.createTitledBorder("İşlem");
		isaretPanel.setBorder(isaretBorder);
		isaretPanel.add(topla);
		isaretPanel.add(cikar);
		isaretPanel.add(carp);
		isaretPanel.add(bol);
		topla.setSelected(true);
		panelim.add(isaretPanel);
		label3 = new JLabel("Kaç defa");
		panelim.add(label3);
		kackere = new JSlider(0, 99, 1);
		kackere.setMinorTickSpacing(1);
		kackere.setMajorTickSpacing(10);
		kackere.setPaintTicks(true);
		kackere.setPaintLabels(true);
		ListenForSlider sliderL = new ListenForSlider();
		kackere.addChangeListener(sliderL);
		panelim.add(kackere);
		buton1 = new JButton("işlemi yap");
		ListenForButton ButonL = new ListenForButton();
		buton1.addActionListener(ButonL);
		panelim.add(buton1);
		this.add(panelim);
		this.setVisible(true);
		textField1.requestFocus();
	}

	private class ListenForButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buton1) {
				try {
					sayi1 = Double.parseDouble(textField1.getText());
					sayi2 = Double.parseDouble(textField2.getText());
				} catch (NumberFormatException excep) {
					JOptionPane.showMessageDialog(Ders3.this, "Yanlış bir veri girdiniz!", "Hata",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				if (topla.isSelected()) {
					sonuc = sayiTopla(sayi1, sayi2, kackere.getValue());
				} else if (cikar.isSelected()) {
					sonuc = sayiCikar(sayi1, sayi2, kackere.getValue());
				} else if (carp.isSelected()) {
					sonuc = sayiCarp(sayi1, sayi2, kackere.getValue());
				} else {
					sonuc = sayiBol(sayi1, sayi2, kackere.getValue());
				}
				if (dolarisareti.isSelected()) {
					NumberFormat sayiFormat = NumberFormat.getCurrencyInstance();
					JOptionPane.showMessageDialog(Ders3.this, sayiFormat.format(sonuc), "Sonuç",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (virgul.isSelected()) {
					NumberFormat sayiFormat = NumberFormat.getNumberInstance();
					JOptionPane.showMessageDialog(Ders3.this, sayiFormat.format(sonuc), "Sonuç",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(Ders3.this, sonuc, "Sonuç", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	private class ListenForSlider implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			if (e.getSource() == kackere) {
				label3.setText("Kac defa " + kackere.getValue());
			}
		}
	}

	public static double sayiTopla(double sayi1, double sayi2, int kackere) {
		double toplam = 0;
		int i = 1;
		while (i <= kackere) {
			toplam = toplam + (sayi1 + sayi2);
			i++;
		}
		return toplam;
	}

	public static double sayiCikar(double sayi1, double sayi2, int kackere) {
		double toplam = 0;
		int i = 1;
		while (i <= kackere) {
			toplam = toplam + (sayi1 - sayi2);
			i++;
		}
		return toplam;
	}

	public static double sayiCarp(double sayi1, double sayi2, int kackere) {
		double toplam = 0;
		int i = 1;
		while (i <= kackere) {
			toplam = toplam + (sayi1 * sayi2);
			i++;
		}
		return toplam;
	}

	public static double sayiBol(double sayi1, double sayi2, int kackere) {
		double toplam = 0;
		int i = 1;
		while (i <= kackere) {
			toplam = toplam + (sayi1 / sayi2);
			i++;
		}
		return toplam;
	}
}