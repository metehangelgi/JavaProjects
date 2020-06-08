/*
 * File: ColorChangingSquare.java
 * ------------------------------
 * This program puts up a square in the center of the window
 * and randomly changes its color every second.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class ColorChangingSquare extends GraphicsProgram {

	/** Runs the program */
	public void run() {
		// Your code starts here
		GRect rec1 =new GRect (0,0 ,SQUARE_SIZE,SQUARE_SIZE);
		
		double dx = (getWidth() - SQUARE_SIZE)/2;
		double dy = (getHeight() -SQUARE_SIZE)/2;
		GLabel lb1=new GLabel ("wtf",dx,dy+SQUARE_SIZE);
		
		rec1.setFilled(true);
		rec1.setFillColor(rgen.nextColor());
		add(rec1,dx,dy);
		add(lb1);
		
		for(int i=0;i<N_STEPS;i++) {
			Color mycolor=rgen.nextColor();
			println("my color is "+mycolor);
			lb1.setLabel(mycolor.toString());
			String label= lb1.getLabel();
			println(label+"safafaa");
			rec1.setFillColor(rgen.nextColor());
			pause(PAUSE_TIME);
		}
		
		// Your code ends here
	}

	/** Size of the square in pixels */
	private static final double SQUARE_SIZE = 100;

	/** Pause time in milliseconds */
	private static final double PAUSE_TIME = 1000;

	/* Instance variables */
	private static final int N_STEPS = 1000;

	private RandomGenerator rgen = RandomGenerator.getInstance();
}
