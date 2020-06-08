import acm.gui.*;
import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class TemperatureConverter extends Program {

	/* Private instance variables */

	private IntField fahrenheitField;
	private IntField celsiusField;

	/** Initialize the graphical user interface */
	public void init() {
		setLayout(new TableLayout(2,3));
		// Your code starts here
		fahrenheitField = new IntField(32);
		celsiusField = new IntField(0);
		JLabel label=new JLabel("Fah Degrees");
		add(label);
		add(fahrenheitField);
		add(new JButton("F -> C"));
		add(new JLabel ("Cel Degrees"));
		add(celsiusField);
		add(new JButton("C -> F"));
//		add(new JLabel("Degrees Fahrenheit"));
//		add(fahrenheitField);
//		add(new JButton("F -> C"));
//		add(new JLabel("Degrees Celsius"));
//		add(celsiusField);
//		add(new JButton("C -> F"));
		addActionListeners();
		// Your code ends here
	}

	/** Listen for a button action */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		// Your code starts here,
		
		if(cmd.equals("F -> C")) {
			int f=fahrenheitField.getValue();
			int c=toCelcius(f);
			celsiusField.setValue(c);
		} else if(cmd.equals("C -> F")) {
			int c = celsiusField.getValue();
			int f = toFahrenheit(c);
			fahrenheitField.setValue(f);
		}
		// Your code ends here
	}

	private int toFahrenheit(int celcius) {
		int answer = 0;
		// Your code starts here
		answer = (int) Math.round((9.0 / 5.0) * celcius + 32);
		// Your code ends here
		return answer;
	}

	private int toCelcius(int fahrenheit) {
		int answer = 0;
		// Your code starts here
		answer = (int) Math.round((5.0 / 9.0) * (fahrenheit - 32));
		// Your code ends here
		return answer;
	}
}
