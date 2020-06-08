import acm.program.*;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;




public class DrawStarMapWithChooser extends GraphicsProgram {
    private static final int APPLICATION_WIDTH = 500;
    private static final int APPLICATION_HEIGHT = 500;
    
	private static final int MIN_SIZE = 1;
	private static final int MAX_SIZE = 50;
	private static final int INITIAL_SIZE = 16;

	private JSlider sizeSlider;
	private JComboBox colorChooser;
	private JCheckBox fillCheck;

	/**
	 * This program creates a five-pointed star every time the user clicks the
	 * mouse on the canvas
	 */
	public void init() {
        resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		setBackground(Color.GRAY);
		initColorChooser();
		// Your code starts here
		
		sizeSlider= new JSlider(MIN_SIZE,MAX_SIZE,INITIAL_SIZE);
		add(new JLabel ("Small"), SOUTH);
		add(sizeSlider, SOUTH);
		add(new JLabel ("Large"), SOUTH);
		fillCheck = new JCheckBox("Filled");
		add(fillCheck, SOUTH);
		add(colorChooser, SOUTH);
		add(new JButton("Clear"), SOUTH);
		
//		sizeSlider = new JSlider(MIN_SIZE, MAX_SIZE, INITIAL_SIZE);
//		add(new JButton("Clear"), SOUTH);
//		add(new JLabel("  Small"), SOUTH);
//		add(sizeSlider, SOUTH);
//		add(new JLabel("Large"), SOUTH);
//		add(colorChooser, SOUTH);
//		fillCheck = new JCheckBox("Filled");
//		add(fillCheck, SOUTH);

		// Your code ends here
		addActionListeners();
		addMouseListeners();		
	}

	private void initColorChooser() {
//		colorChooser = new JComboBox();
		colorChooser = new JComboBox(new String[] { "White", "Red", "Yellow", "Orange","Green","Black" });
		colorChooser.addItem("Blue");
//		colorChooser.addItem("Red");
//		colorChooser.addItem("Yellow");
//		colorChooser.addItem("Orange");
//		colorChooser.addItem("Green");
//		colorChooser.addItem("Blue");
//		colorChooser.addItem("Black");
		colorChooser.setEditable(false);
		colorChooser.setSelectedItem("Black");
	}

	/* Called whenever the user clicks the mouse */
	public void mouseClicked(MouseEvent e) {
        // Your code starts here
		GStar star = new GStar(getCurrentSize());
		add(star,e.getX(),e.getY());
		star.setFilled(fillCheck.isSelected());
		star.setColor(getCurrentColor());
//		GStar star = new GStar(getCurrentSize());
//		star.setFilled(fillCheck.isSelected());
//		star.setColor(getCurrentColor());
//		add(star, e.getX(), e.getY());
        // Your code ends here

	}

	private Color getCurrentColor() {
		// Return the color chosen by the user
		// Your code starts here
		
		String name = (String) colorChooser.getSelectedItem();

		if (name.equals("Red"))
			return Color.RED;
		
		if (name.equals("Yellow"))
			return Color.YELLOW;

		if(name.equals("Orange"))
			return Color.ORANGE;

		if (name.equals("Green"))
			return Color.GREEN;

		if (name.equals("Blue"))
			return Color.BLUE;

		if (name.equals("Black"))
			return Color.BLACK;
		// Your code ends here
		return Color.WHITE;
	}

	private double getCurrentSize() {
		double answer = 0;
		// Your code starts here
		answer = sizeSlider.getValue();
		// Your code ends here
		return answer;
	}

	public void actionPerformed(ActionEvent e) {
		// Handle the Clear button
		// Your code starts here
		if (e.getActionCommand().equals("Clear"))
			removeAll();
		// Your code ends here
	}
}
