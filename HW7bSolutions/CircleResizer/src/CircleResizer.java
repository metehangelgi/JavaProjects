import acm.graphics.*;
import acm.program.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CircleResizer extends GraphicsProgram {

	/** Set the program dimensions */
	public static final int APPLICATION_WIDTH = 425;
	public static final int APPLICATION_HEIGHT = 325;

	private GOval circle;
	private JButton grow;
	private JButton shrink;
	private JRadioButton add;

	/** Initialize the application */
	public void init() {
		resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		// Your code starts here
		grow = new JButton("Grow");
		shrink = new JButton("Shrink");
		circle = new GOval(100, 100);
		circle.setColor(Color.GREEN);
		circle.setFilled(true);

		add(grow, SOUTH);
		add(shrink, SOUTH);
		add(circle, 50, 50);
		
		add(new JButton("Clear"),SOUTH);
		add=new JRadioButton("Add");
		add.setSelected(true);
		
		add(add,SOUTH);
		
		
		addActionListeners();
		// Your code ends here
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		// Your code starts here
		if (cmd.equals("Grow")) {
			circle.setSize(circle.getWidth() * 1.1, circle.getHeight() * 1.1);
		} else if (cmd.equals("Shrink")) {
			circle.setSize(circle.getWidth() * .9, circle.getHeight() * .9);
		} else if(cmd.equals("Clear")) {
			removeAll();
		} 
		
		
		if(add.isSelected()) {
			add(circle, 110, 50);
		} else {
			remove(circle);
		}
		// Your code ends here
	}

}
