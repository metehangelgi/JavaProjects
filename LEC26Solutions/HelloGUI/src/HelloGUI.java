/*
 * File: HelloGUI.java
 * -------------------
 * This program displays a greeting each time a name is
 * entered in a JTextField.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

/** This class displays a greeting whenever a name is entered */
public class HelloGUI extends ConsoleProgram {

	public void init() {
		// Your code starts here
		nameField = new JTextField(10);
		add(new JLabel("Name"), SOUTH);
		add(nameField, SOUTH);
		nameField.addActionListener(this);
		addActionListeners();
		// Your code ends here
	}

	public void actionPerformed(ActionEvent e) {
		// Your code starts here
		if(e.getSource().equals(nameField)) {
			println("Hello, " + nameField.getText());
		}
		
		if (e.getSource() == nameField) {
			println("Hello, " + nameField.getText());
		}
		// Your code ends here
	}
	
	/* Private instance variables */
	private JTextField nameField;
}

