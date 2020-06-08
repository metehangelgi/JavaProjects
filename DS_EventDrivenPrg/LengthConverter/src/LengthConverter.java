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
        //Your code starts here
		
        //Your code ends here
	}

	/** Listen for a button action */
	public void actionPerformed(ActionEvent e) {
        //Your code starts here
		
        //Your code ends here
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
