import acm.graphics.*;
import acm.program.*;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class SimplePaint extends GraphicsProgram {

    // This program lets the user select a shape and its properties, then draws that shape wherever the user clicks the mouse.

    // Min, max, and default sizes for shapes
    private static final int MIN_SIZE = 1;
    private static final int MAX_SIZE = 50;
    private static final int INITIAL_SIZE = 16;

    // User interface components
    private JButton clearButton;	// Clears the screen
    private JSlider widthSlider;	// Choose width between MIN_SIZE and MAX_SIZE
    private JSlider heightSlider;	// Choose height between MIN_SIZE and MAX_SIZE
    private JComboBox shapeChooser;	// Choose between GRect and GOval
    private JComboBox colorChooser;	// Choose between RED, GREEN, BLUE
    private JCheckBox fillCheckBox;	// Choose whether the shape should be filled

    /**
     * This program creates a five-pointed star every time the user clicks the
     * mouse on the canvas
     */
    public void init() {
	setSize(600, 300);
	setBackground(Color.GRAY);

	// 1. Add a clear JButton.
	// 2. Add width and height JSliders.
	// 3. Add shape and color JComboBoxes.
	// 4. Add the Filled JCheckBox.

	// Your code starts here
	clearButton=new JButton("Clear");
	add(clearButton,SOUTH);
	widthSlider= new JSlider(MIN_SIZE,MAX_SIZE,INITIAL_SIZE);
	add(widthSlider,SOUTH);
	heightSlider= new JSlider(MIN_SIZE,MAX_SIZE,INITIAL_SIZE);
	add(heightSlider,SOUTH);
	
	shapeChooser=new JComboBox();
	shapeChooser.addItem("GRect");
	shapeChooser.addItem("GOval");
	add(shapeChooser,SOUTH);
	
	colorChooser=new JComboBox();
	colorChooser.addItem("Red");
	colorChooser.addItem("Blue");
	colorChooser.addItem("Green");
	add(colorChooser,SOUTH);
	
	
	fillCheckBox=new JCheckBox("Filled");
	add(fillCheckBox,SOUTH);
	// Your code ends here

	addActionListeners();
	addMouseListeners();
    }

    /* Called whenever the user clicks the mouse.  e.getX(), e.getY() give click position. */
    /* Draw a shape where the user clicked the button based on user selections. */
    /* JComboBox.getSelectedItem(), JSlider.getValue(), JCheckBox.isChecked() may be useful. */
    public void mouseClicked(MouseEvent e) {
	// Your code starts here
	
	// Your code ends here
    }

    // Add the Clear button action here.
    // Hint: e.getSource() gives the interactor object triggering the event.
    // e.getActionCommand() gives the ActionCommand string for the button.
    public void actionPerformed(ActionEvent e) {
	// Your code starts here
	if (e.getSource() == clearButton) {
	    removeAll();
	}
	// Your code ends here
    }
}
