package ders6;

import javax.swing.*;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

public class Ders6 extends JFrame {
	JButton buton1, buton2, buton3, buton4, buton5, buton6, buton7, buton8, buton9, buton0, butArti, butEksi, temizle;
	JTextField textSonuc;

	public static void main(String[] args) {
		new Ders6();
	}

	public Ders6() {
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Hesap Makinesi");
		JPanel panelim = new JPanel();
		// panelim.setLayout(new GridLayout(0,3,2,2));
		panelim.setLayout(new GridBagLayout());
		GridBagConstraints girdConstraints = new GridBagConstraints();
		girdConstraints.gridx = 1;
		girdConstraints.gridy = 1;
		girdConstraints.gridwidth = 1;
		girdConstraints.gridheight = 1;
		girdConstraints.weightx = 50;
		girdConstraints.weighty = 100;
		girdConstraints.insets = new Insets(5, 5, 5, 5);
		girdConstraints.anchor = GridBagConstraints.CENTER;
		girdConstraints.fill = GridBagConstraints.BOTH;
		textSonuc = new JTextField("0", 20);
		Font font = new Font("Helvetica", Font.PLAIN, 18);
		textSonuc.setFont(font);
		buton1 = new JButton("1");
		buton2 = new JButton("2");
		buton3 = new JButton("3");
		buton4 = new JButton("4");
		buton5 = new JButton("5");
		buton6 = new JButton("6");
		buton7 = new JButton("7");
		buton8 = new JButton("8");
		buton9 = new JButton("9");
		butArti = new JButton("+");
		buton0 = new JButton("0");
		butEksi = new JButton("-");
		temizle = new JButton("C");
		panelim.add(temizle, girdConstraints);
		girdConstraints.gridwidth = 20;
		girdConstraints.gridx = 5;
		panelim.add(textSonuc, girdConstraints);
		girdConstraints.gridwidth = 1;
		girdConstraints.gridx = 1;
		girdConstraints.gridy = 2;
		panelim.add(buton1, girdConstraints);
		girdConstraints.gridx = 5;
		panelim.add(buton2, girdConstraints);
		girdConstraints.gridx = 9;
		panelim.add(buton3, girdConstraints);
		girdConstraints.gridx = 1;
		girdConstraints.gridy = 3;
		panelim.add(buton4, girdConstraints);
		girdConstraints.gridx = 5;
		panelim.add(buton5, girdConstraints);
		girdConstraints.gridx = 9;
		panelim.add(buton6, girdConstraints);
		girdConstraints.gridx = 1;
		girdConstraints.gridy = 4;
		panelim.add(buton7, girdConstraints);
		girdConstraints.gridx = 5;
		panelim.add(buton8, girdConstraints);
		girdConstraints.gridx = 9;
		panelim.add(buton9, girdConstraints);
		girdConstraints.gridx = 1;
		girdConstraints.gridy = 5;
		panelim.add(butArti, girdConstraints);
		girdConstraints.gridx = 5;
		panelim.add(buton0, girdConstraints);
		girdConstraints.gridx = 9;
		panelim.add(butEksi, girdConstraints);
		this.add(panelim);
		this.setVisible(true);
	}
}