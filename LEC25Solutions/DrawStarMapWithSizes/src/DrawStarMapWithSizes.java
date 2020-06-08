import acm.program.*;

import java.awt.event.*;

import javax.swing.*;

public class DrawStarMapWithSizes extends GraphicsProgram {
	private static final double SMALL_SIZE = 10;
	private static final double LARGE_SIZE = 40;
	private static final double MEDIUM_SIZE = 20;
	private JRadioButton smallButton;
	private JRadioButton mediumButton;
	private JRadioButton largeButton;

	/**
	 * This program creates a five-pointed star every time the user clicks the
	 * mouse on the canvas
	 */
	public void init() {
		// Your code starts here
		smallButton =new JRadioButton("Small");
		mediumButton =new JRadioButton("Medium");
		largeButton =new JRadioButton("Large");
		ButtonGroup sizeGroup  =new ButtonGroup();
		sizeGroup.add(smallButton);
		sizeGroup.add(mediumButton);
		sizeGroup.add(largeButton);
		mediumButton.setSelected(true);
		add(smallButton,SOUTH);
		add(mediumButton,SOUTH);
		add(largeButton,SOUTH);
		add(new JButton("Delete"),SOUTH);
		// Your code ends here
		addActionListeners();
		addMouseListeners();
	}

	/* Called whenever the user clicks the mouse */
	public void mouseClicked(MouseEvent e) {
		//Your code starts here
		add(new GStar(getCurrentSize()),e.getX(),e.getY());
		// Your code ends here
	}

	private double getCurrentSize() {
		double answer = 0;
		// Your code starts here
		if(smallButton.isSelected()) {
			answer= SMALL_SIZE;
		} else if (mediumButton.isSelected()) {
			answer= MEDIUM_SIZE;
		} else if (largeButton.isSelected()) {
			answer= LARGE_SIZE;
		}
		// Your code ends here
		return answer;
	}

	public void actionPerformed(ActionEvent e) {
		// Handle the clear button:
		// Your code starts here
		if(e.getActionCommand().equals("Delete")) {
			removeAll();
		}
		// Your code ends here
	}

}
