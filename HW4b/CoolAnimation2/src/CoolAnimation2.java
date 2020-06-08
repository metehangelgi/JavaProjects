/*
 * File: CoolAnimation2.java
 * ---------------------
 * This program creates an animation for the given string.
 */

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

/**
 * This class creates an animation for the given string.
 */

public class CoolAnimation2 extends GraphicsProgram {

	/** Runs the program */
	public void run() {

		/* Do not change this part of the code */
		setSize(WIDTH,HEIGHT);
		GLabel label = new GLabel(getDefaultString(targetText.length()));
		label.setFont("SansSerif-48");
		add(label);
		centerLabel(label);

		// Your code starts here
		
		// Your code ends here
	}

	/** 
	 * This method returns a string will all 'A's with the given length.
	 * You do NOT need to modify this method. Just use it.
	 **/
	private String getDefaultString(int length) {
		String str = "";
		for (int i = 0; i < length; i++) {
			str += "A"; 
		}
		return str;
	}

	/** 
	 * This method centers label in the window.
	 * You do NOT need to modify this method. Just use it.
	 **/
	private void centerLabel(GLabel label) {
		double x = (getWidth() - label.getWidth())/2;
		double y = (getHeight() + label.getAscent())/2;
		label.setLocation(x, y);
	}

	/* Do not change this part of the code */
	private static final String targetText = "HELLO";
	private static final int PAUSE_TIME = 200;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 150;
}

