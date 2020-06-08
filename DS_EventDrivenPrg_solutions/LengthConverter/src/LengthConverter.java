/*
 * File: TemperatureConverter.java
 * -------------------------------
 * This program allows users to convert temperatures
 * back and forth from Fahrenheit to Celsius.
 */

import acm.gui.*;
import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class LengthConverter extends Program {

	private static final Unit[] UNITS = { new Unit("km"), new Unit("m"),
			new Unit("cm") };
	private JComboBox firstUnit;
	private JComboBox secondUnit;

	/** Initialize the graphical user interface */
	public void init() {
		setLayout(new TableLayout(2, 4));
		firstField = new DoubleField();
		firstUnit = new JComboBox(UNITS);
		secondField = new DoubleField();
		secondUnit = new JComboBox(UNITS);
		add(firstField);
		add(firstUnit);
		add(secondField);
		add(secondUnit);
		add(new JButton("->"), "gridwidth=2");
		add(new JButton("<-"), "gridwidth=2");
		addActionListeners();
	}

	/** Listen for a button action */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("->")) {
			secondField.setValue(firstField.getValue()
					* ((Unit) firstUnit.getSelectedItem()).getMeterRatio()
					/ ((Unit) secondUnit.getSelectedItem()).getMeterRatio());
		} else if (cmd.equals("<-")) {
			firstField.setValue(secondField.getValue()
					* ((Unit) secondUnit.getSelectedItem()).getMeterRatio()
					/ ((Unit) firstUnit.getSelectedItem()).getMeterRatio());
		}
	}

	/* Private instance variables */

	private DoubleField firstField;
	private DoubleField secondField;

	/** Set the program dimensions */
	public static final int APPLICATION_WIDTH = 300;
	public static final int APPLICATION_HEIGHT = 200;

	/* Standard Java entry point */
	/* This method can be eliminated in most Java environments */
	public static void main(String[] args) {
		new LengthConverter().start(args);
	}
}
