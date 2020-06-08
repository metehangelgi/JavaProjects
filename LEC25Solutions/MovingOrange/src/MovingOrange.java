import acm.graphics.*;
import acm.program.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovingOrange extends GraphicsProgram {

	private static final int STEP_SIZE = 3;

	private int dx = STEP_SIZE;
	private int dy = 0;

	private GOval ball;
	private JButton up;
	private JButton down;
	private JButton right;
	private JButton left;

	public void init() {
		// Create and display the ball and the buttons:
		// Your code starts here
		ball = new GOval(100, 100);
		ball.setFillColor(Color.ORANGE);
		ball.setFilled(true);
		dx = STEP_SIZE;
		dy = 0;
		add(ball, getWidth() / 2, getHeight() / 2);

		up = new JButton("^");
		add(up, NORTH);
		down = new JButton("v");
		add(down, SOUTH);
		right = new JButton(">");
		add(right, EAST);
		left = new JButton("<");
		add(left, WEST);
		// Your code ends here
		addActionListeners();
	}

	public void run() {
		while (true) {
			// Move the ball in the dx dy direction and pause:
			// Your code starts here
			ball.move(dx, dy);
			pause(50);
			// Your code ends here
		}
	}

	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		
		// Adjust dx and dy based on the button pressed:
		// Your code starts here
		if (command.equals(">")) {
			dx = STEP_SIZE;
			dy = 0;
		} else if (command.equals("<")) {
			dx = -STEP_SIZE;
			dy = 0;
		} else if (command.equals("v")) {
			dx = 0;
			dy = STEP_SIZE;
		} else {
			dx = 0;
			dy = -STEP_SIZE;
		}
		// Your code ends here
	}

}