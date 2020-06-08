package ders5;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;

public class Ders5 extends JFrame {
	JButton buton1;
	JSpinner spinner1, spinner2, spinner3, spinner4;
	String StringCikti = "";

	public static void main(String[] args) {
		new Ders5();
	}

	public Ders5() {
		this.setSize(320, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Beşinci Frame");
		JPanel panelim = new JPanel();
		buton1 = new JButton("Cevap");
		ListenForButton butonL = new ListenForButton();
		buton1.addActionListener(butonL);
		panelim.add(buton1);
		spinner1 = new JSpinner();
		panelim.add(spinner1);
		spinner2 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
		panelim.add(spinner2);
		String[] gunler = { "Pzt", "Sl", "Çrş", "Prş", "Cm" };
		spinner3 = new JSpinner(new SpinnerListModel(gunler));
		Dimension d = spinner3.getPreferredSize();
		d.width = 80;
		spinner3.setPreferredSize(d);
		panelim.add(spinner3);
		Date bugun = new Date();
		spinner4 = new JSpinner(new SpinnerDateModel(bugun, null, null, Calendar.DAY_OF_MONTH));
		JSpinner.DateEditor tarihEdit = new JSpinner.DateEditor(spinner4, "dd/MM/yy");
		spinner4.setEditor(tarihEdit);
		panelim.add(spinner4);
//ListenForSpinenr spinnerL = new ListenForSpinner();
//spinner4.addChangeListener(spinnerL);
		this.add(panelim);
		this.setVisible(true);
	}

	private class ListenForButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buton1) {
				StringCikti += "Spinner 1: " + spinner1.getValue() + " ";
				StringCikti += "Spinner 2: " + spinner2.getValue() + " ";
				StringCikti += "Spinner 3: " + spinner3.getValue() + " ";
				StringCikti += "Spinner 4: " + spinner4.getValue() + " ";
				JOptionPane.showMessageDialog(Ders5.this, StringCikti, "Bilgi", JOptionPane.INFORMATION_MESSAGE);
				StringCikti = "";
			}
		}
	}
}
