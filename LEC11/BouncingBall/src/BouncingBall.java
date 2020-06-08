/*
 * File: BouncingBall.java
 * -------------------------
 * This program animates a bouncing ball.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class BouncingBall extends GraphicsProgram {

	public void run() {

		GOval circle = new GOval(40, 410, RADIUS, RADIUS);
		circle.setFilled(true);
		circle.setFillColor(Color.red);
		add(circle);
		double dx = 5;
		double dy = 10;
		while(true) {
			// Check the boundaries and change movement parameters
			// Your code starts here
			if(getHeight()-circle.getHeight()<=circle.getY() || circle.getY()<=0) {
				dy=-dy;
			} if(getWidth()-circle.getWidth()<=circle.getX() || circle.getX()<=0) {
				dx=-dx;
			}
			// Your code ends here
			circle.move(dx, dy);
			pause(PAUSE_TIME);
		}
	}


	/* Private constants */
	private static final int PAUSE_TIME = 50;
	private static final double RADIUS = 50;

}
