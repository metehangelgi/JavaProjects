/*
 * File: CurrencyConverter.java
 * ----------------------------
 * This program allows users to convert currencies.
 */

import acm.gui.*;
import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

/** This class implements a currency converter. */
public class CurrencyConverter extends Program {

	public void init() {
		currencyTable = new CurrencyConversionTable(CURRENCY_FILE);
		createGUI();
		addActionListeners();
	}

	private void createGUI() {
		// Your code starts here
		setLayout(new TableLayout(4, 2));
		leftChooser = createCurrencyChooser();
		
		rightChooser = createCurrencyChooser();
		
		leftField = new DoubleField();
		leftField.setFormat("0.00");
		leftField.setActionCommand("Convert ->");
		leftField.addActionListener(this);
		rightField = new DoubleField();
		rightField.setFormat("0.00");
		rightField.setActionCommand("<- Convert");
		rightField.addActionListener(this);
		add(leftChooser);
		add(rightChooser);
		add(leftField);
		add(rightField);
		add(new JButton("Convert ->"));
		add(new JButton("<- Convert"));
		// Your code ends here
	}

	public void actionPerformed(ActionEvent e) {
		// Your code starts here
		String cmd = e.getActionCommand();
		if (cmd.equals("Convert ->")) {
			double fromValue = leftField.getValue();
			String fromCurrency = (String) leftChooser.getSelectedItem();
			double fromRate = currencyTable.getRate(fromCurrency);
			String toCurrency = (String) rightChooser.getSelectedItem();
			double toRate = currencyTable.getRate(toCurrency);
			double toValue = fromValue * fromRate / toRate;
			rightField.setValue(toValue);
		} else if (cmd.equals("<- Convert")) {
			double fromValue = rightField.getValue();
			String fromCurrency = (String) rightChooser.getSelectedItem();
			double fromRate = currencyTable.getRate(fromCurrency);
			String toCurrency = (String) leftChooser.getSelectedItem();
			double toRate = currencyTable.getRate(toCurrency);
			double toValue = fromValue * fromRate / toRate;
			leftField.setValue(toValue);
		}
		// Your code ends here
	}

	private JComboBox createCurrencyChooser() {
		JComboBox chooser = new JComboBox();
		// Your code starts here
		for (String keys : currencyTable.getCurrencyNames()) {
			chooser.addItem(keys);
		}
		chooser.setEditable(false);
		// Your code ends here
		return chooser;
	}

	/* Data file name */
	private static final String CURRENCY_FILE = "CurrencyRates.txt";

	/* Private instance variables */
	private CurrencyConversionTable currencyTable;

	/* Private instance variables */
	private JComboBox leftChooser;
	private JComboBox rightChooser;
	private DoubleField leftField;
	private DoubleField rightField;
}
