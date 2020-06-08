/*
 * File: LocationChangingSquare.java
 * ------------------------------
 * This program puts up a square in the center of the window
 * and randomly changes its location every second.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class LocationChangingSquare extends GraphicsProgram {

	/** Runs the program */
	public void run() {
		// Your code starts here
		GRect kare=new GRect(SQUARE_SIZE,SQUARE_SIZE);
		kare.setFilled(true);
		kare.setFillColor(rgen.nextColor());
		add(kare,getWidth()/2,getHeight()/2);
		relocate(kare);
		// Your code ends here
	}

	private void relocate(GRect square) {
		// Your code starts here
		while(true) {
			double x=rgen.nextDouble(0,getWidth()-square.getWidth());
			double y=rgen.nextDouble(0,getHeight()-square.getHeight());
			pause(500);
			square.setLocation(x, y);
			square.setFillColor(rgen.nextColor());
		}
		
		// Your code ends here
	}

	/** Size of the square in pixels */
	private static final int SQUARE_SIZE = 100;

	/** Pause time in milliseconds */
	private static final double PAUSE_TIME = 1000;

	/* Instance variables */

	private RandomGenerator rgen = new RandomGenerator();
}
