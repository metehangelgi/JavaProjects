import acm.gui.*;
import acm.program.*;

import java.awt.event.*;
import javax.swing.*;

public class SimpleForm extends Program {

	/** Set the program dimensions */
	public static final int APPLICATION_WIDTH = 325;
	public static final int APPLICATION_HEIGHT = 225;

	private JTextField name;
	private JTextField surname;
	private JComboBox year;
	private DoubleField gpa;
	private JButton submit;
	private JTextField result;

	/** Initialize the application */
	public void init() {
		resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);

		setLayout(new TableLayout(6, 2));
		// Your code starts here
		add(new JLabel("Name"));
		name = new JTextField(6);
		add(name);
		surname = new JTextField(6);
		add(new JLabel("Surname"));
		add(surname);
		gpa = new DoubleField();
		add(new JLabel("GPA"));
		add(gpa);
		add(new JLabel("Year"));
		year = new JComboBox(new String[] { "Freshman", "Somophore", "Junior",
		"Senior" });
		add(year);

		submit = new JButton("Submit");
		add(submit, "gridwidth=2");

		result = new JTextField(25);
		result.setEditable(false);
		result.setEnabled(false);
		add(result, SOUTH);
		// Your code ends here
		addActionListeners();
	}

	/** Respond to action events by changing the button label */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		// Your code starts here
		if (cmd == "Submit" && name.getText().length() > 0
				&& surname.getText().length() > 0)
			result.setText(name.getText() + " " + surname.getText() + " has "
					+ gpa.getValue() + " GPA in " + year.getSelectedItem()
					+ " year.");
		// Your code ends here
	}

}
