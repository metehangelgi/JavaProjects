import acm.gui.*;
import acm.program.*;

import java.awt.event.*;
import javax.swing.*;

public class SimpleCalculator extends Program {

	/** Set the program dimensions */
	public static final int APPLICATION_WIDTH = 425;
	public static final int APPLICATION_HEIGHT = 225;

	private JComboBox operator;
	private JLabel result;
	private DoubleField num1;
	private DoubleField num2;
	private JButton equal;

	/** Initialize the application */
	public void init() {
		resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);

		setLayout(new TableLayout(1, 5));

		// Create num1, operator, num2, equal button, result label and add them in that order 
		// Your code starts here
	

		num1 = new DoubleField();
		num2 = new DoubleField();
		result = new JLabel("empty");
		operator = new JComboBox(new String[] { "+", "-", "x", "/" });
		equal = new JButton("=");
		

		add(num1);
		add(operator);
		add(num2);
		add(equal);
		add(result);
		// Your code ends here
		addActionListeners();
	}

	/** Respond to action events by changing the button label */
	/* Hint: operator.getSelectedItem() should give you the operator to use */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		// Your code starts here
		if (cmd.equals("=")) {
			if (operator.getSelectedItem().equals("+")) {
				result.setText(Double.valueOf(num1.getValue() + num2.getValue()).toString());

			} else if (operator.getSelectedItem().equals("-")) {
				result.setText(Double.valueOf(num1.getValue() - num2.getValue()).toString());

			} else if (operator.getSelectedItem().equals("x")) {
				result.setText(Double.valueOf(num1.getValue() * num2.getValue()).toString());

			} else {
					result.setText(Double.valueOf(num1.getValue() / num2.getValue()).toString());
			}
		}
		// Your code ends here
	}

}
