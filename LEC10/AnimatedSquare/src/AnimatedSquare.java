/*
 * File: AnimatedSquare.java
 * -------------------------
 * This program animates a square so that it moves from the
 * upper left corner of the window to the lower right corner.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class AnimatedSquare extends GraphicsProgram {

	public void run() {
		// Your code starts here
		GRect rec1 =new GRect (0,0 ,SQUARE_SIZE,SQUARE_SIZE);
		
		//double dx = (getWidth() - SQUARE_SIZE)/2;
		//double dy = (getHeight() -SQUARE_SIZE)/2;
		//double dx=0;
		//double dy=0;
		double dx=(getWidth()-rec1.getWidth())/N_STEPS;
		double dy=(getHeight()-rec1.getHeight())/N_STEPS;
		rec1.setFilled(true);
		rec1.setFillColor(Color.BLUE);
		add(rec1);
		
		while(rec1.getX()<=getWidth()-SQUARE_SIZE) {
			rec1.move(dx, dy);
			pause(PAUSE_TIME);
		}
		while(rec1.getY()>=getHeight()-SQUARE_SIZE) {
			rec1.move(-dx, -dy);
			pause(PAUSE_TIME);
		}
		
		
		// Your code ends here
	}


	/* Private constants */

	private static final double SQUARE_SIZE = 50;
	private static final int N_STEPS = 1000;
	private static final double PAUSE_TIME = 20;
}



























/*


double dx = (getWidth() - SQUARE_SIZE);
double dy = (getHeight() -SQUARE_SIZE);
rec1.setFilled(true);
rec1.setFillColor(Color.ORANGE);
println("The width canvas"+getWidth());
println("the height canvas "+ getHeight());
add(rec1,dx,dy);

for(int i=0;i<10;i++) {
	dx=-(getWidth()-SQUARE_SIZE)/10;
	dy=-(getHeight()-SQUARE_SIZE)/10;
	rec1.move(dx, dy);
	pause(PAUSE_TIME);
}
for(int i=0;i<N_STEPS;i++) {
	dx=-(getWidth()-SQUARE_SIZE)/N_STEPS;
	dy=-(getHeight()-SQUARE_SIZE)/N_STEPS;
	rec1.move(-dx, -dy);
	pause(20);
}

*/